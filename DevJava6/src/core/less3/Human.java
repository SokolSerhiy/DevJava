package core.less3;

public class Human {
	
	int age;
	
	String name;
	
	Human(int age, String name){
		this(age);
		this.name = name;
	}
	
	Human(int age){
		this();
		this.age = age;
	}
	
	Human(){
		System.out.println("I was born");
	}
	
	void run(){
		System.out.println(name+": go-go-go");
	}
	
	public String toString(){
		return "Human [age="+age+", name="+name+"]";
	}
}