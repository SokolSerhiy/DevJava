package core.less16;


public class Consumer extends Thread{

	public Consumer() {
		this.setDaemon(true);
		this.start();
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("Consumer "+Singleton.getInstance().getTask());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}