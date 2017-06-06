package less13.tt;

import java.io.Serializable;

public class Profession implements Serializable{

	private static final long serialVersionUID = 5169676634588836697L;

	private String name;
	
	private int minPayment;

	public Profession(String name, int minPayment) {
		this.name = name;
		this.minPayment = minPayment;
	}

	public Profession(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinPayment() {
		return minPayment;
	}

	public void setMinPayment(int minPayment) {
		this.minPayment = minPayment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Profession))
			return false;
		Profession other = (Profession) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profession [name=" + name + ", minPayment=" + minPayment + "]";
	}
}