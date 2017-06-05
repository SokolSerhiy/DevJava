package less06;

public class Human extends Object{

	int age;
	
	String name;
	
	Human(){
		System.out.println("Hello");
		printData();
	}
	
	Human(String name, int age){
		this.name = name;
		this.age = age;
		System.out.println(this);
	}
	
	void eat(String meat){
		System.out.println(name+": mmm taste "+meat);
	}
	
	void run(){
		System.out.println(this.name+": go-go-go!!!");
	}
	
	void printData(){
		System.out.println(name+" "+age);
	}
}