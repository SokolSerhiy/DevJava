package less04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		printHello();
		printHello();
		int[] array = new int[10];
		print(array);
		int random = random(1, 10);
		System.out.println(random);
		addRandom(array);
		print(array);
		int c = 11;
		c = example(c);
		System.out.println(c);
		Scanner sc = new Scanner(System.in);
//		int res = sc.nextInt();
//		System.out.println(res);
		System.out.println("Enter max number");
		int max = sc.nextInt();
		int cpu = random(1, max);
		boolean isRun = true;
		while(isRun){
			System.out.println("Enter number");
			int user = sc.nextInt();
			if(user==cpu){
				isRun = false;
				System.out.println("You win!!");
			}else if(user>cpu){
				System.out.println("Try lesser");
			}else{
				System.out.println("Try bigger");
			}
		}
	}
	
	static int example(int a){
		a = random(1, 10);
		return a;
	}
	
	static void addRandom(int[] array){
//		array = new int[5];
		for (int i = 0; i < array.length; i++) {
			array[i] = random(1, 10);
		}
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
	
	static void printHello(){
		System.out.println("Hello");
	}
}