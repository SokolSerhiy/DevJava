package core.less5;

public class Ram {

	private int frequency;
	
	private int capacity;

	public Ram(int frequency, int capacity) {
		this.frequency = frequency;
		this.capacity = capacity;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Ram [frequency=" + frequency + ", capacity=" + capacity + "]";
	}
}