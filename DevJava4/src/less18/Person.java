package less18;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String name;
	
	private int age;
	
	private List<Pet> pets = new ArrayList<>();

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", pets=" + pets + "]";
	}

	public class Pet {
		
		private String name;

		public Pet(String name) {
			this.name = name;
			pets.add(this);
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
			if (this == obj) return true;
			if (obj == null) return false;
			if (!(obj instanceof Pet)) return false;
			Pet other = (Pet) obj;
			if (!getOuterType().equals(other.getOuterType())) return false;
			if (name == null) {
				if (other.name != null) return false;
			} else if (!name.equals(other.name)) return false;
			return true;
		}

		@Override
		public String toString() {
			return "Pet [name=" + name + "]";
		}

		private Person getOuterType() {
			return Person.this;
		}

		public String getName() {
			return name;
		}
	}
	
	public static class Builder {
		
		private Person person = new Person();
		
		public Builder name(String name){
			person.name = name;
			return this;
		}
		
		public Builder age(int age){
			person.age = age;
			return this;
		}
		
		public Builder pet(String petName) {
			person.new Pet(petName);
			return this;
		}
		
		public Person build() {
			return person;
		}
	}
}
