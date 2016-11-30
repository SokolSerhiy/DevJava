package core.less5;

public class Ram {

	private int volume;
	
	private int frequency;

	public Ram(int volume, int frequency) {
		this.volume = volume;
		this.frequency = frequency;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "Ram [volume=" + volume + ", frequency=" + frequency + "]";
	}
}