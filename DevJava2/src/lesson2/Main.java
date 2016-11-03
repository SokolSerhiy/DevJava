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
		
		if(!be){
			System.out.println("True");
		}else if(by>lessThen12){
			System.out.println("False");
		}else{
			System.out.println("Second else");
		}
		
		double a = 2;
		double b = 6;
		double c = 3;
		double desc = b*b-4*a*c;
		if(desc<0){
			System.out.println("shdghg");
		}else if(desc>0){
			System.out.println("x1 = "+((-b - Math.sqrt(desc))/(2*a)));
			System.out.println("x2 = "+((-b + Math.sqrt(desc))/(2*a)));
		}else{
			System.out.println("x = "+(-b/(2*a)));
		}
	}
}