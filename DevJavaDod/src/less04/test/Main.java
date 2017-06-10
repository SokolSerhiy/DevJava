package less04.test;

import less04.strategy.Location;

public class Main {

	public static void main(String[] args) {
		Human human = new Human();
		Human human1 = new Human();
		Human human2 = new Human();
		Location location = new Location("Lviv");
		location.addHumans(human, human1, human2);
	}

}
