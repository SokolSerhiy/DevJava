package less06;

public class Hunter extends Human{

	int killedMammonts;
	
	Hunter(){
		System.out.println("Uhrrrrrr!!!!");
	}
	
	Hunter(String name, int age){
		super(name, age);
	}
	
	void killMammont(){
		run();
		killedMammonts++;
		System.out.println(name+": I kill the mammont "
				+killedMammonts+" uhrrrrrr!!!!");
		eat("mammont meat");
	}
	
	void run(){
		System.out.println(name+": faster go-go-go!!!");
	}
	
	
}