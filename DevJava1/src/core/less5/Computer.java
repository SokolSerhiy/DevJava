package core.less5;

public class Computer {

	private Cpu cpu;

	private Ram ram;

	private Hdd hdd;

	public Computer(Cpu cpu, Ram ram, Hdd hdd) {
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}

	public Computer(int cpuCount, double cpuFrequency, double ramFrequency,
			int ramVolume, int hddVolume) {
		this.cpu = new Cpu(cpuCount, cpuFrequency);
		this.ram = new Ram(ramFrequency, ramVolume);
		this.hdd = new Hdd(hddVolume);
	}

	public void turboBoost() {
		cpu.turboBoost();
	}

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public Hdd getHdd() {
		return hdd;
	}

	public void setHdd(Hdd hdd) {
		this.hdd = hdd;
	}

	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + ", ram=" + ram + ", hdd=" + hdd + "]";
	}
}
