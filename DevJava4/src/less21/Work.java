package less21;

public class Work implements IWork{

	@Override
	@Wrapper(after="My after", before="My before")
	public void doWork1() {
		System.out.println("work 1");
	}
	@Wrapper
	@Override
	public void doWork2() {
		System.out.println("work 2");
	}

}
