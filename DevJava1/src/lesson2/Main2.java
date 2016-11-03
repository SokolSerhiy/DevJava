package lesson2;

public class Main2 {

	public static void main(String[] args) {
		int i = 1;
		System.out.println("incr post " + i++);
		System.out.println("incr pre " + (++i));
		System.out.println("decr post " + i--);
		System.out.println("decr pre " + (--i));

		int c;
		if (i == 1) {
			c = 0;
		} else {
			c = 1;
		}
		System.out.println(c);
		int d = i == 1 ? 0 : 1;
		System.out.println(d);

		for (i = 1; i < 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i - j + 1 + " ");
			}
			System.out.println();
		}
		for (i = -1; i <= 9; i++) {
			if (i == -1) {
				System.out.print("* | ");
			} else {
				System.out.print(i + " | ");
			}
			for (int j = 1; j <= 9; j++) {
				if (i == -1) {
					System.out.print(j + "  ");
				} else if (i == 0) {
					System.out.print("___");
				} else {
					if (i * j > 9) {
						System.out.print(i * j + " ");
					} else {
						System.out.print(i * j + "  ");
					}
				}
			}
			System.out.println();
		}
		int k = 0;
		for (i = 1; i <= 300; i++) {
			if (i % 3 == 0 || i % 4 == 0) {
				System.out.println(i);
				k++;
			}
			if (k == 10) break;
		}
	}

}
