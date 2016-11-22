package core.less3;

public class Human {

	private int age;

	private String name;
	
	private static int count;

	public Human(int age, String name) {
		this(name);
		setAge(age);
	}
	
	public Human(String name){
		this();
		setName(name);
	}
	
	public Human(){
		count++;
	}
	
	public static void countOfPeople(){
		System.out.println("Count of people "+count);
	}

	public void run() {
		System.out.println(name + ": go-go-go");
	}
	
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
	
	public final void setAge(int age){
		if(age<0)age=0;
		this.age = age;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Human [age=" + age + ", name=" + name + "]";
	}
}
