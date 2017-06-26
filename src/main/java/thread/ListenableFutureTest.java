package thread;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * Created by Steven
 * Date:2017/6/23
 * Time:16:54
 */
public class ListenableFutureTest {

	static class FutureCallbackImpl implements FutureCallback {

		private String result;

		@Override
		public void onSuccess(Object o) {
			System.out.println("成功");
			result = o.toString();
		}

		@Override
		public void onFailure(Throwable throwable) {
			System.out.println("失败");
		}

		public String getResult() {
			return result;
		}
	}

	public static void main(String[] args) {
		ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
		Callable<String> callable = () -> "success";
		ListenableFuture<String> futureTask = executorService.submit(callable);

		FutureCallbackImpl callbackTask = new FutureCallbackImpl();
		Futures.addCallback(futureTask, callbackTask);
		System.out.println(callbackTask.getResult());
		executorService.shutdown();
	}
}
