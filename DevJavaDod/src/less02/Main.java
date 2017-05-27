package less02;

public class Main {

	public static void main(String[] args) {
		Pair[] questions = new Pair[5];
		questions[0] = new Pair("Прізвище ведучого 'Поля чудес'", "Якубович");
		questions[1] = new Pair("На початку 1908 р. перші американські кіновиробники утворили в Каліфорнії столицю ілюзій і назвали її... ", "Голівуд");
		questions[2] = new Pair("Найвідоміший американський режисер мультиплікаційного кіно.", "Дісней");
		questions[3] = new Pair("Видатний актор і режисер німого кіно.", "Чаплін");
		questions[4] = new Pair("Виконавець ролі Гаррі Поттера в кіно.", "Редкліфф");
		questions[random(0, 4)].startGame();
	}
	
	static int random(int min, int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
}