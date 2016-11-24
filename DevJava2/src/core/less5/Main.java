package core.less5;

public class Main {

	public static void main(String[] args) {
		Computer computer = new Computer(new Hdd(1024), new Ram(1333, 8), new Cpu(3.4, 4));
		System.out.println(computer);
		Cpu cpu = computer.getCpu();
		cpu.turboBoost();
		computer.turboBoost();
		computer.getCpu().setCount(8);
		System.out.println(computer);
		Computer computer2 = new Computer(1024, 1333, 8, 4.3, 8);
		System.out.println(computer2);
		Computer computer3 = new Computer();
		computer3.getCpu().setCount(4);
		computer3.getCpu().setFrequency(3.2);
		computer3.getHdd().setCapacity(2048);
		computer3.getRam().setFrequency(1333);
		computer3.getRam().setVolume(4);
	}
}