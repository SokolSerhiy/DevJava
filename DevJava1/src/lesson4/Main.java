package lesson4;

public class Main {
	// (int i = 65; i < 91; i++)
	// (int i = 97; i < 123; i++)
	// (int i = 48; i < 58; i++)
	public static void main(String[] args) {
		char[] array = new char[12];
		for (int i = 0; i < array.length; i++) {
			int way = (int) Math.round(Math.random() * (2 - 0));
			double rand = Math.random();
			switch (way) {
			case 0:
				array[i] = (char) Math.round(rand * (91 - 65) + 65);
				break;
			case 1:
				array[i] = (char) Math.round(rand * (123 - 97) + 97);
				break;
			case 2:
				array[i] = (char) Math.round(rand * (58 - 48) + 48);
				break;
			}
		}
		System.out.println(array);
	}
}