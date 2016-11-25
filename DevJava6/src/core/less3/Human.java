package core.less3;

public class Human {
	
	private int age;
	
	private String name;
	
	private static int count;
	
	public static final int GHJ_UYH = 5;
	
	public Human(int age, String name){
		this(age);
		setName(name);
	}
	
	public Human(int age){
		this();
		this.age = age;
	}
	
	public Human(){
		count++;
		System.out.println("I was born");
	}
	
	public static void countOfPeople(){
		System.out.println("Count of people = "+count);
	}
	
	public void run(){
		System.out.println(name+": go-go-go");
	}
	
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
	
	public void setAge(int age){
		if(age<0)age=0;
		this.age = age;
	}
	
	public final void setName(final String name){
		this.name = name;
	}
	
	public String toString(){
		return "Human [age="+age+", name="+name+"]";
	}
}