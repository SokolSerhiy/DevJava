package core.less3;

import static core.less3.Human.countOfPeople;

public class Main {

	public static void main(String[] args) {
		countOfPeople();
		Hunter hunter = new Hunter(18, "Ivan");
		countOfPeople();
		hunter.eatMeat("bird meat");
		hunter.eatMeat();
		hunter.eatMeat();
		System.out.println(hunter.toString());
		Human human = new Human(20, "Vasyl");
		System.out.println(human);
		countOfPeople();
		
		ValueObject vo = new ValueObject("Red", 34);
		System.out.println(vo);
		vo = vo.changeColor("Green");
		System.out.println(vo);
	}
}