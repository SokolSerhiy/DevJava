package lesson3;


public class Main {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		int[] array1 = new int[10];
		int a = array[0];
		array[0] = 2;
		for (int i = 0; i < array1.length; i++) {
			System.out.println(array1[i]);
		}
	}
}