package core.less2;

public class Person {

	int age;
	
	String name;
	
	int dist = 5000;
	
	Person(int age, String name){
		System.out.println(this.age+" "+ this.name);
		this.age=age;
		System.out.println(this.age+" "+ this.name);
		this.name=name;
		System.out.println(this.age+" "+ this.name);
	}
	
	Person(){}
	
	Person(int age){
		this.age=age;
	}
	
	boolean run(int dist){
		this.dist -= dist;
		System.out.println(name+": go-go-go "+this.dist);
		if(this.dist<0){
			System.out.println(name+": Game over");
			return false;
		}
		return true;
	}
	
	int run(int... asdf){
		System.out.println(asdf[0]);
		return 1;
	}
}
