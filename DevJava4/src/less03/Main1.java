package less03;

import java.util.Random;
import java.util.UUID;

public class Main1 {

	public static void main(String[] args) {
		System.out.println((int)(Math.random()*6+4));
		System.out.println(Math.round(Math.random()*6+3));
		Random random = new Random();
		System.out.println(random.nextInt(6)+3);
		System.out.println(UUID.randomUUID());
	}
}
