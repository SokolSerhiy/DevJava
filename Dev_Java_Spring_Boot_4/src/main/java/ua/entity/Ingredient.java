package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ingredient")
public class Ingredient extends AbstractEntity{

	private String name;
	
	@ManyToMany(mappedBy="ingredients")
	private List<Meal> meals = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
}
