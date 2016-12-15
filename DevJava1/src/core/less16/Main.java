package core.less16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
	
	private static ExecutorService service = Executors.newFixedThreadPool(5);

	public static void main(String[] args) {
		new Producer(500);
		new Producer(500);
		new Producer(500);
		new Producer(500);
		new Consumer();
		System.out.println("Done");
		new Thread(()->{
			
		}).start();
		service.shutdown();
	}
}