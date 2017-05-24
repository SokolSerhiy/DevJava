package less03;

import java.util.Random;
import java.util.UUID;

public class Mian1 {

	public static void main(String[] args) {
		System.out.println((int) (Math.random() * 10 + 5 + 1));
		System.out.println(Math.round(Math.random() * 10 + 5));
		Random random = new Random();
		System.out.println(random.nextInt(10));
		System.out.println(UUID.randomUUID());
	}
}