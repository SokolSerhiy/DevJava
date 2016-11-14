package lesson4;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[10];
		print(array);
		int a = 5;
		int b = a;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		a = 6;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		int[] a1 = new int[1];
		int[] b1 = a1;
		a1[0] = 5;
//		b1[0] = 5;
		System.out.println("a1 = " + a1[0]);
		System.out.println("b1 = " + b1[0]);
		a1[0] = 6;
		System.out.println("a1 = " + a1[0]);
		System.out.println("b1 = " + b1[0]);
		add(array);
		print(array);
		useless(a);
		System.out.println(a);
		addRandom(array, 1, 10);
		print(array);
		int[] array1 = create(10, 1, 20);
		print(array1);
		array1 = increase(array1, -1);
		print(array1);
	}
	
	static void useless(int a){
		a = a + 5;
	}
	
	static int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
	
	static void print(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	static void add(int[] array){
		for (int i = 0; i < array.length; i++) {
			array[i] = i+1;
		}
	}
	
	static void addRandom(int[] array, int min, int max){
		for (int i = 0; i < array.length; i++) {
			array[i] = random(min, max);
		}
	}
	
	static int[] create(int length, int min, int max){
		int[] array = new int[length];
		addRandom(array, min, max);
		return array;
	}
	
	static int[] increase(int[] array, int length){
		int[] array1 = new int[array.length+length];
		for (int i = 0; i < array.length && i < array1.length; i++) {
			array1[i] = array[i];
		}
		return array1;
	}
}