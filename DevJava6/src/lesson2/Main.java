package lesson2;

public class Main {

	public static void main(String[] args) {
		int i = 0;
		switch (i) {
		case 0:
			System.out.println("Zero");
			break;
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		default:
			System.out.println("Default");
		}
		while (i < 10) {
			System.out.println(++i);
			hello();
		}
		do {
			System.out.println(++i);
			hello();
		} while (i < 10);
		hello();

		for (int j = 0; j < 10; j++) {
			System.out.println(j);
			hello();
		}
		hello();
		int increment = increment(1);
		System.out.println(increment);
		System.out.println(calculate(1, 2, '+'));
	}

	static void hello() {
		System.out.println("Hello");
	}

	static int increment(int i) {
		i++;
		return i;
	}

	static double add(double a, double b) {
		return a + b;
	}

	static double sub(double a, double b) {
		return a - b;
	}

	static double mult(double a, double b) {
		return a * b;
	}

	static double div(double a, double b) {
		return a / b;
	}

	static double calculate(double a, double b, char operator) {
		switch (operator) {
		case '+': return add(a, b);
		case '-': return sub(a, b);
		case '*': return mult(a, b);
		case '/': return div(a, b);
		default: calculate(a, b, operator); return 0;
		}
	}
}