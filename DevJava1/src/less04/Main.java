package less04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		printHello();
		int[] array = new int[3];
		array[0] = 6;
		array[1] = 4;
		printArray(array);
		array[2] = 8;
		printArray(array);
		int random = random(1, 10);
		System.out.println(random);
//		for (int i = 0; i < 20; i++) {
//			System.out.println(random(1, 10));
//		}
		addRandom(array);
		printArray(array);
		int c = 5;
		randomPrimitive(c);
		System.out.println(c);
		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
//		System.out.println(a);
//		System.out.println(sc.nextDouble());
		System.out.println("Enter max number");
		int max = sc.nextInt();
		random = random(1, max);
		boolean isRun = true;
		while(isRun){
			System.out.println("Enter your number");
			int user = sc.nextInt();
			if(user==random){
				System.out.println("You win!!!");
				isRun = false;
			}else{
				System.out.println("Try again");
			}
		}
	}
	
//	static int[] example()[]{
//		return new int[];
//	}
	
	static int[] example()[]{
		return new int[10][10];
	}
	
//	static int[] example()[]{
//		return new int[][][];
//	}
	
	static void randomPrimitive(int a){
		a = random(1, 10);
	}
	
	static void addRandom(int[] array){
//		array = new int[5];
		for (int i = 0; i < array.length; i++) {
			array[i] = random(1, 10);
		}
	}
	
	static int random(int min, int max){
		return (int)Math.round(Math.random()*(max-min)+min);
	}
	
	static void printArray(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	static void printHello(){
		System.out.println("Hello");
	}
}