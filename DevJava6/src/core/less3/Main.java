package core.less3;

public class Main {
	
	public static void main(String[] args) {
		Human.countOfPeople();
		Hunter hunter = new Hunter(18, "Ivan");
		hunter.eatMeat("bird meat");
		hunter.eatMeat();
		hunter.eatMeat();
		Human human = new Human(20, "Petro");
		System.out.println(human);
		System.out.println(hunter);
		ValueObject vo = new ValueObject(23, "Red");
		System.out.println(vo);
		int size = vo.size;
		int age = hunter.getAge();
		vo = vo.changeColor("Green");
		System.out.println(vo);
		Human.countOfPeople();
	}
}
