package less01;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		boolean isMan;
		isMan = true;
		System.out.println(isMan);
		boolean isWomen = false;
		System.out.println(isWomen);
		byte b = 127;
		System.out.println(b+1);
		b++;
		System.out.println(b);
		short sh = 032767;
		int in = 2000000000;
		long lo = 3000000000L;
		System.out.println(sh);
		double d = 3.14;
		float f = 3.14f;
		System.out.println(d*2*5);
		char ch = 'd';
		System.out.println(ch+1);
		System.out.println(Integer.MAX_VALUE);
		in = in + 5;
		in += 5;
		b = (byte) (b % 5);
		System.out.println(b);
		in = 1;
		System.out.println(in++);
		System.out.println(++in);
		System.out.println(in--);
		System.out.println(--in);
		System.out.println(in!=4);
		System.out.println(in<=4||in>4);
	}
}