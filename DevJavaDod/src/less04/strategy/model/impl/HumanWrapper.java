package less04.strategy.model.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import less04.strategy.model.Resources;
import less04.strategy.model.Worker;
import less04.strategy.work.ResourceOperation;
import less04.strategy.work.Work;
import less04.strategy.work.impl.ResourceOperationFood;
import less04.strategy.work.impl.WorkPlace;

public class HumanWrapper implements Worker{
	
	public static final int HUNGRY = 30;
	
	public static final int ALMOST_DEAD = 5;
	
	public static final int TAKE_PER_ONE_TIME = 50;

	private final Object human;
	
	private final Field bellyful;
	
	private final Method collectFood;
	
	private final Method collectWood;
	
	private final Method collectStone;
	
	private final Method collectIron;
	
	private final ResourceOperation food;
	
	private final Resources resources;
	
	private Work work;
	
	private WorkPlace workPlace;
	
	public HumanWrapper(Object human, WorkPlace workPlace, Resources resources) {
		this.human = human;
		collectFood = getMethod("collectFood");
		collectWood = getMethod("collectWood");
		collectStone = getMethod("collectStone");
		collectIron = getMethod("collectIron");
		bellyful = getField("bellyful");
		this.resources = resources;
		this.food = new ResourceOperationFood(resources);
		this.workPlace = workPlace;
		work = workPlace.place(this, resources);
	}
	
	private Field getField(String name){
		try{
			Field field = human.getClass().getDeclaredField(name);
			field.setAccessible(true);
			return field;
		}catch (SecurityException | NoSuchFieldException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Method getMethod(String name){
		try{
			Method method = human.getClass().getDeclaredMethod(name);
			method.setAccessible(true);
			return method;
		}catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int collectFood() {
		try {
			return (Integer) collectFood.invoke(human);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int collectWood() {
		try {
			return (Integer) collectWood.invoke(human);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int collectStone() {
		try {
			return (Integer) collectStone.invoke(human);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int collectIron() {
		try {
			return (Integer) collectIron.invoke(human);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Work getWork() {
		return work;
	}

	@Override
	public void takeFood() {
		int bellyful = getBellyfulValue();
		if(bellyful<HUNGRY){
			int foodValue = food.getResource();
			if(foodValue>=TAKE_PER_ONE_TIME){
				setBellyfulValue(TAKE_PER_ONE_TIME+bellyful);
				food.setResource(food.getResource()-TAKE_PER_ONE_TIME);
			}else{
				setBellyfulValue(foodValue+bellyful);
				food.setResource(food.getResource()-foodValue);
			}
		}
	}
	
	private void setBellyfulValue(int bellyful){
		try {
			this.bellyful.setInt(human, bellyful);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	private int getBellyfulValue(){
		try {
			return bellyful.getInt(human);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean isHungry() {
		return getBellyfulValue()<=ALMOST_DEAD;
	}

	@Override
	public void changeWork(WorkPlace workPlace) {
		this.workPlace.decrementWorker();
		work = workPlace.place(this, resources);
		this.workPlace = workPlace;
	}
}
