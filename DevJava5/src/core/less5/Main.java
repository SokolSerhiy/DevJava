package core.less5;

public class Main {

	public static void main(String[] args) {
//		Cpu cpu = new Cpu(3.4, 4);
//		Ram ram = new Ram(1333, 4);
//		Hdd hdd = new Hdd(1);
//		Computer computer = new Computer("Asus", cpu, ram, hdd);
		Computer computer = new Computer("Asus", new Cpu(3.4, 4), new Ram(1333, 4), new Hdd(1));
		System.out.println(computer);
		computer.turboBoost();
		System.out.println(computer);
		computer.getRam().setCapacity(8);
		System.out.println(computer);
		Computer computer2 = new Computer("Dell", 4, 4, 1666, 4, 4);
		System.out.println(computer2);
	}
}