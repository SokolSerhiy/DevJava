package less20;

import java.util.concurrent.atomic.AtomicInteger;

public class Singleton {

	public static final Singleton instance = new Singleton();
	
	public final AtomicInteger i = new AtomicInteger(0);
	
	private Singleton() { }
}
