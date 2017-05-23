package less06;

public class Main1 {

	public static void main(String[] args) {
		Hunter hunter = new Hunter("Ivan", 18);
		System.out.println(hunter);
//		hunter.name = "Ivan";
		hunter.eat("chicken");
		hunter.killMammont();
		Human human = new Hunter("Petro", 25);
		human.run();
		Object o = "sdf";
		System.out.println(o);
	}
}