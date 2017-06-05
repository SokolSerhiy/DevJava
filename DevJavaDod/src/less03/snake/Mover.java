package less03.snake;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class Mover implements Runnable {

	private volatile String move = "d";

	private volatile boolean isRun = true;

	private final int size = 10;

	private final int[][] field = new int[size][size];
	
	private final boolean[][] fieldFood = new boolean[size][size];

	private int snake = 1;

	private int food = 2;

	private final Deque<Coordinate> deque = new LinkedList<>();
	
	private final Random random = new Random();

	@Override
	public void run() {
		placeStartPosition();
		placeFood();
		while (isRun) {
			move();
			print();
			useDelay();
		}
	}

	void placeFood() {
		int x = random.nextInt(size);
		int y = random.nextInt(size);
		Coordinate foodCoordinate = new Coordinate(x, y);
		if(!deque.contains(foodCoordinate)){
			fieldFood[y][x] = true;
			field[y][x] = food;
		}else{
			placeFood();
		}
	}

	void useDelay() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	void setMove(String move) {
		this.move = move;
	}
	
	Coordinate deleteLastFromArray(boolean isFood){
		Coordinate last;
		if(isFood){
			last = deque.peekLast();
		} else {
			last = deque.pollLast();
			field[last.y][last.x] = 0;
		}
		fieldFood[last.y][last.x] = false;
		return last;
	}
	
	Coordinate peekFirst(Coordinate last){
		if(deque.isEmpty()) return last;
		return deque.peekFirst();
	}
	
	boolean moveHeadToRight(Coordinate head, Coordinate first){
		if (first.x == 9 || deque.contains(head))return gameOver();
		return gameContinue(head);
	}
	
	boolean moveHeadToBottom(Coordinate head, Coordinate first){
		if (first.y == 9 || deque.contains(head))return gameOver();
		return gameContinue(head);
	}
	
	boolean moveHeadToLeft(Coordinate head, Coordinate first){
		if (first.x == 0 || deque.contains(head))return gameOver();
		return gameContinue(head);
	}
	
	boolean moveHeadToTop(Coordinate head, Coordinate first){
		if (first.y == 0 || deque.contains(head))return gameOver();
		return gameContinue(head);
	}

	boolean gameContinue(Coordinate head){
		deque.addFirst(head);
		field[head.y][head.x] = snake;
		if(fieldFood[head.y][head.x]){
			placeFood();
		}
		return true;
	}
	
	boolean gameOver(){
		System.out.println("Game over");
		return false;
	}
	
	

	void move() {
		switch (move) {
		case "d":{
			Coordinate last = deleteLastFromArray(fieldFood[deque.peekLast().y][deque.peekLast().x]);
			Coordinate first = peekFirst(last);
			Coordinate head = new Coordinate(first.x + 1, first.y);
			isRun = moveHeadToRight(head, first);
			break;
		}
		case "s":{
			Coordinate last = deleteLastFromArray(fieldFood[deque.peekLast().y][deque.peekLast().x]);
			Coordinate first = peekFirst(last);
			Coordinate head = new Coordinate(first.x, first.y+1);
			isRun = moveHeadToBottom(head, first);
			break;
		}
		case "a":{
			Coordinate last = deleteLastFromArray(fieldFood[deque.peekLast().y][deque.peekLast().x]);
			Coordinate first = peekFirst(last);
			Coordinate head = new Coordinate(first.x-1, first.y);
			isRun = moveHeadToLeft(head, first);
			break;
		}
		case "w":{
			Coordinate last = deleteLastFromArray(fieldFood[deque.peekLast().y][deque.peekLast().x]);
			Coordinate first = peekFirst(last);
			Coordinate head = new Coordinate(first.x, first.y-1);
			isRun = moveHeadToTop(head, first);
			break;
		}
		}
	}

	void print() {
		for (int i = 0; i < size + 2; i++) {
			System.out.print("--");
		}
		System.out.println();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (j == 0) System.out.print("| ");
				if (field[i][j] == snake) System.out.print("* ");
				if (field[i][j] == food) System.out.print("& ");
				if (field[i][j] == 0) System.out.print("  ");
				if (j == size - 1) System.out.println(" |");
			}
		}
		for (int i = 0; i < size + 2; i++) {
			System.out.print("--");
		}
		System.out.println();
	}

	void placeStartPosition() {
		int start = size / 2;
		field[start][start] = snake;
		deque.addLast(new Coordinate(start, start));
	}

	public boolean isRun() {
		return isRun;
	}
}