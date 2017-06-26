package thread;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Steven
 * Date:2017/6/21
 * Time:17:40
 */
@Slf4j
public class Ticket implements Runnable {

	private int tickets = 100;

	@Override
	@Synchronized
	public void run() {
		while (true) {
			if(tickets > 0) {
				try{
					Thread.sleep(10);
				}catch (Exception e) {
					log.error("{}", e);
				}
				log.info("{} selling {}", Thread.currentThread().getName(), tickets);
				tickets --;
			}else {
				return;
			}
		}
	}

	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		new Thread(ticket, "1").start();
		new Thread(ticket, "2").start();
		new Thread(ticket, "3").start();
		new Thread(ticket, "4").start();
	}
}
