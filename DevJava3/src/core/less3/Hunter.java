package core.less3;

public class Hunter extends Human{
	
	int killedMammonts;

	Hunter(int age, String name){
		super(age, name);
	}
	
	void eatMeat(String meat){
		System.out.println(name+": mmm nyam-nyam "+meat);
	}
	
	void eatMeat(){
		int kill = 0;
		while(kill<=10){
			run();
			int tmp = random(0, 10);
			kill += tmp;
			System.out.println(name+": I kill only "+tmp+ " mammonts");
		}
		killedMammonts+=kill;
		System.out.println(name+": I kill "+killedMammonts+" mammonts");
		eatMeat("mammont meat");
	}
	
	int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
	
	@Override
	void run(){
		System.out.println(name+": faster go-go-go");
	}
	
	public String toString(){
		return "Hunter [age="+age+", name="+name+", killedMammonts="+killedMammonts+"]";
	}
}