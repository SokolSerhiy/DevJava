package less18;

public class Demon extends Thread{

	public Demon() {
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		while(true){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println("Waiting........");
		}
	}
}