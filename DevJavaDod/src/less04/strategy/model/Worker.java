package less04.strategy.model;

import less04.strategy.work.Work;
import less04.strategy.work.impl.WorkPlace;

public interface Worker extends Human{

	int collectFood();
	
	int collectWood();
	
	int collectStone();
	
	int collectIron();
	
	Work getWork();
	
	void changeWork(WorkPlace workPlace);
}
