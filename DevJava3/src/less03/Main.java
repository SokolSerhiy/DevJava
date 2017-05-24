package less03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[] array = {1, 2, 3,};
		int[] array1 = new int[10];
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		for (int i = 0; i < array1.length; i++) {
			array1[i] = i;
			System.out.println(array1[i]);
		}
		System.out.println(array);
		char[] word = {'a', 'b', 'c'};
		System.out.println(word);
		int a = 5;
		int b = a;
		a = 6;
		System.out.println(b);
		int[] array2 = array;
		array[0] = 5;
		System.out.println(array2[0]);
		
//		System.out.println(array[3]);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ввудіть суму яку можна відкласти в рік");
		int sum = sc.nextInt();
		System.out.println("Введіть віш вік");
		int age = sc.nextInt();
		double percent = 0.2;
		double[] res = new double[65-age+1];
		res[0] = sum;
		for(int i = 1; i < res.length; i++){
			res[i] = sum + (res[i-1]*(1+percent));
//			System.out.println("Age = "+(i+age)+" sum = "+res[i]);
		}
		System.out.println("В 65 сума заощаджень "+res[res.length-1]);
		boolean isRun = true;
		while(isRun){
			System.out.println("Введіть вік коли ви хочете піти на пенсію");
			System.out.println("Введіть 0 що б вийти з програми");
			int age1 = sc.nextInt();
			if(age1==0){
				isRun = false;
			}else{
				System.out.println("В "+age1+" сума заощаджень "+res[age1-age]);
			}
		}
		
	}
}