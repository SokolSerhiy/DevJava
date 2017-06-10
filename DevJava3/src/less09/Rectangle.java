package less09;

public class Rectangle implements Figure{

	private final int a;
	
	private final int b;

	public Rectangle(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public double perimetr() {
		return 2*(a+b);
	}

	@Override
	public double square() {
		return a*b;
	}
}