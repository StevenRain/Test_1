package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Steven
 * Date:2017/6/23
 * Time:13:47
 */
@Slf4j
public class FutureTest {


//	public static void main(String[] args) {
//		Callable<String> callable = () -> "Succeed";
//		FutureTask<String> future = new FutureTask<>(callable);
//		new Thread(future).start();
//
//		log.info("start");
//		if(future.isDone()) {
//			try{
//				String result = future.get();
//				log.info("{}",result);
//			}catch (Exception e) {
//				log.error("{}", e);
//			}
//		}
//	}


	public static void main(String[] args) {
		Callable<String> callable = () -> "Succeed";

		ExecutorService service = Executors.newCachedThreadPool();
		Future<String> future = service.submit(callable);

		log.info("start");
		try{
			String result = future.get();
			log.info("{}", result);
		}catch (Exception e) {
			log.error("{}", e);
		}
		service.shutdown();
	}
}
