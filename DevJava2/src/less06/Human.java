package less06;

public class Human {

	int age;
	
	String name;
	
	int capacity;
	
	Human(){
//		System.out.println("Hello");
	}
	
	Human(String name, int age){
//		print();
		this.name = name;
		this.age = age;
	}
	
	void drink(Human human){
		if(human==this){
			System.out.println(name+": I`m not alcogolik");
		}else{
			System.out.println(name+" "+human.name+" "+"we just drink some water");
		}
	}
	
	void run(){
		if(capacity==0){
			System.out.println(name+": I`m hungry, give me some food");
		}else{
			capacity--;
			System.out.println(name+": go-go-go!!!");
		}
	}
	
	void eat(String food){
		System.out.println(name+": mmmm taste "+food);
		capacity++;
	}
	
	void print(){
		System.out.println(name+" "+age);
	}
}
