package less09;

public class Main {

	public static void main(String[] args) {
//		Color color = Color.GREEN;
		Cpu cpu = new Cpu(3.4);
		Ram ram = new Ram(8);
		Box box = new Box(Color.GREEN, cpu, ram);
		System.out.println(box);
//		box.getCpu().turboBoost();
		box.turboBoost();
		System.out.println(box);
//		box.getRam().addRam(new Ram(8));
		box.addRam(new Ram(8));
		System.out.println(box);
		System.out.println(Color.BLUE.name());
		System.out.println(Color.BLUE.ordinal());
		Color color = Color.valueOf("RED");
		System.out.println(color);
		double i = Double.valueOf("10");
		System.out.println(i);
	}
}