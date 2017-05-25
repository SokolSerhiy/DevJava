package less08.figure;

public class Circle implements Figure{

	private final int r;

	public Circle(int r) {
		this.r = r;
	}

	@Override
	public double perimetr() {
		return 2*Math.PI*r;
	}

	@Override
	public double square() {
		return Math.PI*r*r;
	}
}