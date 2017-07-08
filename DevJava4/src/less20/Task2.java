package less20;

public class Task2 implements Runnable{

	@Override
	public void run() {
		System.out.println(Singleton.instance.i);
	}
}