package core.less3;

public class Human {

	int age;
	
	String name;
	
	Human(int age, String name){
		this(age);
		this.name = name;
		System.out.println("3");
	}
	
	Human(int age){
		this();
		this.age = age;
		System.out.println("2");
	}
	
	Human(){
		System.out.println("I was born");
		System.out.println("1");
	}
	
	void run(){
		System.out.println(name+": go-go-go");
	}
	
	public String toString(){
		return "Human [age="+age+", name="+name+"]";
	}
}
