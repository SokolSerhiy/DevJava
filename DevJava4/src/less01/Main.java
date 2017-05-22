package less01;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		boolean isMan;
		isMan = true;
		System.out.println(isMan);
		boolean isWoman = false;
		byte b = 127;
		System.out.println(b+1);
		b++;
		System.out.println(b);
		short sh = 032767;
		System.out.println(sh);
		int in = 2000000000;
		long lo = 3000000000L;
		char ch = 'd';
		System.out.println(ch+1);
		double d = 3.14;
		float f = 3.14f;
		System.out.println(f*2*5);
		in = 1;
		System.out.println(in++);
		System.out.println(++in);
		System.out.println(in>=5||in!=5);
		in = in % 2;
		in+=3;
		System.out.println(in);
	}
}