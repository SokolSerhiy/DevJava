package ua.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntityName extends AbstractEntity{

	private String name;

	public AbstractEntityName(String name) {
		this.name = name;
	}

	public AbstractEntityName() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
