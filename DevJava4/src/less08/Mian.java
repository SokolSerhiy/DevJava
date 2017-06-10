package less08;

public class Mian {

	public static void main(String[] args) {
		Ballada ballada = new BadEndBallada(new BadStartBallada(new SimpleBallada()));
		Bard bard = new Bard("Lutik", ballada);
		bard.singing();
		Ballada ballada2 = new HeroBallada();
		bard.setBallada(ballada2);
		bard.singing();
	}

}
