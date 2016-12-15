package core.less16;

public class Consumer extends Thread{

	public Consumer(String name) {
		setName(name);
//		this.setDaemon(true);
		this.start();
	}

	@Override
	public void run() {
		while(Singleton.getInstance().isStillRunning()||
			!Singleton.getInstance().isEmpty()){
			Integer task = Singleton.getInstance().getTask();
			if(task!=null){
				System.out.println(task+" consumer "+getName());
			}else{
				try {
					sleep(1);
				} catch (InterruptedException e) {
				}
			}
		}
	}
}