package less04.strategy.work.impl;

import less04.strategy.model.Resources;
import less04.strategy.work.ResourceOperation;

public class ResourceOperationFood implements ResourceOperation{

	private final Resources resources;

	public ResourceOperationFood(Resources resources) {
		this.resources = resources;
	}

	@Override
	public void setResource(int res) {
		resources.setFood(res);
	}

	@Override
	public int getResource() {
		return resources.getFood();
	}
	
	
}
