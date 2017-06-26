package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Steven
 * Date:2017/6/23
 * Time:11:22
 */
@Slf4j
public class ReentrantLockTest implements Runnable {

	private int tickets = 100;
	private Lock lock = new ReentrantLock();

	@Override
	public void run() {
		while (true) {
			try{
				lock.lock();
				if(tickets > 0) {
					Thread.sleep(10);
					log.info("{} selling {}", Thread.currentThread().getName(), tickets);
					tickets --;
				}else {
					return;
				}
			}catch (Exception e) {
				log.error("{}", e);
			}finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		Runnable runnable = new ReentrantLockTest();
		Thread tr1 = new Thread(runnable, "1");
		Thread tr2 = new Thread(runnable, "2");
		Thread tr3 = new Thread(runnable, "3");
		Thread tr4 = new Thread(runnable, "4");

		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(tr1);
		service.execute(tr2);
		service.execute(tr3);
		service.execute(tr4);
		service.shutdown();
	}
}
