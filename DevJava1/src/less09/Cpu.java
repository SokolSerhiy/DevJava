package less09;

public class Cpu {

	private double frequency;

	public Cpu(double frequency) {
		this.frequency = frequency;
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

	@Override
	public String toString() {
		return "Cpu [frequency=" + frequency + "]";
	}
}