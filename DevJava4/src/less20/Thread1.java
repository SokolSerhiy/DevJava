package less20;

public class Thread1 extends Thread{

	public Thread1() {
		start();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello from Thread");
		Singleton.instance.i.getAndIncrement();
	}

	
}
