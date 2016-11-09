package lesson2;

public class Main {

	public static void main(String[] args) {
		int i = 0;
		while (i < 10) {
			System.out.println(++i);
		}
		do {
			System.out.println(++i);
		} while (i < 10);

		for (int j = 0; j < 10; j++) {
			System.out.println("j = " + j);
		}
		hello();
		hello();
		hello();
		int increment = increment(1);
		System.out.println(increment);
		double res = calculate(5, 8, '/');
		System.out.println(res);
		
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

	static double div(double a, double b) {
		return a / b;
	}

	static double mult(double a, double b) {
		return a * b;
	}

	static double calculate(double a, double b, char oper) {
		switch (oper) {
		case '+':
			return add(a, b);
		case '-':
			return sub(a, b);
		case '*':
			return mult(a, b);
		default:
			return div(a, b);
		}
	}
}