package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="brand")
public class Brand extends AbstractEntityName{

	@OneToMany(mappedBy="brand")
	private List<Transporter> transporters = new ArrayList<>();

	public Brand(String name) {
		super(name);
	}

	public Brand() {
	}
}
