package less20;

public class Daemon extends Thread{

	public Daemon() {
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("Loading...");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}
