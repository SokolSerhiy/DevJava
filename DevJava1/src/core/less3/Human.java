package core.less3;

public class Human {

	protected int age;
	
	private String name;
	
	private static int count;
	
	public Human(final int age,final String name) {
		this();
		setAge(age);
		this.name = name;
	}
	
	public Human(){
		count++;
	}
	
	public static void countOfPeople(){
		System.out.println("Count of people "+count);
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
	
	public void setName(String name){
		this.name = name;
	}
	
	public String toString(){
		return "Human [age="+age+", name="+name+"]";
	}
}