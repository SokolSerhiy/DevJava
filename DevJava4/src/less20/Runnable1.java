package less20;

public class Runnable1 implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello from Runnable");
		Singleton.instance.i.getAndIncrement();
	}

}
