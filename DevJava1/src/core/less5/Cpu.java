package core.less5;

public class Cpu {

	private int count;
	
	private double frequency;

	public Cpu(int count, double frequency) {
		this.count = count;
		this.frequency = frequency;
	}

	public Cpu() {}
	
	public void turboBoost(){
		frequency+=0.5;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "Cpu [count=" + count + ", frequency=" + frequency + "]";
	}
}
