package less18;

public class RunnebleForExecutor implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
}