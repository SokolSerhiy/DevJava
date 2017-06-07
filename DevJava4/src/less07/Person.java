package less07;

public class Person extends Human{

//	private int age;
//	
//	private String name;
	
	public static int count;
	
	public Person() {
		count++;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}

	@Override
	public void run() {
		System.out.println("go-go-go");
	}
}