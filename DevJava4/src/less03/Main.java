package less03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,};
		int[] array1 = new int[10];
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		for (int i = 0; i < array1.length; i++) {
			array1[i] = i;
			System.out.println(array1[i]);
		}
		int a = 5;
		int b = a;
		a = 6;
		System.out.println(b);
		int[] array2 = array;
		array[0] = 5;
		System.out.println(array2[0]);
		System.out.println(array);
		char[] word = {'a', 'b', 'c'};
		System.out.println(word);
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть вік");
		int age = sc.nextInt();
		System.out.println("Введіть суму щорічних вкладень");
		int sum = sc.nextInt();
		double[] res = new double[65-age+1];
		res[0] = sum;
		for (int i = 1; i < res.length; i++) {
			res[i] = sum + (res[i-1]*1.2);
		}
		System.out.println("В 65 років сума буде "+res[res.length-1]);
		boolean isRun = true;
		while (isRun) {
			System.out.println("Введіть вік в якому хочете піти на пенсію");
			System.out.println("Введіть 0 що б вийти з програми");
			int age2 = sc.nextInt();
			if(age2==0){
				isRun = false;
			}else{
				System.out.println("В "+age2+" років сума буде "+res[age2-age]);
			}
		}
	}
}