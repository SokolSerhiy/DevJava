package less04.strategy;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Location implements Runnable{

	private final String name;
	
	private volatile String command = "";
	
	private volatile int delay = 10000;
	
	private final Resources resources = new Resources();
	
	public Location(String name) {
		this.name = name;
	}
	
	public void addHumans(Object... objects){
		new HumanValidator(objects).validate();
		resources.setHumans(objects);
		Thread thread = new Thread(this);
		thread.setDaemon(true);
		thread.start();
		Scanner scanner = new Scanner(System.in);
		while (!command.equalsIgnoreCase("stop")) {
			command = scanner.nextLine();
		}
		scanner.close();
	}
	
	private void delay(){
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void run() {
		setBellyful();
		List<Work> works = new ArrayList<>();
		Object[] humans = resources.getHumans();
		for (int i = 0; i < humans.length; i++) {
			works.add(new FoodCollect(humans[i], resources));
		}
		while(true){
			resources.printResourcesInfo(name);
			doWork(works);
			doCommand();
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
		Object[] humans = resources.getHumans();
		for (int i = 0; i < humans.length; i++) {
			try {
				Field field = humans[i].getClass().getDeclaredField("bellyful");
				field.setAccessible(true);
				field.set(humans[i], 50);
			} catch (ReflectiveOperationException e) {
				throw new RuntimeException(e);
			}
		}
	}
}