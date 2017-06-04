package less03.snake;

import java.util.Scanner;

public class Game {
	
	private final Scanner sc = new Scanner(System.in);
	
	private final Mover mover = new Mover();
	
	void start(){
		new Thread(mover).start();
		while (mover.isRun()) {
			String move = sc.next();
			mover.setMove(move);
		}
	}
}
