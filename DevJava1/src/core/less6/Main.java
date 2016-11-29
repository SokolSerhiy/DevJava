package core.less6;

public class Main {

	public static void main(String[] args) {
		Person person = new Person(18, "Ivan", Gender.MALE);
		Gender gender = Gender.MALE;
		System.out.println(gender==person.getGender());
		if(person.getGender()==Gender.MALE){
			System.out.println("Ivan мужик");
		}
		System.out.println(person);
		
		Month[] months = Month.values();
		for (int i = 0; i < months.length; i++) {
			System.out.println(months[i]);
		}
		String s = "may";
		Month month = Month.valueOf(s.toUpperCase());
		System.out.println(month.getDays());
		System.out.println(month.compareTo(Month.DECEMBER));
		System.out.println(month.ordinal());
		int ord = month.ordinal();
		System.out.println(Month.values()[ord].name());
		System.out.println();
		for (int i = 0; i < months.length; i++) {
			if(months[i].getSeason()==Season.SUMMER){
				System.out.println(months[i]);
			}
		}
	}
}