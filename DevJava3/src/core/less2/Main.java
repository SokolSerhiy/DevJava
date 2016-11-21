package core.less2;

public class Main {

	public static void main(String[] args) {
		Person p = new Person(18, "Vasyl");
		System.out.println(p.age);
		System.out.println(p.name);
		Person p1 = new Person(25, "Ivan");
//		p1.age = 25;
//		p1.name = "Ivan";
		System.out.println(p1.age);
		System.out.println(p1.name);
		p.run();
		p1.run();
	}

	public static int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
	
	public static int random(int max){
		return random(0, max);
	}
}
