package core.less14;

import java.util.ArrayList;
import java.util.List;


public class Person{

	private int age;
	
	private String name;
	
	private Gender gender;

	private List<Pet> pets = new ArrayList<>();
	
	public Person() {
	}

	public Person(int age, String name, Gender gender) {
		this.age = age;
		this.name = name;
		this.gender = gender;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
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
				+ ", pets=" + pets + "]";
	}

	public class Pet{
		
		private String name;

		public Pet(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof Pet))
				return false;
			Pet other = (Pet) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Pet [name=" + name + "]";
		}

		private Person getOuterType() {
			return Person.this;
		}
	}
	
	public static class Builder{
		
		private Person person = new Person();
		
		public Builder name(String name){
			person.name = name;
			return this;
		}
		
		public Builder age(int age){
			person.age = age;
			return this;
		}
		
		public Builder gender(Gender gender){
			person.gender = gender;
			return this;
		}
		
		public Builder pet(String name){
			person.pets.add(person.new Pet(name));
			return this;
		}
		
		public Person build(){
			return person;
		}
	}
}