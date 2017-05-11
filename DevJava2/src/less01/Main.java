package less01;

public class Main {

	public static void main(String[] args) {
		System.out.print("Hello!!!");
		boolean isMale;// оголошення
		isMale = false;// ініціалізація
		System.out.println(isMale);
		boolean isFemale = true;//оголошення з ініціалізацією
		System.out.println(isFemale);
		byte b = (byte) 510;
		short sh = 2;
		int i = 3;
		long l = 4000000000L;
		System.out.println(b);
		b = 127;
		System.out.println(b+Integer.MAX_VALUE);
		System.out.println(b+Integer.MAX_VALUE - Integer.MIN_VALUE);
		double d = 3.6;
		float f = 3.6f;
		System.out.println(3.14*2*5);
	}
}