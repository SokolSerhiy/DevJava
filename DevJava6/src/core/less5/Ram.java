package core.less5;

public class Ram {

	private int frequency;
	
	private int volume;

	public Ram(int frequency, int volume) {
		this.frequency = frequency;
		this.volume = volume;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
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