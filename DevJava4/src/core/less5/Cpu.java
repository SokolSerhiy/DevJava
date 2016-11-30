package core.less5;

public class Cpu {

	private double frequency;
	
	private int count;

	public Cpu(double frequency, int count) {
		this.frequency = frequency;
		this.count = count;
	}
	
	public void turboBoost(){
		frequency+=0.5;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Cpu [frequency=" + frequency + ", count=" + count + "]";
	}
}