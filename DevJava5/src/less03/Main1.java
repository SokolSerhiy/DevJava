package less03;

import java.util.Random;
import java.util.UUID;

public class Main1 {

	public static void main(String[] args) {
		System.out.println(Math.random()*10+5);
		System.out.println(Math.round(Math.random()*10+5));
		Random random = new Random();
		System.out.println(random.nextInt(10)+5);
		System.out.println(UUID.randomUUID());
	}
}