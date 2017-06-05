package less06;

public class Main {

	public static void main(String[] args) {
		Human human = new Human();
		human.age = 18;
		human.name = "Ivan";
		human.printData();
		human.run();
		Human human2 = new Human("Mykola", 25);
		System.out.println(human2);
	}
}