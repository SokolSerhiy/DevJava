package lesson8;

public class Main {

	public static void main(String[] args) {
		int[][] field = new int[3][3];
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				System.out.print(field[i][j]+" ");
			}
			System.out.println();
		}
		int y = lesson7.Main.random(0, 2);
		int x = lesson7.Main.random(0, 2);
		field[x][y] = 1;
	}
}