package lesson8;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[][] field = new int[3][3];
		print(field);
		Scanner sc = new Scanner(System.in);
		while(true){
			user(field, sc);
			print(field);
			if(whoWins(field, 1)){
				System.out.println("User win");
				break;
			}
			if(isDraw(field)){
				System.out.println("Draw");
				break;
			}
			System.out.println();
			cpu(field);
			print(field);
			if(whoWins(field, 2)){
				System.out.println("Cpu win");
				break;
			}
			if(isDraw(field)){
				System.out.println("Draw");
				break;
			}
		}
	}
	
	static boolean isDraw(int[][] field){
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if(field[i][j]==0)return false;
			}
		}
		return true;
	}
	
	static boolean whoWins(int[][] field, int n){
		if(field[0][0]==n&&field[0][1]==n&&field[0][2]==n){
			return true;
		}
		if(field[1][0]==n&&field[1][1]==n&&field[1][2]==n){
			return true;
		}
		if(field[2][0]==n&&field[2][1]==n&&field[2][2]==n){
			return true;
		}
		if(field[0][0]==n&&field[1][0]==n&&field[2][0]==n){
			return true;
		}
		if(field[0][1]==n&&field[1][1]==n&&field[2][1]==n){
			return true;
		}
		if(field[0][2]==n&&field[1][2]==n&&field[2][2]==n){
			return true;
		}
		if(field[0][0]==n&&field[1][1]==n&&field[2][2]==n){
			return true;
		}
		if(field[2][0]==n&&field[1][1]==n&&field[0][2]==n){
			return true;
		}
		return false;
	}
	
	static void cpu(int[][] field){
		int x = random(0, 2);
		int y = random(0, 2);
		if(field[y][x] == 0){
			field[y][x] = 2;
		}else{
			cpu(field);
		}
	}
	
	static void user(int[][] field, Scanner sc){
		System.out.println("Enter x:");
		int x = sc.nextInt()-1;
		System.out.println("Enter y:");
		int y = sc.nextInt()-1;
		field[y][x] = 1;
	}
	
	
	
	static void print(int[][] field){
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if(field[i][j]==0)System.out.print("- ");
				if(field[i][j]==1)System.out.print("x ");
				if(field[i][j]==2)System.out.print("0 ");
			}
			System.out.println();
		}
	}
	
	public static int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
}