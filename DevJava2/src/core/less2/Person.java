package core.less2;

public class Person {

	int age;
	
	String name;
	
	int dist = 5000;
	
	Person(){}
	
	Person(int age, String name){
		System.out.println(this.age+ " "+this.name);
		this.age=age;
		System.out.println(this.age+ " "+this.name);
		this.name=name;
		System.out.println(this.age+ " "+this.name);
	}
	
	Person(String name, int age){
		this.age=age;
		this.name=name;
	}
	
	void run(){
		System.out.println(name+": go-go-go");
	}
	
	boolean run(int dist){
		this.dist-=dist;
		if(this.dist<0){
			System.out.println(name+": game over");
			return false;
		}
		System.out.println(name+": go-go-go "+this.dist);
		return true;
	}
}
