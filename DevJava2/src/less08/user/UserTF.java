package less08.user;

public class UserTF implements User{

	private final int age;
	
	private final String name;

	public UserTF(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public void save() {
		System.out.print(this);
		System.out.println(" saved to text file");
	}

	@Override
	public String toString() {
		return "UserTF [age=" + age + ", name=" + name + "]";
	}
}
