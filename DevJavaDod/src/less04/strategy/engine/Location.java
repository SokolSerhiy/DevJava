package less04.strategy.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import less04.strategy.model.HumanResources;
import less04.strategy.model.Resources;
import less04.strategy.validator.Validator;
import less04.strategy.validator.impl.ArrayLengthValidator;
import less04.strategy.validator.impl.ClassNameValidator;
import less04.strategy.validator.impl.CollectResultValidator;
import less04.strategy.validator.impl.ResourceValidator;
import less04.strategy.validator.impl.SameClassValidator;
import less04.strategy.validator.impl.SpendResourcesValidator;
import less04.strategy.work.Work;
import less04.strategy.work.impl.Collect;
import less04.strategy.work.impl.EatFood;
import less04.strategy.work.impl.ResourceOperationFood;
import less04.strategy.work.impl.ResourceOperationIron;
import less04.strategy.work.impl.ResourceOperationStone;
import less04.strategy.work.impl.ResourceOperationWood;

public class Location implements Runnable{

	private final String name;
	
	private volatile String command = "";
	
	private volatile int delay = 1000;
	
	private final Resources resources = load();
	
	private final HumanResources humanResources = new HumanResources();
	
	private final List<Object> humans = new ArrayList<>();
	
	private final List<Work> works = new ArrayList<>();
	
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
		validate(objects);
		addHumansToList(objects);
		placeHumans();
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
	
	private void validate(Object... objects){
		Validator validator = 	new SpendResourcesValidator(1, 5, "bellyful", "collectIron",
				new SpendResourcesValidator(1, 5, "bellyful", "collectStone",
				new SpendResourcesValidator(1, 5, "bellyful", "collectWood",
				new SpendResourcesValidator(0, 0, "bellyful", "collectFood",
				new CollectResultValidator(5, 10,"collectIron",
				new CollectResultValidator(10, 15,"collectStone",
				new CollectResultValidator(15, 20,"collectWood",
				new CollectResultValidator(5, 15,"collectFood",
				new ResourceValidator("bellyful",
				new ClassNameValidator(
				new SameClassValidator(
				new ArrayLengthValidator())))))))))));
		validator.validate(objects);
	}
	
	private void addHumansToList(Object[] objects){
		for (int i = 0; i < objects.length; i++) {
			humans.add(objects[i]);
		}
	}
	
	public void addFoodCollectors(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			works.add(new Collect(objects[i], "collectFood", new ResourceOperationFood(resources)));
			humanResources.setFoodCollectors(humanResources.getFoodCollectors()+1);
		}
		addHumansToList(objects);
	}
	
	public void addWoodCollectors(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			works.add(new Collect(objects[i], "collectWood", new ResourceOperationWood(resources)));
			humanResources.setWoodCollectors(humanResources.getWoodCollectors()+1);
		}
		addHumansToList(objects);
	}
	
	public void addStoneCollectors(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			works.add(new Collect(objects[i], "collectStone", new ResourceOperationStone(resources)));
			humanResources.setStoneCollectors(humanResources.getStoneCollectors()+1);
		}
		addHumansToList(objects);
	}
	
	public void addIronCollectors(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			works.add(new Collect(objects[i], "collectIron", new ResourceOperationIron(resources)));
			humanResources.setIronCollectors(humanResources.getIronCollectors()+1);
		}
		addHumansToList(objects);
	}
	
	private void placeHumans(){
		for (int i = 0; i < humans.size(); i++) {
			switch (i%4) {
			case 0:
				works.add(new Collect(humans.get(i), "collectFood", new ResourceOperationFood(resources)));
				humanResources.setFoodCollectors(humanResources.getFoodCollectors()+1);
				break;
			case 1:
				works.add(new Collect(humans.get(i), "collectWood", new ResourceOperationWood(resources)));
				humanResources.setWoodCollectors(humanResources.getWoodCollectors()+1);
				break;
			case 2:
				works.add(new Collect(humans.get(i), "collectStone", new ResourceOperationStone(resources)));
				humanResources.setStoneCollectors(humanResources.getStoneCollectors()+1);
				break;
			case 3:
				works.add(new Collect(humans.get(i), "collectIron", new ResourceOperationIron(resources)));
				humanResources.setIronCollectors(humanResources.getIronCollectors()+1);
				break;
			}
		}
	}
	
	private void delay(){
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
		}
	}
	
	private void useResources(){
		for (int i = 0; i < humans.size(); i++) {
			if(!new EatFood("bellyful", humans.get(i), new ResourceOperationFood(resources), 50).use()){
				for (int j = 0; j < works.size(); j++) {
					if(works.get(j).equals(humans.get(i))){
						Work work = works.remove(j);
						if(work.getMethodName().equals("collectFood")) {
							works.add(work);
						} else {
							works.add(new Collect(humans.get(i), "collectFood", new ResourceOperationFood(resources)));
							humanResources.setFoodCollectors(humanResources.getFoodCollectors()+1);
							decrementWorker(work.getMethodName());
						}
					}
				}
			}
		}
	}
	
	private void decrementWorker(String methodName){
		switch (methodName) {
		case "collectWood":
			humanResources.setWoodCollectors(humanResources.getWoodCollectors()-1);
			break;
		case "collectStone":
			humanResources.setStoneCollectors(humanResources.getStoneCollectors()-1);
			break;
		case "collectIron":
			humanResources.setIronCollectors(humanResources.getIronCollectors()-1);
			break;
		}
	}

	@Override
	public void run() {
		setBellyful();
		while(true){
			resources.printResourcesInfo(name);
			humanResources.printHumanInfo(name);
			useResources();
			doWork(works);
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
	
	private void doWork(List<Work> works){
		for (Work work : works) {
			work.doWork();
		}
	}
	
	private void setBellyful(){
		for (int i = 0; i < humans.size(); i++) {
			try {
				Field field = humans.get(i).getClass().getDeclaredField("bellyful");
				field.setAccessible(true);
				field.set(humans.get(i), 50);
			} catch (ReflectiveOperationException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
