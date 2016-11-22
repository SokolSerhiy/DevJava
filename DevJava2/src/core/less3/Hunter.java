package core.less3;

public final class Hunter extends Human {	

	private int killedMammonts;

	public Hunter(final int age, final String name) {
		super(age, name);
	}

	public final void eatMeat(final String meat) {
		System.out.println(getName() + ": Mmmm nyam-nyam " + meat);
	}

	public final void eatMeat() {
		this.run();
		killedMammonts++;
		System.out.println(getName() + ": I kill " + killedMammonts + " mammonts");
		eatMeat("mammont meat");
	}

	public final void run() {
		System.out.println(getName() + ": faster go-go-go");
	}

	@Override
	public final String toString() {
		return "Hunter [age=" + getAge() + ", name=" + getName() + ", killedMammonts="
				+ killedMammonts + "]";
	}
}
