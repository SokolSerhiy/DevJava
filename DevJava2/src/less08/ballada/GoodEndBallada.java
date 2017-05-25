package less08.ballada;

public class GoodEndBallada implements Ballada{

	private final Ballada ballada;
	
	public GoodEndBallada(Ballada ballada) {
		this.ballada = ballada;
	}

	@Override
	public void song() {
		ballada.song();
		System.out.println("People: Applause applause");
	}

}
