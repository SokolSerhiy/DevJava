package less06;

public class Hunter extends Human{

	int killedMammons;
	
	Hunter(String name, int age){
		super(name, age);
	}
	
	void killMammont(){
		run();
		killedMammons++;
		System.out.println(name+": Uhrrrrrr!!!! I kill "
				+killedMammons+" mammonts");
		eat("mammont meat");
	}
	
	void run(){
		System.out.println(name+": faster go-go-go!!!!");
	}
	
	public String toString(){
		return name+" "+age+" "+killedMammons;
	}
}