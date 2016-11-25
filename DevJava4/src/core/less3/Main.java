package core.less3;

public class Main {
	
	public static final int ERGHV_JHJH = 9;

	public final static void main(String[] args) {
		final Hunter hunter = new Hunter(18, "Ivan");
		hunter.eatMeat("bird meat");
		hunter.eatMeat();
		final Human human = new Human(20, "Petro");
		System.out.println(human);
		System.out.println(hunter);
		ValueObject vo = new ValueObject(23, "Red");
		System.out.println(vo);
		final int size = vo.size;
		vo = vo.changeSize(34);
		System.out.println(vo);
		Human.countOfPeople();
	}
}