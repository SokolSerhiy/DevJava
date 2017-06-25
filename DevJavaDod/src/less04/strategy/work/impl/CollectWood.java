package less04.strategy.work.impl;

import less04.strategy.model.Resources;
import less04.strategy.model.Worker;
import less04.strategy.work.ResourceOperation;
import less04.strategy.work.Work;

public class CollectWood implements Work{

	private final Worker worker;
	
	private final ResourceOperation operation;
	
	public CollectWood(Worker worker, Resources resources) {
		this.worker = worker;
		this.operation = new ResourceOperationWood(resources);
	}

	@Override
	public void doWork() {
		operation.setResource(operation.getResource()+worker.collectWood());
	}
}
