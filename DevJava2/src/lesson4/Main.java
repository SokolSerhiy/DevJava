package lesson4;

public class Main {
	// int i = 65; i <= 90;
	// int i = 97; i <= 122;
	// int i = 48; i <= 57;
	public static void main(String[] args) {
		char[] array = new char[12];
		int d = 1;
		int l = 1;
		for (int i = 0; i < array.length; i++) {
			long rand = Math.round(Math.random() * 2);
			if (rand == 0&&d<=3) {
				long digitRand = Math.round(Math.random() * (57 - 48) + 48);
				array[i] = (char) digitRand;
				d++;
			} else if (rand == 1&&l<=2) {
				long upperCaseLetterRand = Math.round(Math.random() * (90 - 65) + 65);
				array[i] = (char) upperCaseLetterRand;
				l++;
			} else if (rand == 2&&i-d-l<5) {
				long letterRand = Math.round(Math.random() * (122 - 97) + 97);
				array[i] = (char) letterRand;
			} else {
				i--;
			}
		}
		System.out.println(array);
	}
}