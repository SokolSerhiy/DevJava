package less09;

public class Circle implements Figure{
	
	private final int r;

	public Circle(int r) {
		this.r = r;
	}

	@Override
	public double square() {
		return Math.PI*r*r;
	}

	@Override
	public double perimetr() {
		return Math.PI*2*r;
	}
}