package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cuisine")
public class Cuisine extends AbstractEntityName{
	
	public Cuisine() {
	}
	
	public Cuisine(String name) {
		super(name);
	}

	@OneToMany(mappedBy="cuisine")
	private List<Meal> meals = new ArrayList<>();

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
}
