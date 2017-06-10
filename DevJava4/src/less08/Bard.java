package less08;

public class Bard {

	private String name;
	
	private Ballada ballada;

	public Bard(String name, Ballada ballada) {
		this.name = name;
		this.ballada = ballada;
	}
	
	public void singing(){
		ballada.song();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ballada getBallada() {
		return ballada;
	}

	public void setBallada(Ballada ballada) {
		this.ballada = ballada;
	}
}
