package less21;

public class Work implements IWork{

	@Override
	@Wrapper(after="My After")
	public void doWork1() {
		System.out.println("work 1");
	}

	@Override
	@Wrapper(before="My before")
	public void doWork2() {
		System.out.println("work 2");
	}
}