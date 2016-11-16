package lesson7;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter max");
		int max = sc.nextInt();
		int random = random(1, max);
		while (true) {
			System.out.println("Try:");
			int res = sc.nextInt();
			if (res == random) {
				System.out.println("You win");
				System.exit(0);
			} else if (res > random) {
				System.out.println("Enter less");
			} else {
				System.out.println("Enter bigger");
			}
		}
	}

	public static int random(int min, int max) {
		return (int) Math.round(Math.random() * (max - min) + min);
	}
}
