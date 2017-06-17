package less04.strategy.work.impl;

import less04.strategy.model.Resources;
import less04.strategy.work.ResourceOperation;

public class ResourceOperationIron implements ResourceOperation{

	private final Resources resources;

	public ResourceOperationIron(Resources resources) {
		this.resources = resources;
	}

	@Override
	public void setResource(int res) {
		resources.setIron(res);
	}

	@Override
	public int getResource() {
		return resources.getIron();
	}
}
