package less17;

public class SomeC implements SomeI{

	@Override
	public void aaaa() {
		System.out.println("aaaa");
	}
	@Override
	@CustomLogic
	public void bbbb() {
		System.out.println("bbbb");
	}
	@Override
	@CustomLogic
	public void cccc() {
		System.out.println("cccc");
	}
}