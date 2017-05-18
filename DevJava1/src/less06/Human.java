package less06;

public class Human {

	int age;
	
	String name;
	
	double capacity;
	
	Human(){}
	
	Human(String name, int age){
		this.name = name;
		this.age = age;
		System.out.print("In constructor: ");
		this.print();
	}
	
	void printThis(){
		System.out.println(this);
	}
	
	void run(){
		if(capacity>0.0){
			System.out.println(this.name+": go-go-go!!!");
			capacity-=0.1;
		}else{
			System.out.println(this.name+":I`m hungry, give me some food");
		}
	}
	
	void print(){
		System.out.println(this.name+" "+age);
	}
	
	void eat(String food){
		System.out.println(this.name+": mmmm tasty "+food);
		capacity+=0.5;
	}
}