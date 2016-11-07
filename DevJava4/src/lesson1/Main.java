package lesson1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		boolean bool = false;
		byte by = 1;
		short sh = 1;
		char ch = 'f';
		int i = 1;
		long l = 3000000000L;
		float f = 3.4f;
		double d = 3.4;

		if (i < 0) {
			System.out.println("True");
		} else if (!bool) {
			System.out.println("False");
		} else {
			System.out.println("Second else");
		}
		double a = 2;
		double b = 6;
		double c = 4;

		double desc = b * b - 4 * a * c;
		if (desc < 0) {
			System.out.println("D<0");
		} else if (desc > 0) {
			double x1 = (-b - Math.sqrt(desc)) / (2 * a);
			double x2 = (-b + Math.sqrt(desc)) / (2 * a);
			System.out.println("x1 = " + x1 + " x2 = " + x2);
		} else {
			System.out.println("x = " + (-b / (2 * a)));
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number");
		int res = sc.nextInt();
		System.out.println(res);
	}

}