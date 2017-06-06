package less13.tt;

import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = 3066905765128900707L;

	private String name;
	
	private int payment;

	public Person(String name, int payment) {
		this.name = name;
		this.payment = payment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", payment=" + payment + "]";
	}
}