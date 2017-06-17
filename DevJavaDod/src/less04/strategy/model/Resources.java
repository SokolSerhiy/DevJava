package less04.strategy.model;

import java.io.Serializable;

public class Resources implements Serializable{

	private static final long serialVersionUID = 680879005939193115L;

	private int food;
	
	private int wood;
	
	private int stone;
	
	private int iron;
	
	public void printResourcesInfo(String name){
		System.out.println(name+": Food="+food+" Wood="+wood+" Stone="+stone+" Iron="+iron);
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
