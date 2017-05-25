package less08.ballada;

public class Main {

	public static void main(String[] args) {
		Ballada startEndBallada = new GoodEndBallada(
										new GoodStartBallada(
												new SimpleBallada()));
		Bard bard = new Bard(startEndBallada);
		bard.singing();
	}
}