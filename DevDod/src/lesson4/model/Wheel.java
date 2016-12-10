package lesson4.model;

public class Wheel {

	private int diametr;

	public Wheel(int diametr) {
		this.diametr = diametr;
	}

	public int getDiametr() {
		return diametr;
	}

	public void setDiametr(int diametr) {
		this.diametr = diametr;
	}

	@Override
	public String toString() {
		return "Wheel [diametr=" + diametr + "]";
	}
}
