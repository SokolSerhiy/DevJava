package ua.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Meal.class)
public abstract class Meal_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Meal, String> photoUrl;
	public static volatile SingularAttribute<Meal, Cafe> cafe;
	public static volatile SingularAttribute<Meal, BigDecimal> price;
	public static volatile SingularAttribute<Meal, String> description;
	public static volatile SingularAttribute<Meal, Cuisine> cuisine;
	public static volatile SingularAttribute<Meal, Integer> weight;
	public static volatile ListAttribute<Meal, Ingredient> ingredients;
	public static volatile ListAttribute<Meal, Order> orders;
	public static volatile SingularAttribute<Meal, String> title;
	public static volatile SingularAttribute<Meal, Integer> version;

}

