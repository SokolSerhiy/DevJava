package core.less3;

public class Hunter extends Human{
	
	private int killedMammonts;

	public Hunter(int age, String name){
		super(age, name);
	}
	
	public void eatMeat(String meat){
		System.out.println(getName()+": mmm nyam-nyam "+meat);
	}
	
	public void eatMeat(){
		int kill = 0;
		while(kill<=10){
			run();
			int tmp = random(0, 10);
			kill += tmp;
			System.out.println(getName()+": I kill only "+tmp+ " mammonts");
		}
		killedMammonts+=kill;
		System.out.println(getName()+": I kill "+killedMammonts+" mammonts");
		eatMeat("mammont meat");
	}
	
	private int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
	
	private void print(){
		System.out.println("Hello hunter");
	}
	
	@Override
	public void run(){
		System.out.println(getName()+": faster go-go-go");
	}
	
	public String toString(){
		return "Hunter [age="+getAge()+", name="+getName()+", killedMammonts="+killedMammonts+"]";
	}
}