package lesson3;

public class Main {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		int[] array1 = new int[10];
		int a = array[0];
		array[0] = 8;
		for (int i = 0; i < array1.length; i++) {
			System.out.println(array1[i]);
		}
	}
}