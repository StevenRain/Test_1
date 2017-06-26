package thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Steven
 * Date:2017/6/22
 * Time:16:14
 */
@Slf4j
public class BlockingQueueTest {

	static class Producer implements Runnable{

		private BlockingQueue<Integer> queue;

		public Producer(BlockingQueue<Integer> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try{
					Integer value = new Random().nextInt();
					queue.put(value);
					log.info("生产 {}", value);
					Thread.sleep(100);
				}catch (Exception e) {
					log.error("{}", e);
				}
			}
		}
	}

	static class Consumer implements Runnable {

		private BlockingQueue<Integer> queue;

		public Consumer(BlockingQueue<Integer> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try{
					Integer value = queue.take();
					log.info("消费 {}", value);
					Thread.sleep(100);
				}catch (Exception e) {
					log.error("{}", e);
				}
			}
		}
	}

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

		ExecutorService service = Executors.newCachedThreadPool();

		Thread producer1 = new Thread(new Producer(queue));
		Thread producer2 = new Thread(new Producer(queue));
		Thread producer3 = new Thread(new Producer(queue));
		Thread consumer = new Thread(new Consumer(queue));

		service.execute(producer1);
		service.execute(producer2);
		service.execute(producer3);
		service.execute(consumer);

		service.shutdown();
	}
}
