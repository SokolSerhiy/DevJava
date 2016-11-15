package lesson7;

public class Main {

	public static void main(String[] args) {
		
		while(true){
			
			System.exit(0);
		}
	}

	public static int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
}
