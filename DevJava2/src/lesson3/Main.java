package lesson3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter number");
//		int res = sc.nextInt();
//		System.out.println(res);
		int[] array = new int[(int)100L];
		int[] array2 = {1,2,3,4,5,6,7,8,};
		array[0] = 4;
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = i+1;
			System.out.println(array[i]);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age");
		int age = sc.nextInt();
		System.out.println("Enter retirement age");
		int retirement = sc.nextInt();
		System.out.println("Summ");
		int sum = sc.nextInt();
		System.out.println("Percent");
		double per = sc.nextDouble();
		double[] array3 = new double[retirement-age+1];
		array3[0] = sum;
		for (int i = 1; i < array3.length; i++) {
			array3[i] = array3[i-1]*((100+per)/100)+sum;
		}
		for (int i = 0; i < array3.length; i++) {
			System.out.println("age = "+ (age+i)+" sum = "+array3[i]);
		}
	}
	
}
