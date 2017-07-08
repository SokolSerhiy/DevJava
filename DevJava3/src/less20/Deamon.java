package less20;

public class Deamon extends Thread{

	public Deamon() {
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		while(true){
			System.out.println("Loading...");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}
