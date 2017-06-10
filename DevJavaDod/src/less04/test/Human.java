package less04.test;

import java.util.Random;

public class Human {

	int bellyful;
	
	int collectFood(){
		return new Random().nextInt(11)+5;
	}
	
	int collectWood(){
		eat();
		return new Random().nextInt(6)+15;
	}
	
	int collectStone(){
		eat();
		return new Random().nextInt(6)+10;
	}
	
	int collectIron(){
		eat();
		return new Random().nextInt(6)+5;
	}
	
	void eat(){
		bellyful-=new Random().nextInt(5)+1;
	}
}
