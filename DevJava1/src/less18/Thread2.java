package less18;

public class Thread2 extends Thread{

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		System.out.println("Hello Thread2");
	}
}