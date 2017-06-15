package less18;

public class Daemon extends Thread{

	public Daemon() {
		this.setDaemon(true);
		this.start();
	}

	@Override
	public void run() {
		while(true){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println("Waiting......");
		}
	}
}