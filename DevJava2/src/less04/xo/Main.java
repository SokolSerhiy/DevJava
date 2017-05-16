package less04.xo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] field = new int[3][3];
		boolean isRun = true;
		int count = 0;
		while(isRun){
			print(field);
			user(field, sc);
			count++;
			if(count==5)break;
			cpu(field);
			boolean isUserWinner = whoWin(field, 1);
			boolean isCpuWinner = whoWin(field, -1);
			if(isCpuWinner||isUserWinner){
				isRun = false;
				if(isCpuWinner){
					System.out.println("Cpu win");
				}else{
					System.out.println("User win");
				}
			}
		}
		print(field);
	}
	
	static boolean whoWin(int[][] array, int xo){
		if(array[0][0]+array[0][1]+array[0][2]==xo*3)return true;
		if(array[1][0]+array[1][1]+array[1][2]==xo*3)return true;
		if(array[2][0]+array[2][1]+array[2][2]==xo*3)return true;
		if(array[0][0]+array[1][0]+array[2][0]==xo*3)return true;
		if(array[0][1]+array[1][1]+array[2][1]==xo*3)return true;
		if(array[0][2]+array[1][2]+array[2][2]==xo*3)return true;
		if(array[0][0]+array[1][1]+array[2][2]==xo*3)return true;
		if(array[0][2]+array[1][1]+array[2][0]==xo*3)return true;
		return false;
	}
	
	static void cpu(int[][] array){
		int x = random(0, 2);
		int y = random(0, 2);
		if(array[x][y]!=0){
			cpu(array);
		}else{
			array[x][y] = -1;
		}
	}
	
	static void print(int[][] array){
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if(array[i][j]==0)System.out.print("   ");
				if(array[i][j]==1)System.out.print(" x ");
				if(array[i][j]==-1)System.out.print(" 0 ");
			}
			System.out.println();
		}
	}
	
	static void user(int[][] array, Scanner sc){
		System.out.println("Enter x:");
		int x = sc.nextInt();
		System.out.println("Enter y:");
		int y = sc.nextInt();
		array[y][x] = 1;
	}
	
	static int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
}