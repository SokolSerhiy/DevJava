package core.less5;

public class Computer {

	private Hdd hdd;

	private Ram ram;

	private Cpu cpu;

	public Computer(Hdd hdd, Ram ram, Cpu cpu) {
		this.hdd = hdd;
		this.ram = ram;
		this.cpu = cpu;
	}

	public Computer(int capacity, int ramFrequency, int volume,
			double cpuFrequency, int count) {
		this.hdd = new Hdd(capacity);
		this.ram = new Ram(ramFrequency, volume);
		this.cpu = new Cpu(cpuFrequency, count);
	}
	
	

	public Computer() {
		this.hdd = new Hdd();
		this.ram = new Ram();
		this.cpu = new Cpu();
	}

	public void turboBoost() {
		cpu.turboBoost();
	}

	public Hdd getHdd() {
		return hdd;
	}

	public void setHdd(Hdd hdd) {
		this.hdd = hdd;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	@Override
	public String toString() {
		return "Computer [hdd=" + hdd + ", ram=" + ram + ", cpu=" + cpu + "]";
	}
}
