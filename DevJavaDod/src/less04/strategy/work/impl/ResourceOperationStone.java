package less04.strategy.work.impl;

import less04.strategy.model.Resources;
import less04.strategy.work.ResourceOperation;

public class ResourceOperationStone implements ResourceOperation{

	private final Resources resources;

	public ResourceOperationStone(Resources resources) {
		this.resources = resources;
	}

	@Override
	public void setResource(int res) {
		resources.setStone(res);
	}

	@Override
	public int getResource() {
		return resources.getStone();
	}
}