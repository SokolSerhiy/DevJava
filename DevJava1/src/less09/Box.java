package less09;

public class Box {

	private Color color;

	private Cpu cpu;
	
	private Ram ram;

	public Box(Color color, Cpu cpu, Ram ram) {
		this.color = color;
		this.cpu = cpu;
		this.ram = ram;
	}

	public void turboBoost() {
		cpu.turboBoost();
	}

	public void addRam(Ram ram) {
		this.ram.addRam(ram);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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

	@Override
	public String toString() {
		return "Box [color=" + color + ", cpu=" + cpu + ", ram=" + ram + "]";
	}
}