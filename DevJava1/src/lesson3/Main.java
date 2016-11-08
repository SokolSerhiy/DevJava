package lesson3;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter number");
//		int res = sc.nextInt();
//		System.out.println(res);
		
		int[] array = new int[10];
		int[] array2 = {1,2,3,4,5,6,7,8,9,};
		array[0] = 12;
		array[1] = 1;
		for(int i = 0; i < 10; i++){
			System.out.println(array[i]);
		}
		int[] array3 = new int[10];
		for (int i = 0; i < array3.length; i++) {
			array3[i] = i+1;
			System.out.println(array3[i]);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age");
		int age = sc.nextInt();
		System.out.println("Enter your pensionable age");
		int pensionableAge = sc.nextInt();
		System.out.println("Enter sum");
		double sum = sc.nextInt();
		System.out.println("Enter rate");
		double rate = sc.nextInt();
		double[] arr = new double[pensionableAge-age];
		arr[0] = sum;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = (arr[i-1])*((100+rate)/100)+sum;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println("age = " + (age+i)+" sum = "+arr[i]);
		}
	}
}