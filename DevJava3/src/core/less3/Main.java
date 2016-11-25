package core.less3;

public class Main {

	public static void main(String[] args) {
		Human.countOfPeople();
		Hunter hunter = new Hunter(18, "Ivan");
		hunter.eatMeat("bird meat");
		hunter.eatMeat();
		hunter.eatMeat();
		Human human = new Human(20, "Petro");
		System.out.println(hunter);
		System.out.println(human);
		ValueObject object = new ValueObject(23, "Red");
		int size = object.size;
		object = object.changeColor("Green");
		System.out.println(object);
		Human.countOfPeople();
	}
}