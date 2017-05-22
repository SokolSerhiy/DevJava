package less02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int a = 1;
		if (a == 1) {
			System.out.println("One");
		} else if (a == 2) {
			System.out.println("Two");
		} else {
			System.out.println("Three");
		}
		System.out.println("Switch:");
		switch (a) {
		case 1:
			System.out.println("One");
		case 2:
			System.out.println("Two");
		case 3:
			System.out.println("Three");
			break;
		default:
			System.out.println("More then three");
		}

		for (int i = 0; i < 10; ++i) {
			System.out.println(i);
		}
		int i = 0;
		while (i < 10) {
			i++;
			System.out.println(i);
		}
		System.out.println("Do While");
		do {
			i++;
			System.out.println(i);
		} while (i < 10);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number");
		// int res = sc.nextInt();
		// System.out.println("Result = "+res);
		System.out.println("Enter number with .");
		// double dRes = sc.nextDouble();
		// System.out.println("Result = "+dRes);
		System.out.println(Math.ceil(3.14));
		System.out.println(Math.floor(3.89));
		System.out.println(Math.round(3.14));
		System.out.println(Math.pow(2, 3));
		System.out.println(Math.sqrt(9));
		int c = -5;
		System.out.println(-c);
		sc.close();
	}
}