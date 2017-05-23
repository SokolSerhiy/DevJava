package less06;

public class Main1 {

	public static void main(String[] args) {
		Hunter hunter = new Hunter("Petro", 18);
//		hunter.name = ;
		hunter.eat("bird meat");
		hunter.killMammont();
		Human human = new Hunter("Mykola", 25);
		human.run();
		System.out.println(human);
		Object o = "afasdfa";
		System.out.println(o);
	}
}