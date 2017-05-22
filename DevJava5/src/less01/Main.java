package less01;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		boolean isMan;
		isMan = true;
		System.out.println(isMan);
		byte b = 127;
		System.out.println(b+1);
		++b;
		System.out.println(b);
		short sh = 32767;
		int in = 2147000000;
		long lo = 3147000000L;
//		b = b + b;
		char ch = 'd';
		System.out.println(ch+1);
		double d = 3.14;
		float f = 3.14f;
		System.out.println(f*2*5);
		in = in + 5;
		in += 5;
		in = in % 5;
		System.out.println(in);
		System.out.println(in++);
		System.out.println(++in);
		System.out.println(in>=5||in!=5);
	}
}