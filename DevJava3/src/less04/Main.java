package less04;

public class Main {

	public static void main(String[] args) {
		printHello();
		double asd = add(12, 56);
		System.out.println(asd);
		int[] array = new int[10];
		initArray(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		int a = 3;
		a = increment(a);
		System.out.println(a);
		
	}
	
	static int increment(int i){
		return ++i;
	}
	
	static void initArray(int[] array){
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random()*9+1);
		}
	}
	
	static double add(int a, int b){
		return a+b;
	}
	
	static void printHello(){
		System.out.println("Hello");
	}
}