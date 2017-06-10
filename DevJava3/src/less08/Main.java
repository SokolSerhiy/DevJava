package less08;

public class Main {

	public static void main(String[] args) {
		Ballada ballada = new SimpleBallada();
		Bard bard = new Bard("Lutik", new BadEndBallada(new BadStartBallada(ballada)));
		bard.singing();
		bard.setBallada(new HeroBallada());
		bard.singing();
		
	}
}