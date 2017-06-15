package less18;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		new Demon();
		Thread thread1 = new Thread(new Runnable1());
		Thread thread2 = new Thread2();
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println("By-by");
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute(new RunnebleForExecutor());
		service.execute(new RunnebleForExecutor());
		service.execute(new RunnebleForExecutor());
		service.execute(new RunnebleForExecutor());
		service.execute(new RunnebleForExecutor());
//		service.execute(new RunnebleForExecutor());
		Future<String> future = service.submit(new CallableForExecutor());
		service.shutdown();
		System.out.println(future.get(22, TimeUnit.SECONDS));
	}
}