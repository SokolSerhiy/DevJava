package less06;

public class Main {

	public static void main(String[] args) {
		Human human = new Human();
		human.age = 18;
		human.name = "Ivan";
		human.printData();
		human.run();
		Human human2 = new Human("Mykola", 25);
		System.out.println(human2);
		new Thread(()->{
			while (human.run(random(50, 300))) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
				}
			}
		}).start();
		new Thread(()->{
			while (human2.run(random(50, 300))) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
				}
			}
		}).start();
	}
	
	static int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
}