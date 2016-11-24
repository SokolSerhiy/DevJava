package core.less5;

public class Main {

	public static void main(String[] args) {
		Computer computer = new Computer(new Cpu(4, 3.4), new Ram(1333, 8), new Hdd(1024));
		System.out.println(computer);
		computer.turboBoost();
		System.out.println(computer);
		computer.getCpu().setCount(8);
		System.out.println(computer);
		computer.setCpu(new Cpu(8, 4.5));
		System.out.println(computer);
		Computer computer1 = new Computer(4, 3.5, 1333, 4, 1024);
		System.out.println(computer1);
	}
}