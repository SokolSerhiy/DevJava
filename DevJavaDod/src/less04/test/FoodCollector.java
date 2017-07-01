package less04.test;

public class FoodCollector extends Human{

	Tool tool = new Tool();
	
	int advancedCollectFood(){
		return tool.increase(collectFood());
	}
}
