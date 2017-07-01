package less04.strategy.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import less04.strategy.model.HumanInfo;
import less04.strategy.model.Resources;
import less04.strategy.model.Worker;
import less04.strategy.model.impl.HumanWrapper;
import less04.strategy.validator.Validator;
import less04.strategy.validator.impl.ArrayLengthValidator;
import less04.strategy.validator.impl.CallsFieldMethodValidator;
import less04.strategy.validator.impl.ClassNameValidator;
import less04.strategy.validator.impl.CollectResultValidator;
import less04.strategy.validator.impl.FieldNameValidator;
import less04.strategy.validator.impl.FieldTypeNameValidator;
import less04.strategy.validator.impl.FieldTypeValidator;
import less04.strategy.validator.impl.ParentClassValidator;
import less04.strategy.validator.impl.SameClassValidator;
import less04.strategy.validator.impl.SpendResourcesChildValidator;
import less04.strategy.validator.impl.SpendResourcesValidator;
import static less04.strategy.work.impl.WorkPlace.*;
import less04.strategy.work.impl.WorkPlace;

public class Location implements Runnable{

	private final String name;
	
	private volatile String command = "";
	
	private volatile int delay = 1000;
	
	private final Resources resources = load();
	
	private final List<Worker> workers = new ArrayList<>();
	
	public Location(String name) {
		this.name = name;
	}
	
	private void save(){
		try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File("strategy.save")))){
			stream.writeObject(resources);
			stream.flush();
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Resources load() {
		try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream(new File("strategy.save")))){
			return (Resources) stream.readObject();
		}catch (IOException | ClassNotFoundException e) {
			System.out.println("Started with 0 resources");
		}
		return new Resources();
	}
	
	public void addHumans(Object... objects){
		placeHumans(objects);
	}
	
	public void start(){
		Thread thread = new Thread(this);
		thread.setDaemon(true);
		thread.start();
		Scanner scanner = new Scanner(System.in);
		while (!command.equalsIgnoreCase("stop")) {
			command = scanner.nextLine();
		}
		scanner.close();
	}
	
	private void validateHumans(Object... objects){
		Validator validator = new SpendResourcesValidator(1, 5, "bellyful", "collectIron",
				new SpendResourcesValidator(1, 5, "bellyful", "collectStone",
				new SpendResourcesValidator(1, 5, "bellyful", "collectWood",
				new SpendResourcesValidator(0, 0, "bellyful", "collectFood",
				new CollectResultValidator(getMinValue("Iron"), getMaxValue("Iron"),"collectIron",
				new CollectResultValidator(getMinValue("Stone"), getMaxValue("Stone"),"collectStone",
				new CollectResultValidator(getMinValue("Wood"), getMaxValue("Wood"),"collectWood",
				new CollectResultValidator(getMinValue("Food"), getMaxValue("Food"),"collectFood",
				new FieldTypeValidator(int.class, "bellyful",
				new FieldNameValidator("bellyful",
				new ClassNameValidator("Human",
				new SameClassValidator(
				new ArrayLengthValidator()))))))))))));
		validator.validate(objects);
	}
	
	public void validateWorkers(String resourceName, Object... objects){
		String className = getAdvancedCollectorsClassName(resourceName);
		int minValue = (int)(getMinValue(resourceName)*1.5);
		int maxValue = (int)(getMaxValue(resourceName)*1.5);
		int minSpend = resourceName.toUpperCase().equals("FOOD") ? 0 : 1;
		int maxSpend = resourceName.toUpperCase().equals("FOOD") ? 0 : 5;
		String methodName = "advancedCollect"+firstLetterUpperAllLower(resourceName);
		Validator validator = 	new CallsFieldMethodValidator("tool", "increase", methodName, 
								new ParentClassValidator("Human",
								new SpendResourcesChildValidator(minSpend, maxSpend, "bellyful", methodName,
								new CollectResultValidator(minValue, maxValue, methodName,
								new FieldTypeNameValidator("tool", "Tool", 
								new ClassNameValidator(className,
								new FieldNameValidator("tool",
								new SameClassValidator(
								new ArrayLengthValidator()))))))));
		validator.validate(objects);
	}
	
	private int getMaxValue(String resourceName){
		Map<WorkPlace, Integer> map = new HashMap<>();
		map.put(FOOD, 15);
		map.put(WOOD, 20);
		map.put(STONE, 15);
		map.put(IRON, 10);
		return map.get(WorkPlace.valueOf(resourceName.toUpperCase()));
	}
	
	private int getMinValue(String resourceName){
		Map<WorkPlace, Integer> map = new HashMap<>();
		map.put(FOOD, 5);
		map.put(WOOD, 15);
		map.put(STONE, 10);
		map.put(IRON, 5);
		return map.get(WorkPlace.valueOf(resourceName.toUpperCase()));
	}
	
	private String firstLetterUpperAllLower(String str){
		return str.substring(0, 1).toUpperCase()+str.substring(1).toLowerCase();
	}
	
	private String getAdvancedCollectorsClassName(String resourceName){
		Map<WorkPlace, String> map = new HashMap<>();
		map.put(FOOD, "FoodCollector");
		map.put(WOOD, "WoodCollector");
		map.put(STONE, "StoneCollector");
		map.put(IRON, "IronCollector");
		return map.get(WorkPlace.valueOf(resourceName.toUpperCase()));
	}
	
	public void addAdvancedCollectors(String resourceName, Object... objects){
		
	}
	
	public void addCollectors(String resourceName, Object... objects) {
		validateHumans(objects);
		WorkPlace workPlace = WorkPlace.valueOf(resourceName.toUpperCase());
		for (Object object : objects) {
			Worker worker = new HumanWrapper(object, workPlace, resources);
			workers.add(worker);
		}
	}
	
	private void placeHumans(Object... objects){
		for (int i = 0; i < objects.length; i++) {
			Worker worker = new HumanWrapper(objects[i], WorkPlace.values()[i%4], resources);
			workers.add(worker);
		}
	}
	
	private void delay(){
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
		}
	}
	
	@Override
	public void run() {
		while(true){
			resources.printResourcesInfo(name);
			HumanInfo.getInstance().printHumanInfo(name);
			doWork();
			doCommand();
			save();
			delay();
		}
	}
	
	private void doCommand(){
		String command = this.command.toLowerCase();
		if(command.startsWith("set delay")){
			String[] arr = command.split(" ");
			delay = Integer.valueOf(arr[arr.length-1]);
		}
	}
	
	private void doWork(){
		for (Worker worker : workers) {
			worker.takeFood();
			if(worker.isHungry()) worker.changeWork(WorkPlace.FOOD);
			worker.getWork().doWork();
		}
	}
}
