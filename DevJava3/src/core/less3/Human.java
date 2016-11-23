package core.less3;

public class Human {

	String name;
	
	int age;
	
	Human(int age, String name){
		this(name);
		this.age = age;
	}
	
	Human(String name){
		this();
		this.name = name;
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
