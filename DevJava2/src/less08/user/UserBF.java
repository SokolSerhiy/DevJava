package less08.user;

public class UserBF implements User{

	private final int age;
	
	private final String name;

	public UserBF(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public void save() {
		System.out.print(this);
		System.out.println(" saved to binary file");
	}

	@Override
	public String toString() {
		return "UserBF [age=" + age + ", name=" + name + "]";
	}
}
