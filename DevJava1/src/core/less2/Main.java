package core.less2;

public class Main {

	public static void main(String[] args) {
		Person p = new Person(20, "Ivan");
		// System.out.println(p.age);
		// System.out.println(p.name);
		Person p1 = new Person(18, "Petro");
		Person p2 = new Person(26, "Mykola");
		p.run(3,2);
		int[] asdf = getArray(1,2,3,4,5,6,7,8);
//		p.run(random(50, 150));
//		p1.run(random(50, 150));
		// System.out.println(p1.age);
		// System.out.println(p1.name);
	}
	
	static int[] getArray(int... array){
		return array;
	}

	public static int random(int min, int max) {
		return (int) Math.round(Math.random() * (max - min) + min);
	}
}