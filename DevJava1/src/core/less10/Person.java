package core.less10;

import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable{

	private static final long serialVersionUID = 1080900114217967779L;

	private int age;
	
	private String name;
	
	private Gender gender;

	public Person(int age, String name, Gender gender) {
		this.age = age;
		this.name = name;
		this.gender = gender;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Person)) return false;
		Person other = (Person) obj;
		if (age != other.age) return false;
		if (gender != other.gender) return false;
		if (name == null) {
			if (other.name != null) return false;
		} else if (!name.equals(other.name)) return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", gender=" + gender
				+ "]";
	}

	@Override
	public int compareTo(Person o) {
		return name.compareTo(o.name);
	}
}
