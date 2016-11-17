package core.less2;

public class Main {

	public static void main(String... args) {
		Person p = new Person(18, "Ivan");
//		System.out.println(p.age);
//		System.out.println(p.name);
		Person p1 = new Person(20, "Petro");
		Person p2 = new Person("Mykola", 25);
		p.run(1);
		p1.run();
//		System.out.println(p1.age);
		System.out.println(p1.name);
		
		int[] array = getArray(1,2,3);
	}

	public static int random(int min, int max) {
		return (int) Math.round(Math.random() * (max - min) + min);
	}
	
	static int[] getArray(int... array){
		return array;
	}
	
	static void getArray(int elem){
		System.out.println("one");
	}
	
	static void getArray(int elem, int elem2){
		System.out.println("sec");
	}
}
