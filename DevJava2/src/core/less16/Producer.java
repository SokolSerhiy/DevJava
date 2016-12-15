package core.less16;

public class Producer implements Runnable{
	
	public Producer() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			Singleton.getInstance().addTask(i);
		}
		Singleton.getInstance().setStillRunning(false);
	}
	
	private int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
}