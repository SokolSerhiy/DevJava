package less20;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		new Deamon();
		Thread thread = new Thread(new Runnable1());
		thread.start();
		Thread thread2 = new Thread1();
		thread.join();
		thread2.join();
		System.out.println("Done");
		ExecutorService service = Executors.newWorkStealingPool();
		service.execute(new Task());
		service.execute(new Task());
		service.execute(new Task());
		service.execute(new Task());
		service.execute(new Task());
		service.execute(new Task());
		service.execute(new Task2());
		Future<String> future = service.submit(new Callable1());
		service.shutdown();
		try {
			System.out.println(future.get(22, TimeUnit.SECONDS));
		} catch (ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
	}
}