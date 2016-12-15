package core.less16;


public class Producer implements Runnable{
	
	private int timeout;
	
	public Producer(int timeout) {
		this.timeout = timeout;
		new Thread(this).start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(timeout);
			} catch (InterruptedException e) {
			}
			int rand = random(1, 100);
			Singleton.getInstance().addTask(rand);
			System.out.println("Producer "+ rand);
		}
	}
	
	public int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
}