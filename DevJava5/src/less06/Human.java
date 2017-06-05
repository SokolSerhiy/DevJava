package less06;

public class Human extends Object{

	int age;
	
	String name = "";
	
	Human(){
		printData();
		System.out.println("Hello");
	}
	
	Human(String name, int age){
		this.name = name;
		this.age = age;
		System.out.println(this);
	}
	
	void eat(String food){
		System.out.println(name+": mmm taste "+food);
	}
	
	void run(){
		System.out.println(this.name+": go-go-go!!!");
	}
	
	void printData(){
		System.out.println(this.name+" "+age);
	}
}
