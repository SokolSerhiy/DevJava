package lesson2;

public class Main {

	public static void main(String[] args) {
		int i = 0;
		switch (i) {
		default:
			System.out.println("Default");
			break;
		case 0:
			System.out.println("Zero");
			break;
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		}
		
		while(i<10){
			System.out.println(++i);
		}
		
		do{
			System.out.println(++i);
		}while(i<10);
		
		for(int j = 0; j < 10; j++){
			System.out.println(j);
			hello();
		}
		hello();
		int increment = increment(1);
		System.out.println(increment);
		
		System.out.println(calculate(45, 15, 'j'));
	}
	
	static void hello(){
		System.out.println("Hello");
	}
	
	static int increment(int i){
		i++;
		return i;
	}
	
	static double add(double a, double b){
		return a+b;
	}
	static double sub(double a, double b){
		return a-b;
	}
	static double div(double a, double b){
		return a/b;
	}
	static double mult(double a, double b){
		return a*b;
	}
	
	static double calculate(double a, double b, char oper){
		switch (oper) {
		case '+':
			return add(a, b);
		case '-':
			return sub(a, b);
		case '*':
			return mult(a, b);
		case '/':
			return div(a, b);
		default:
//			calculate(a, b, oper);
			return 0;
		}
	}
}