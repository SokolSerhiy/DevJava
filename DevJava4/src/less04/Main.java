package less04;

public class Main {

	public static void main(String[] args) {
		printHello();
		int[] array = new int[10];
		add(array, 1, 10);
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
	
	static void add(int[] array, int min, int max){
//		array = new int[5];
		for (int i = 0; i < array.length; i++) {
			array[i] = random(min, max);
		}
	}
	
	static int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}

	static void printHello(){
		System.out.println("Hello");
	}
}