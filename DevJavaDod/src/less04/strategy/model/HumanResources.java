package less04.strategy.model;

public class HumanResources {

	private int foodCollectors;
	
	private int woodCollectors;
	
	private int stoneCollectors;
	
	private int ironCollectors;
	
	public void printHumanInfo(String name){
		System.out.println(name+": food collectors="+foodCollectors+", wood collectors="+woodCollectors+", stone collectors="+stoneCollectors+", iron collectors="+ironCollectors);
	}

	public int getFoodCollectors() {
		return foodCollectors;
	}

	public void setFoodCollectors(int foodCollectors) {
		this.foodCollectors = foodCollectors;
	}

	public int getWoodCollectors() {
		return woodCollectors;
	}

	public void setWoodCollectors(int woodCollectors) {
		this.woodCollectors = woodCollectors;
	}

	public int getStoneCollectors() {
		return stoneCollectors;
	}

	public void setStoneCollectors(int stoneCollectors) {
		this.stoneCollectors = stoneCollectors;
	}

	public int getIronCollectors() {
		return ironCollectors;
	}

	public void setIronCollectors(int ironCollectors) {
		this.ironCollectors = ironCollectors;
	}
}