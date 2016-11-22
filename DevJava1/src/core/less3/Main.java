package core.less3;

public class Main {

	public static void main(String[] args){
		Human.countOfPeople();
		Hunter hunter = new Hunter(18, "Ivan");
		Human.countOfPeople();
		hunter.eatMeat("bird meat");
		hunter.killMammont();
		String name = hunter.getName();
		hunter.setName(name);
		Human human = new Human(20, "Petro");
		System.out.println(human);
		System.out.println(hunter);
		Human.countOfPeople();
		System.out.println(Math.PI);
		
		ValueObject vo = new ValueObject("Red", 23);
		vo = vo.changeSize(34);
	}

}
