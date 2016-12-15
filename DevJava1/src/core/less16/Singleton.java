package core.less16;

import java.util.Deque;
import java.util.LinkedList;

public class Singleton {
	
	private final Deque<Integer> que = new LinkedList<>();

	private static final Singleton instance = new Singleton();
	
	public static Singleton getInstance(){
		return instance;
	}
	
	public void addTask(int task){
		que.addLast(task);
	}
	
	public Integer getTask(){
		if(que==null)return null;
		return que.poll();
	}
	
}
