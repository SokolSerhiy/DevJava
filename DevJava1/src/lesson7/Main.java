package lesson7;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter max");
		int max = sc.nextInt();
		int res = random(1, max);
		while(true){
			System.out.println("Enter number");
			int t = sc.nextInt();
			if(t == res){
				System.out.println("You win");
				System.exit(0);
			}else if(t>res){
				System.out.println("Try less");
			}else if(t<res){
				System.out.println("Try bigger");
			}
		}
	}
	
	public static int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
}
