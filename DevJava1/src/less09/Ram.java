package less09;

public class Ram {

	private int volume;

	public Ram(int volume) {
		this.volume = volume;
	}
	
	public void addRam(Ram ram){
		volume+= ram.volume;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Ram [volume=" + volume + "]";
	}
}
