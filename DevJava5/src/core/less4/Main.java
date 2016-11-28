package core.less4;

public class Main {

	public static void main(String[] args) {
		Robot robot = new RobotDancer();
		robot.work();
		Ballada ballada = new SimpleBallada();
		Bard bard = new Bard("Lutik");
		bard.sing(ballada);
		Ballada ballada2 = new HeroBallada();
		bard.sing(ballada2);
		
	}
}