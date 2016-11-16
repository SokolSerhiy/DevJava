package lesson5;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Enter max:");
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();
		int random = random(1, max);
		while(true){
			System.out.println("Try:");
			int res = sc.nextInt();
			if(res==random){
				System.out.println("You win");
				break;
			}else if(res>random){
				System.out.println("Less");
			}else if(res<random){
				System.out.println("Bigger");
			}
		}
	}
	
	public static int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
}