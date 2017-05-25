package less08.ballada;

public class Main {

	public static void main(String[] args) {
		Ballada ballada = new SimpleBallada();
		Ballada goodStartBallada = new GoodStartBallada(ballada);
		Ballada goodEndBallada = new GoodEndBallada(goodStartBallada);
		Bard bard = new Bard("Lutik", goodEndBallada);
		bard.singing();
	}

}
