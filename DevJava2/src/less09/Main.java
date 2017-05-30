package less09;

public class Main {

	public static void main(String[] args) {
//		Color color = new Color();
//		Cpu cpu = new Cpu(3.5);
//		Ram ram = new Ram(8);
		Box box = new Box(Color.BLACK, new Cpu(3.5), new Ram(8));
		System.out.println(box);
//		box.getCpu().turboBoost();
		box.turboBoost();
		System.out.println(box);
//		box.getRam().addRam(new Ram(8));
		box.addRam(new Ram(8));
		System.out.println(box);
		
		System.out.println(Color.BLACK.name());
		System.out.println(Color.BLACK.ordinal());
		Color color = Color.valueOf("RED");
		System.out.println(color);
		double i = Double.valueOf("10");
		System.out.println(i);
		
	}
}