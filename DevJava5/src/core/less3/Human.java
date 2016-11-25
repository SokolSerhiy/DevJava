package core.less3;

public class Human {
	
	private int age;
	
	private String name;
	
	private static int count;
	
	public static final int GHJKL_OIUTTR = 1;
	
	public Human(int age, String name){
		this(age);
		setName(name);
		System.out.println("3");
	}
	
	public Human(int age){
		this();
		this.age = age;
		System.out.println("2");
	}
	
	public Human(){
		count++;
		System.out.println("I was born");
		System.out.println("1");
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
	
	public final void setName(String name){
		this.name = name;
	}
	
	public String toString(){
		return "Human [age="+age+", name="+name+"]";
	}
}
