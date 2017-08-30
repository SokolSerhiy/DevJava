package ua.entity;

import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.NotBlank;

@MappedSuperclass
public abstract class AbstractEntityName extends AbstractEntity{
	
	@NotBlank(message="Поле не може бути пустим")
	private String name;

	public AbstractEntityName() {
	}

	public AbstractEntityName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}