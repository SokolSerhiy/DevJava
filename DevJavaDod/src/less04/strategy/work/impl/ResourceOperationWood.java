package less04.strategy.work.impl;

import less04.strategy.model.Resources;
import less04.strategy.work.ResourceOperation;

public class ResourceOperationWood implements ResourceOperation{

	private final Resources resources;

	public ResourceOperationWood(Resources resources) {
		this.resources = resources;
	}

	@Override
	public void setResource(int res) {
		resources.setWood(res);
	}

	@Override
	public int getResource() {
		return resources.getWood();
	}
}
