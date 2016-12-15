package core.less16;

import java.util.Deque;
import java.util.LinkedList;

public class Singleton {

	private static final Singleton instance = new Singleton();
	
	private volatile Deque<Integer> tasks = new LinkedList<>();
	
	private volatile boolean stillRunning = true;
	
	private Singleton() {}

	public static Singleton getInstance(){
		return instance;
	}
	
	public void addTask(int task){
		tasks.addLast(task);
	}
	
	public Integer getTask(){
		synchronized(this){
			if(tasks==null)return null;
			return tasks.pollFirst();
		}
	}

	public boolean isStillRunning() {
		return stillRunning;
	}

	public void setStillRunning(boolean stillRunning) {
		this.stillRunning = stillRunning;
	}

	public boolean isEmpty() {
		return tasks.isEmpty();
	}

	public Deque<Integer> getTasks() {
		return tasks;
	}
}
