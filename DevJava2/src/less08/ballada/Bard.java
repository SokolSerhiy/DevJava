package less08.ballada;

public class Bard {

	private final Ballada ballada;

	public Bard(Ballada ballada) {
		this.ballada = ballada;
	}
	
	public void singing(){
		ballada.song();
	}
}
