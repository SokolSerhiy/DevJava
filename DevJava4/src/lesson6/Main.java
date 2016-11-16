package lesson6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[][] array = new int[3][3];
		print(array);
		Scanner sc = new Scanner(System.in);
		while(true){
			user(array, sc);
			print(array);
			if(whoWins(array, 1)){
				System.out.println("User win");
				break;
			}
			if(isDraw(array)){
				System.out.println("Draw");
				break;
			}
			System.out.println();
			cpu(array);
			print(array);
			if(whoWins(array, 2)){
				System.out.println("Cpu win");
				break;
			}
			if(isDraw(array)){
				System.out.println("Draw");
				break;
			}
		}
	}
	
	static boolean isDraw(int[][] array){
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if(array[i][j]==0) return false;
			}
		}
		return true;
	}
	
	static boolean whoWins(int[][] array, int n){
		if(array[0][0]==n&&array[0][1]==n&&array[0][2]==n){
			return true;
		}
		if(array[1][0]==n&&array[1][1]==n&&array[1][2]==n){
			return true;
		}
		if(array[2][0]==n&&array[2][1]==n&&array[2][2]==n){
			return true;
		}
		if(array[0][0]==n&&array[1][0]==n&&array[2][0]==n){
			return true;
		}
		if(array[0][1]==n&&array[1][1]==n&&array[2][1]==n){
			return true;
		}
		if(array[0][2]==n&&array[1][2]==n&&array[2][2]==n){
			return true;
		}
		if(array[0][0]==n&&array[1][1]==n&&array[2][2]==n){
			return true;
		}
		if(array[2][0]==n&&array[1][1]==n&&array[0][2]==n){
			return true;
		}
		return false;
	}
	
	static void user(int[][] array, Scanner sc){
		System.out.println("Enter x 1-3:");
		int x = sc.nextInt()-1;
		System.out.println("Enter y 1-3:");
		int y = sc.nextInt()-1;
		array[y][x] = 1;
	}
	
	static void cpu(int[][] array){
		int x = random(0, 2);
		int y = random(0, 2);
		if(array[y][x]==0){
			array[y][x] = 2;
		}else{
			cpu(array);
		}
	}
	
	static void print(int[][] array){
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if(array[i][j]==0)System.out.print("- ");
				if(array[i][j]==1)System.out.print("x ");
				if(array[i][j]==2)System.out.print("0 ");
			}
			System.out.println();
		}
	}

	public static int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
}
