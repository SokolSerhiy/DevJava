package lesson4.model;

public class Car {

	private Body body;
	
	private Helm helm;
	
	private Wheel wheel;

	public Car(String color, boolean haveButtons, int helmDiametr, int wheelDiametr) {
		this.body = new Body(color);
		this.helm = new Helm(haveButtons, helmDiametr);
		this.wheel = new Wheel(wheelDiametr);
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Helm getHelm() {
		return helm;
	}

	public void setHelm(Helm helm) {
		this.helm = helm;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	@Override
	public String toString() {
		return "Car [body=" + body + ", helm=" + helm + ", wheel=" + wheel
				+ "]";
	}
}