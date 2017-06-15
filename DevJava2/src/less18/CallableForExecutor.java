package less18;

import java.util.concurrent.Callable;

public class CallableForExecutor implements Callable<String>{

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "Hello from Callable";
	}
}