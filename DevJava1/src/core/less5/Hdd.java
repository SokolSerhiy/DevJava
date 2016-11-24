package core.less5;

public class Hdd {

	private int volume;

	public Hdd(int volume) {
		this.volume = volume;
	}

	public Hdd() {}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Hdd [volume=" + volume + "]";
	}
}