package less06;

public class Main2 {

	public static void main(String[] args) {
		Hunter hunter = new Hunter();
		hunter.name = "Ivan";
		hunter.eat("bird meat");
		hunter.eat();
		hunter.eat();
		hunter.walk();
		Human human = new Hunter("Mykola", 18);
		human.run();
		System.out.println(human);
		
	}
}