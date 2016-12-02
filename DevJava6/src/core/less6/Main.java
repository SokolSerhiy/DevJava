package core.less6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Person person = new Person("Ivan", 18, Gender.MALE);
		Gender gender = Gender.MALE;
		System.out.println(Gender.MALE == Gender.MALE);
		System.out.println(Gender.MALE == gender);
		System.out.println(Gender.MALE == person.getGender());

		Month[] months = Month.values();
		for (int i = 0; i < months.length; i++) {
			System.out.println(months[i]);
		}

		String monthName = "may";
		Month month = Month.valueOf(monthName.toUpperCase());
		System.out.println(month);
		int a = Integer.valueOf("1");

		System.out.println(month.compareTo(Month.APRIL));
		System.out.println(month.ordinal());

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter 1 to show months by season");
			System.out.println("Enter 2 to show months by days");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter name of season");
				String nameOfSeason = sc.next().toUpperCase();
				if(exist(Season.values(), nameOfSeason)){
					Season season = Season.valueOf(nameOfSeason);
					for (int i = 0; i < months.length; i++) {
						if(months[i].getSeason()==season){
							System.out.println(months[i]);
						}
					}
				}else{
					System.out.println("Not correct!!!");
				}
				break;
			case "2":
				System.out.println("Enter count of days");
				int count = sc.nextInt();
				for (int i = 0; i < months.length; i++) {
					if(months[i].getDays()==count){
						System.out.println(months[i]);
					}
				}
				break;
			default:
				sc.close();
				return;
			}
		}
	}
	
	static boolean exist(Enum<? extends Season>[] enums, String name){
		for (int i = 0; i < enums.length; i++) {
			if(enums[i].name().equals(name)){
				return true;
			}
		}
		return false;
	}
}