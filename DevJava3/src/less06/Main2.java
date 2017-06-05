package less06;

public class Main2 {

	public static void main(String[] args) {
		Hunter hunter = new Hunter();
		hunter.name = "Ivan";
		hunter.eat();
		hunter.walk();
		Human human = new Hunter();
		human.run();
		System.out.println(""+hunter);
		System.out.println(human);
	}

}
