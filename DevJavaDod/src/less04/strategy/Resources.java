package less04.strategy;

public class Resources {

	private Object[] humans;
	
	private int food;
	
	private int wood;
	
	private int stone;
	
	private int iron;
	
	public void printResourcesInfo(String name){
		System.out.println(name+": Food="+food+" Wood="+wood+" Stone="+stone+" Iron="+iron+" Human="+humans.length);
	}

	public Object[] getHumans() {
		return humans;
	}

	public void setHumans(Object[] humans) {
		this.humans = humans;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public int getStone() {
		return stone;
	}

	public void setStone(int stone) {
		this.stone = stone;
	}

	public int getIron() {
		return iron;
	}

	public void setIron(int iron) {
		this.iron = iron;
	}
}
