package lesson2;

public class Main {

	public static void main(String[] args) {
		boolean be = false;
		int lessThen12 = 1;
		byte by = 12;
		short s = 23;
		char ca = 'a';
		int iw = 11;
		long l = 3000000000L;
		float f = 3.4f;
		double d = 3.4;
		if (!be) {
			System.out.println("True");
		} else if (by > lessThen12) {
			System.out.println("False");
		} else {
			System.out.println("Second else");
		}
		double a = 2;
		double b = 6;
		double c = 3;

		double desc = b * b - 4 * a * c;
		if (desc < 0) {
			System.out.println("Розв'язків немає");
		} else if (desc > 0) {
			System.out.println("x1 = " + ((-b + Math.sqrt(desc)) / 2 * a));
			System.out.println("x2 = " + ((-b - Math.sqrt(desc)) / 2 * a));
		} else {
			System.out.println("x = " + (-b / 2 * a));
		}
		
		

		switch (iw) {
		case 11:
			
			break;
		case 2:

			break;
		case 3:

			break;
		default:
			
			break;
		}
		
		int asdf = 1;
		while(asdf<10){
			System.out.println(asdf++);
		}
		System.out.println("do while");
		do{
			System.out.println(asdf++);
		}while(asdf<10);
		
		for(int i = 0; i < 10; i++){
			System.out.println(i);
		}
	}
}