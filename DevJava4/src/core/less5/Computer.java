package core.less5;

public class Computer {

	private String vendor;

	private Cpu cpu;

	private Ram ram;

	private Hdd hdd;

	public Computer(String vendor, Cpu cpu, Ram ram, Hdd hdd) {
		this.vendor = vendor;
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}

	public Computer(String vendor, double cpuFrequency, int count,
			int ramFrequency, int volume, int capacity) {
		this.vendor = vendor;
		this.cpu = new Cpu(cpuFrequency, count);
		this.ram = new Ram(ramFrequency, volume);
		this.hdd = new Hdd(capacity);
	}

	public void turboBoost() {
		cpu.turboBoost();
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
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
		return "Computer [vendor=" + vendor + ", cpu=" + cpu + ", ram=" + ram
				+ ", hdd=" + hdd + "]";
	}
}