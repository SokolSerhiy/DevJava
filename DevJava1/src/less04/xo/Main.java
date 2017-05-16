package less04.xo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isRun = true;
		int[][] field = new int[3][3];
		int count = 1;
		while(isRun){
			print(field);
			user(field, sc);
			count++;
			if(count==9)break;
			cpu(field);
			boolean userWin = whoWin(1, field);
			boolean cpuWin = whoWin(-1, field);
			if(userWin||cpuWin){
				isRun = false;
				if(userWin){
					System.out.println("User win");
				}else{
					System.out.println("Cpu win");
				}
			}
		}
		print(field);
	}
	
	static boolean whoWin(int xo, int[][] array){
		if(array[0][0]+array[0][1]+array[0][2]==xo*3) return true;
		if(array[1][0]+array[1][1]+array[1][2]==xo*3) return true;
		if(array[2][0]+array[2][1]+array[2][2]==xo*3) return true;
		if(array[0][0]+array[1][0]+array[2][0]==xo*3) return true;
		if(array[0][1]+array[1][1]+array[2][1]==xo*3) return true;
		if(array[0][2]+array[1][2]+array[2][2]==xo*3) return true;
		if(array[0][0]+array[1][1]+array[2][2]==xo*3) return true;
		if(array[2][0]+array[1][1]+array[0][2]==xo*3) return true;
		return false;
	}
	
	static void cpu(int[][] array){
		int x = random(0, 2);
		int y = random(0, 2);
		if(array[y][x]!=0){
			cpu(array);
		}else{
			array[y][x]=-1;
		}
	}
	
	static int random(int min, int max){
		return (int)Math.round(Math.random()*(max-min)+min);
	}
	
	static void user(int[][] array, Scanner sc){
		System.out.println("Enter x:");
		int x = sc.nextInt();
		System.out.println("Enter y:");
		int y = sc.nextInt();
		array[y][x] = 1;
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

}
