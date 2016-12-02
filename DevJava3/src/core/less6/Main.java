package core.less6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Person person = new Person("Ivan", 18, Gender.MALE);
		Gender gender = Gender.MALE;
		System.out.println(Gender.MALE == Gender.MALE);
		System.out.println(Gender.MALE == gender);
		System.out.println(Gender.MALE == person.getGender());
		if (Gender.MALE == person.getGender()) {
			System.out.println("мужик");
		}
		System.out.println(person);

		Month[] months = Month.values();
		for (int i = 0; i < months.length; i++) {
			System.out.println(months[i]);
		}
		String str = "may";
		Month month = Month.valueOf(str.toUpperCase());
		System.out.println(month);

		System.out.println(month.compareTo(Month.APRIL));
		System.out.println(month.ordinal());

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter 1 to show months by season");
			System.out.println("Enter 2 to show months by days");
			switch (scanner.next()) {
			case "1":
				System.out.println("Enter season");
				String seasonName = scanner.next();
				Season season = Season.valueOf(seasonName.toUpperCase());
				for (int i = 0; i < months.length; i++) {
					if(months[i].getSeason()==season){
						System.out.println(months[i]);
					}
				}
				break;
			case "2":
				System.out.println("Enter count of days");
				int days = scanner.nextInt();
				for (int i = 0; i < months.length; i++) {
					if(months[i].getDays()==days){
						System.out.println(months[i]);
					}
				}
				break;
			default:
				scanner.close();
				System.exit(0);
			}
		}
		
		
	}
	
	static boolean exist(Enum<?>[] enums, String name){
		name = name.toUpperCase();
		for (int i = 0; i < enums.length; i++) {
			if(enums[i].name().equals(name)){
				return true;
			}
		}
		return false;
	}
}