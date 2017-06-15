package less18;

public class Runnable1 implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		System.out.println("Hello Thread1");
	}
}