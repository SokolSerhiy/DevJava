package less08;

public class Bard {

	private final String name;
	
	private Ballada ballada;

	public Bard(String name, Ballada ballada) {
		this.name = name;
		this.ballada = ballada;
	}
	
	public void singing(){
		ballada.song();
	}

	public Ballada getBallada() {
		return ballada;
	}

	public void setBallada(Ballada ballada) {
		this.ballada = ballada;
	}

	public String getName() {
		return name;
	}
}
