package less04.strategy.work.impl;

import java.lang.reflect.Field;

import less04.strategy.work.ResourceOperation;
import less04.strategy.work.Use;

public class EatFood implements Use{
	
	private final String resName;
	
	private final Object human;
	
	private final ResourceOperation resources;
	
	private final int amountForOneTime;
	
	public EatFood(String resName, Object human, ResourceOperation resources, int amountForOneTime) {
		this.resName = resName;
		this.human = human;
		this.resources = resources;
		this.amountForOneTime = amountForOneTime;
	}

	@Override
	public boolean use() {
		try {
			Field field = human.getClass().getDeclaredField(resName);
			field.setAccessible(true);
			int value = field.getInt(human);
			if(value<=5) return false;
			if(value<=30) {
				int resource = resources.getResource();
				if(resource>=amountForOneTime){
					resource -= amountForOneTime;
					resources.setResource(resource);
					field.setInt(human, amountForOneTime+value);
				}else if(resource>0){
					resources.setResource(0);
					field.setInt(human, resource+value);
				}
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return true;
	}
}
