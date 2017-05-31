package less06;

public class Human {

	int age;
	
	String name;
	
	int maxDistance = 5000;
	
	Human(){
		System.out.println("Hello");
		printData();
	}
	
	Human(String name, int age){
		this.name = name;
		this.age = age;
		System.out.println(this);
	}
	
	void run(){
		System.out.println(this.name+": go-go-go!!!");
	}
	
	boolean run(int distance){
		if(maxDistance-distance<0) return false;
		maxDistance-=distance;
		System.out.println(name + ": I run "+distance);
		return true;
	}
	
	void printData(){
		System.out.println(name+" "+age);
	}
}