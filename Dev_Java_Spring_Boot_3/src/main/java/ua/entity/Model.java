package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="model")
public class Model extends AbstractEntityName{
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Brand brand;

	@OneToMany(mappedBy="model")
	private List<Transporter> transporters = new ArrayList<>();

	public Model(String name) {
		super(name);
	}

	public Model() {
	}
}
