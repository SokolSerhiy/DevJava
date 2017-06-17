package less04.strategy.work.impl;

import java.lang.reflect.Method;

import less04.strategy.work.ResourceOperation;
import less04.strategy.work.Work;

public class Collect implements Work{

	private final Object human;
	
	private final String methodName;
	
	private final ResourceOperation resourceOperation;
	
	public Collect(Object human, String methodName, ResourceOperation resourceOperation) {
		this.human = human;
		this.methodName = methodName;
		this.resourceOperation = resourceOperation;
	}

	@Override
	public void doWork() {
		try{
			Method method = human.getClass().getDeclaredMethod(methodName);
			method.setAccessible(true);
			int result = (int) method.invoke(human);
			result+= resourceOperation.getResource();
			resourceOperation.setResource(result);
		}catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int hashCode() {
		return ((human == null) ? 0 : human.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (human == obj) return true;
		else return false;
	}

	@Override
	public String getMethodName() {
		return methodName;
	}
}