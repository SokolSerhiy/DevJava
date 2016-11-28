package core.less4;

public class Bard {

	private String name;

	public Bard(String name) {
		this.name = name;
	}
	
	public void sing(Ballada ballada){
		System.out.print(name+": ");
		ballada.song();
	}
	
}