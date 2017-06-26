package thread;


import lombok.extern.slf4j.Slf4j;

/**
 * Created by Steven
 * Date:2017/6/22
 * Time:9:59
 */
@Slf4j
public class Model {

	static class Producer extends Thread{

		private ThreadLocal<Integer> number = new ThreadLocal<>();

		public Producer(ThreadLocal<Integer> number) {
			this.number = number;
		}

		public void produce() {
			while (true) {
				if(number.get() != null) {
					log.info("生产 {}", number.get());
					number.set(number.get() + 1);
				}
			}
		}

		@Override
		public void run() {
			produce();
		}
	}

	static class Consumer extends Thread {

		private ThreadLocal<Integer> number;

		public Consumer(ThreadLocal<Integer> number) {
			this.number = number;
		}

		public void consume() {
			while (true) {
				if(number.get() != null) {
					number.set(number.get() - 1);
					log.info("消费 {}", number.get());
				}
			}
		}

		@Override
		public void run() {
			consume();
		}
	}

	public static void main(String[] args) {

		ThreadLocal<Integer> number = ThreadLocal.withInitial(() -> 0);


		Thread producer1 = new Producer(number);
		Thread producer2 = new Producer(number);
		Thread producer3 = new Producer(number);
		Thread consumer1 = new Consumer(number);
		Thread consumer2 = new Consumer(number);

		log.info("start");

		producer1.start();
		producer2.start();
		producer3.start();
		consumer1.start();
		consumer2.start();
	}
}
