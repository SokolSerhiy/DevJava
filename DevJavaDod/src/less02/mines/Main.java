package less02.mines;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	private static final int MINE = 200;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int countOfMines = 10;
		int size = 10;
		int[][] field = new int[size][size];
		boolean[][] visible = new boolean[size][size];
		init(countOfMines, field);
		print(field, visible);
		boolean isRun = true;
		while (isRun) {
			isRun = user(sc, field, visible);
			print(field, visible);
			if(!isRun){
				System.out.println("Game over");
				printEnd(field, visible);
			}
			if(isWinner(field, visible)){
				System.out.println("You are winner");
				isRun = false;
			}
		}
	}
	
	static boolean isWinner(int[][] field, boolean[][] visible){
		for (int i = 0; i < visible.length; i++) {
			for (int j = 0; j < visible.length; j++) {
				if(field[i][j]!=MINE&&!visible[i][j]) return false;
			}
		}
		return true;
	}
	
	static boolean user(Scanner sc, int[][] field, boolean[][] visible){
		System.out.println("Enter x:");
		int x = sc.nextInt()-1;
		System.out.println("Enter y:");
		int y = sc.nextInt()-1;
		if(field[y][x]==MINE) return false;
		Set<Coordinate> coordinates = new HashSet<>();
		search(field, visible, x, y, coordinates);
		return true;
	}
	
	static void search(int[][] field, boolean[][] visible, int x, int y, Set<Coordinate> coordinates){
		coordinates.add(new Coordinate(x, y));
		if(field[y][x]==0){
			if(x>0&&!coordinates.contains(new Coordinate(x-1, y)))search(field, visible, x-1, y, coordinates);
			if(x<9&&!coordinates.contains(new Coordinate(x+1, y)))search(field, visible, x+1, y, coordinates);
			if(y>0&&!coordinates.contains(new Coordinate(x, y-1)))search(field, visible, x, y-1, coordinates);
			if(y<9&&!coordinates.contains(new Coordinate(x, y+1)))search(field, visible, x, y+1, coordinates);
			if(x>0&&y>0&&!coordinates.contains(new Coordinate(x-1, y-1)))search(field, visible, x-1, y-1, coordinates);
			if(x<9&&y<9&&!coordinates.contains(new Coordinate(x+1, y+1)))search(field, visible, x+1, y+1, coordinates);
			if(x<9&&y>0&&!coordinates.contains(new Coordinate(x+1, y-1)))search(field, visible, x+1, y-1, coordinates);
			if(x>0&&y<9&&!coordinates.contains(new Coordinate(x-1, y+1)))search(field, visible, x-1, y+1, coordinates);
		}
		visible[y][x] = true;
	}
	
	static void print(int[][] field, boolean[][] visible){
		for (int i = 0; i < field.length+2; i++) {
			System.out.print("--");
		}
		System.out.println();
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if(j==0){
					System.out.print("| ");
				}
				if(visible[i][j]){
					if(field[i][j]==MINE){
						System.out.print("x ");
					}else{
						System.out.print(field[i][j]+" ");
					}
				}else{
					System.out.print("* ");
				}
				if(j==field[i].length-1){
					System.out.println(" |");
				}
			}
		}
		for (int i = 0; i < field.length+2; i++) {
			System.out.print("--");
		}
		System.out.println();
	}
	
	static void printEnd(int[][] field, boolean[][] visible){
		for (int i = 0; i < field.length+2; i++) {
			System.out.print("--");
		}
		System.out.println();
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if(j==0){
					System.out.print("| ");
				}
				if(field[i][j]==MINE){
					System.out.print("x ");
				}
				if(visible[i][j]){
					System.out.print(field[i][j]+" ");
				}else{
					if(field[i][j]!=MINE){
						System.out.print("* ");
					}
				}
				if(j==field[i].length-1){
					System.out.println(" |");
				}
			}
		}
		for (int i = 0; i < field.length+2; i++) {
			System.out.print("--");
		}
		System.out.println();
	}
	
	static void init(int countOfMines, int[][] field){
		for (int i = 0; i < countOfMines; i++) {
			placeMine(field);
		}
		placeNumbers(field);
	}
	
	static void placeNumbers(int[][] field){
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if(field[i][j]!=MINE){
					int count = 0;
					if(i!=0&&field[i-1][j]==MINE){//left
						count++;
					}
					if(j!=0&&field[i][j-1]==MINE){//top
						count++;
					}
					if(i!=field.length-1&&field[i+1][j]==MINE){//right
						count++;
					}
					if(j!=field[i].length-1&&field[i][j+1]==MINE){//bottom
						count++;
					}
					if(i!=0&&j!=0&&field[i-1][j-1]==MINE){//left-top
						count++;
					}
					if(i!=0&&j!=field[i].length-1&&field[i-1][j+1]==MINE){//left-bottom
						count++;
					}
					if(i!=field.length-1&&j!=0&&field[i+1][j-1]==MINE){//right-top
						count++;
					}
					if(i!=field.length-1&&j!=field[i].length-1&&field[i+1][j+1]==MINE){//right-bottom
						count++;
					}
					field[i][j]=count;
				}
			}
		}
	}
	
	static void placeMine(int[][] field){
		int x = random(0, field.length-1);
		int y = random(0, field.length-1);
		if(field[x][y]==MINE){
			placeMine(field);
		}else{
			field[x][y]=MINE;
		}
	}

	static int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
}
