package lesson6;

public class Main {

	public static void main(String[] args) {
		int a = 5;
		int b = a;
		System.out.println("a = "+ a);
		System.out.println("b = "+ b);
		a = 6;
		System.out.println("a = "+ a);
		System.out.println("b = "+ b);
		
		int[] a1 = new int[1];
		int[] b1 = a1;
		a1[0] = 5;
		b1[0] = 5;
		System.out.println("a1 = "+ a1[0]);
		System.out.println("b1 = "+ b1[0]);
		
		a1[0] = 6;
		System.out.println("a1 = "+ a1[0]);
		System.out.println("b1 = "+ b1[0]);
		
		int[] ar = new int[10];
		int[] arr = ar;
		print(ar);
		add(ar);
		print(arr);
		
		int[] array = createArray(10, 10, 1);
		print(array);
		array = increase(array, 3);
		print(array);
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
		//int[] array = ar;
		for (int i = 0; i < array.length; i++) {
			array[i] = i+1;
		}
	}
	
	static void addRandom(int[] array, int max, int min){
		for (int i = 0; i < array.length; i++) {
			array[i] = random(min, max);
		}
	}
	
	static int[] createArray(int length, int max, int min){
		int[] array = new int[length];
		addRandom(array, max, min);
		return array;
	}
	
	static int[] increase(int[] array, int length){
		int[] array2 = new int[array.length+length];
		for (int i = 0; i < array.length; i++) {
			array2[i] = array[i];
		}
		return array2;
	}
}