package less07;

public class Main {

	public static void main(String[] args) {
		final Car car = new Car("X6", "BMW");
		System.out.println(car);
		final Car car1 = new Car("M3", "BMW");
//		String producer = car.producer;
		System.out.println(car.equalProducer(car1));
//		Main.main(args);
//		car.setModel("X6");
//		car.setModel("M3");
	}
}