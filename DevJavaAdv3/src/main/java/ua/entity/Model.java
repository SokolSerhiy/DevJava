package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="model")
public class Model extends AbstractEntity{

	private String name;
	
	@OneToMany(mappedBy="model")
	private List<Transporter> transporters = new ArrayList<>();

	public Model(String name) {
		this.name = name;
	}

	public Model() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
