package core.less4;

public class Main {

	public static void main(String[] args) {
		Robot robot = new RobotDancer();
		robot.work();
		Bard bard = new Bard("Lutik");
		SimpleBallada ballada = new SimpleBallada();
		bard.sing(ballada);
		HeroBallada ballada2 = new HeroBallada();
		bard.sing(ballada2);
	}
}