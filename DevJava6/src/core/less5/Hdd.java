package core.less5;

public class Hdd {

	private int capacity;

	public Hdd(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Hdd [capacity=" + capacity + "]";
	}
}