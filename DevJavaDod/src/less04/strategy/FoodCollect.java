package less04.strategy;

import java.lang.reflect.Method;

public class FoodCollect implements Work{

	private final Object human;
	
	private final Resources resources;
	
	public FoodCollect(Object human, Resources resources) {
		this.human = human;
		this.resources = resources;
	}

	@Override
	public void doWork() {
		try{
			Method method = human.getClass().getDeclaredMethod("collectFood");
			method.setAccessible(true);
			int result = (int) method.invoke(human);
			int food = resources.getFood();
			food+=result;
			resources.setFood(food);
		}catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}
}