package core.less6;

public class Main {

	public static void main(String[] args) {
		Person person = new Person("Ivan", 18, Gender.MALE);
		Gender gender = Gender.MALE;
		System.out.println(gender == person.getGender());
		System.out.println(person);

		Month[] months = Month.values();
		for (int i = 0; i < months.length; i++) {
			System.out.println(months[i]);
		}
		Month month = Month.valueOf("may".toUpperCase());
		System.out.println();
		System.out.println(month);
		System.out.println(Month.values()[9 - 1]);

		System.out.println(month.compareTo(Month.APRIL));
		System.out.println(month.ordinal());

		System.out.println();
		for (int i = 0; i < months.length; i++) {
			if (months[i].getSeason() == Season.SUMMER) {
				System.out.println(months[i]);
			}
		}
	}
}