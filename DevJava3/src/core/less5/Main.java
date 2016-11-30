package core.less5;

public class Main {

	public static void main(String[] args) {
//		Cpu cpu = new Cpu(3.4, 4);
//		Ram ram = new Ram(8, 1333);
//		Hdd hdd = new Hdd(2);
//		Computer computer = new Computer("Dell", cpu, ram, hdd);
		Computer computer = new Computer("Dell", new Cpu(3.4, 4), new Ram(8, 1333), new Hdd(2));
		Cpu cpu = computer.getCpu();
		System.out.println(computer);
		computer.turboBoost();
		System.out.println(computer);
		computer.getRam().setVolume(16);
		System.out.println(computer);
		Computer computer2 = new Computer("Asus", 4.0, 4, 4, 1333, 4);
		System.out.println(computer2);
	}
}