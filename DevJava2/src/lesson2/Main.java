package lesson2;

public class Main {
	
	public static void main(String[] args) {
		boolean be = false;
		byte by = 12;
		short sh = 1;
		char ch = 'a';
		int i = 1;
		long l = 3000000000L;
		float f = 3.5f;
		double d = 3.5;
		int lessThen12 = 1;

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
			System.out.println("shdghg");
		} else if (desc > 0) {
			System.out.println("x1 = " + ((-b - Math.sqrt(desc)) / (2 * a)));
			System.out.println("x2 = " + ((-b + Math.sqrt(desc)) / (2 * a)));
		} else {
			System.out.println("x = " + (-b / (2 * a)));
		}

		switch (i) {
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;

		default:
			break;
		}
		i = 0;
		while(i<10){
			System.out.println(++i);
		}
		System.out.println("incr post " + sh++);//2
		System.out.println("incr pre "+(++sh));//3
		System.out.println("decr post " + sh--);//2
		System.out.println("decr pre "+(--sh));//1
		
		do{
			System.out.println(++i);
		}while(i<10);
		
		for(int j = 0; j < 10; j++){
			System.out.println(j);
		}
		
		int var;
		if(i>10){
			var = 10;
		}else{
			var = 20;
		}
		System.out.println("var = "+var);
		int var2 = i>10 ? 10 : 20;
		System.out.println("var2 = "+var2);
	}
}