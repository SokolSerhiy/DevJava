package less18;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		new Daemon();
		Thread thread = new Thread(new Runnable1());
		Thread1 thread2 = new Thread1();
		thread.start();
		thread2.start();
		thread.join();
		thread2.join();
		System.out.println("By-by");
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute(new RunnableForExecutor());
		service.execute(new RunnableForExecutor());
		service.execute(new RunnableForExecutor());
		service.execute(new RunnableForExecutor());
		Future<String> future = service.submit(new CallableForExecutor());
		service.shutdown();
		System.out.println(future.get(12, TimeUnit.SECONDS));
	}
}