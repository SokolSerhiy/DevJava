package lesson4.model;

public class Helm {

	private boolean haveButtons;
	
	private int diametr;

	public Helm(boolean haveButtons, int diametr) {
		this.haveButtons = haveButtons;
		this.diametr = diametr;
	}

	public boolean isHaveButtons() {
		return haveButtons;
	}

	public void setHaveButtons(boolean haveButtons) {
		this.haveButtons = haveButtons;
	}

	public int getDiametr() {
		return diametr;
	}

	public void setDiametr(int diametr) {
		this.diametr = diametr;
	}

	@Override
	public String toString() {
		return "Helm [haveButtons=" + haveButtons + ", diametr=" + diametr
				+ "]";
	}
}
