package core.less3;

public class Hunter extends Human {

	int killedMammonts;

	Hunter(int age, String name) {
		super(age, name);
		System.out.println("4");
	}

	void eatMeat(String meat) {
		System.out.println(name + ": mmm nyam-nyam " + meat);
	}

	void eatMeat() {
		run();
		killedMammonts++;
		System.out.println(name + ": I kill " + killedMammonts + " mammonts");
		eatMeat("mammont meat");
	}

	@Override
	void run() {
		System.out.println(name + ": faster go-go-go");
	}

	public String toString() {
		return "Hunter [age=" + age + ", name=" + name + ", killedMammonts="
				+ killedMammonts + "]";
	}
}
