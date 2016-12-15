package zoo.club.model;

import java.io.Serializable;

public class Pet implements Serializable{

	private static final long serialVersionUID = 1245643416310900400L;

	private String name;
	
	private Type type;
	
	public Pet(String name, Type type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
//		return name + " " + type + "\n";
		return name + " " + type;
	}
}
