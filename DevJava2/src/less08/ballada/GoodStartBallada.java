package less08.ballada;

public class GoodStartBallada implements Ballada{

	private final Ballada ballada;

	public GoodStartBallada(Ballada ballada) {
		this.ballada = ballada;
	}

	@Override
	public void song() {
		System.out.println("People: Hooray hooray!!!");
		ballada.song();
	}
}