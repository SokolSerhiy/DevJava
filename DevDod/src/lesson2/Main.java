package lesson2;


public final class Main{

	public static void main(String[] args) {
		int[] array1 = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(array1[0]);
		array1[2] = 23;
		for (int i = 0; i < 5; i++) {
			if(i!=3){
				System.out.println(i);
			}
		}
		int[][] array = new int[3][];
		array[0] = new int[10];
		array[1] = new int[2];
		array[2] = new int[5];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static boolean horizontal(int[][] field, int n){
		for (int j = 0; j < field.length; j++) {
			boolean win = true;
			for (int i = 0; i < field.length; i++) {
				win = win && field[j][i]==n;
			}
			if(win)	return win;
		}
		return false;
	}
	
	static boolean vertical(int[][] field, int n){
		for (int j = 0; j < field.length; j++) {
			boolean win = true;
			for (int i = 0; i < field.length; i++) {
				win = win && field[i][j]==n;
			}
			if(win)	return win;
		}
		return false;
	}
	
	static boolean diagonale1(int[][] field, int n){
		boolean win = true;
		for (int i = 0, j = 2; i < field.length; i++, j--) {
			win = win && field[i][j]==n;
		}
		return win;
	}
	
	static boolean diagonale2(int[][] field, int n){
		boolean win = true;
		for (int i = 0, j = 0; i < field.length; i++, j++) {
			win = win && field[i][j]==n;
		}
		return win;
	}
	
	static boolean whoWins(int[][] field, int n){
		boolean win = vertical(field, n);
		if(win)return win;
		win = horizontal(field, n);
		if(win)return win;
		win = diagonale1(field, n);
		if(win)return win;
		win = diagonale2(field, n);
		return win;
	}
}
