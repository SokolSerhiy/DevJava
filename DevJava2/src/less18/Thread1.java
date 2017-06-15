package less18;

public class Thread1 extends Thread{

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		System.out.println("Hello from Thread1");
	}
}
