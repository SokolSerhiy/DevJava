package less20;

import java.util.concurrent.Callable;

public class Callable1 implements Callable<String> {

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "Hello from Callable";
	}

}
