package less06;

public class Human {

	int age;
	
	String name;
	
	Human(){
		System.out.println("Hello");
	}
	
	Human(String name, int age){
		this.name = name;
		this.age = age;
		System.out.println(this);
	}
	
	void run(){
		System.out.println(this.name+": go-go-go!!!");
	}
	
	void printData(){
		System.out.println(this.name+" "+this.age);
	}
}
