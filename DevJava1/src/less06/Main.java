package less06;

public class Main {

	public static void main(String[] args) {
		Human human1 = new Human("Ivan", 18);
//		human1.age = 18;
//		human1.name = "Ivan";
//		System.out.println(human1.name+" "+human1.age);
		human1.print();
		human1.age = 19;
//		System.out.println(human1.name+" "+human1.age);
		human1.print();
		Human human2 = getHuman();
//		System.out.println(human2.name+" "+human2.age);
		human2.print();
		human1.run();
		human2.run();
		human1.eat("chicken");
		human1.run();
		System.out.println(human1);
		human1.printThis();
	}
	
	static Human getHuman(){
		return new Human("Petro", 25);
	}
}