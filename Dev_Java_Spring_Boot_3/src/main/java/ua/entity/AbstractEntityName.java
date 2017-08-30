package ua.entity;

import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.NotBlank;

import ua.validation.annotation.UniqueBrand;

@MappedSuperclass
public abstract class AbstractEntityName extends AbstractEntity{
	
	@UniqueBrand(message="Такий бренд вже існує в БД")
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