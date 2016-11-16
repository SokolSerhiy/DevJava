package lesson8;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[][] field = new int[3][3];
		print(field);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter x");
		int x = sc.nextInt();
		System.out.println("Enter y");
		int y = sc.nextInt();
		field[x][y] = 1;
	}
	
	static void print(int[][] field){
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				System.out.print(field[i][j]+" ");
			}
			System.out.println();
		}
	}
}