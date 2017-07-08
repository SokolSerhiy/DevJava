package less20;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		new Daemon();
		Thread thread = new Thread(new Runnable1());
		thread.start();
		Thread thread2 = new Thread1();
		thread.join();
		thread2.join();
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute(new Task());
		service.execute(new Task());
		service.execute(new Task());
		service.execute(new Task());
		service.execute(new Task());
		service.execute(new Task());
		service.execute(new Task2());
		Future<String> future = service.submit(new Callable1());
		service.shutdown();
		System.out.println("Done");
		try {
			System.out.println(future.get(22, TimeUnit.SECONDS));
		} catch (ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
	}
}