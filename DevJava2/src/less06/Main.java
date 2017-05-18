package less06;

public class Main {

	public static void main(String[] args) {
		Human human1 = new Human("Ivan", 18);
//		human1.age = 18;
//		human1.name = "Ivan";
		human1.print();
		Human human2 = new Human("Petro", 25);
//		human2.age = 25;
//		human2.name = "Petro";
		human2.print();
		human1.print();
		human1.eat("chicken");
		human2.eat("meat");
		human1.run();
		human2.run();
		human1.run();
		human2.run();
		human1.drink(human1);
		human1.drink(human2);
	}
}