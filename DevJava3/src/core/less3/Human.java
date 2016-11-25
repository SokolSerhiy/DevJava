package core.less3;

public class Human {

	private String name;
	
	private int age;
	
	private static int count;
	
	public static final int ASDF_TY = 1;
	
	public Human(int age, String name){
		this(name);
		setAge(age);
	}
	
	public Human(String name){
		this();
		this.name = name;
	}
	
	public Human(){
		count++;
		print();
		System.out.println("I was born");
	}
	
	public static void countOfPeople(){
		System.out.println("count = "+count);
	}
	
	public void run(){
		System.out.println(name+": go-go-go");
	}
	
	private void print(){
		System.out.println("Hello");
	}
	
	public final String getName(){
		return name;
	}
	
	public final int getAge(){
		return age;
	}
	
	public final void setName(String name){
		this.name = name;
	}
	
	public final void setAge(int age){
		if(age<0)age=0;
		this.age = age;
	}
	
	public String toString(){
		return "Human [age="+age+", name="+name+"]";
	}
}
