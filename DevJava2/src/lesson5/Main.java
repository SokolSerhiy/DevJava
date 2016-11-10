package lesson5;

public class Main {

	public static void main(String[] args) {
		hello();
		hello();
		int a = 1;
		int increment = increment(a);
		System.out.println(increment);
		System.out.println(calculate(3, 5, '/'));
	}
	
	static void hello(){
		System.out.println("Hello");
	}
	
	static int increment(int i){
		//int i = 1;
		i++;
		return i;
	}
	
	static double add(double a, double b){
		return a+b;
	}
	static double sub(double a, double b){
		return a-b;
	}
	static double mult(double a, double b){
		return a*b;
	}
	static double div(double a, double b){
		return a/b;
	}
	
	static double calculate(double a, double b, char operator){
		switch (operator) {
		case '+':return add(a, b);
		case '-':return sub(a, b);
		case '*':return mult(a, b);
		case '/':return div(a, b);
		default: return 0;
		}
	}
	
}