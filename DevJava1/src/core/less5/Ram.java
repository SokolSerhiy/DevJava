package core.less5;

public class Ram {

	private double frequency;
	
	private int volume;

	public Ram(double frequency, int volume) {
		this.frequency = frequency;
		this.volume = volume;
	}
	
	public Ram(){}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Ram [frequency=" + frequency + ", volume=" + volume + "]";
	}
}
