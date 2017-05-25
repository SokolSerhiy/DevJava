package less08.user;

public class UserDB implements User{

	private final int age;
	
	private final String name;

	public UserDB(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public void save() {
		System.out.print(this);
		System.out.println(" saved to data base");
	}

	@Override
	public String toString() {
		return "UserDB [age=" + age + ", name=" + name + "]";
	}
}