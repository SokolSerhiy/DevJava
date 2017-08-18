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
	private List<Model> models = new ArrayList<>();

	public Brand(String name) {
		super(name);
	}

	public Brand() {
	}

	public List<Model> getModels() {
		return models;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}
}
