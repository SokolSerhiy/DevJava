package less04.strategy.work.impl;

import less04.strategy.model.Resources;
import less04.strategy.model.Worker;
import less04.strategy.work.ResourceOperation;
import less04.strategy.work.Work;

public class CollectIron implements Work{

	private final Worker worker;
	
	private final ResourceOperation operation;
	
	public CollectIron(Worker worker, Resources resources) {
		this.worker = worker;
		this.operation = new ResourceOperationIron(resources);
	}

	@Override
	public void doWork() {
		operation.setResource(operation.getResource()+worker.collectIron());
	}
}
