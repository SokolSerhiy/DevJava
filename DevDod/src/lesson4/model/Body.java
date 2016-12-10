package lesson4.model;

public class Body {

	private String color;

	public Body(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Body [color=" + color + "]";
	}
}
