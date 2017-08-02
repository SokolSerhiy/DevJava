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
	public static volatile ListAttribute<Meal, Component> components;
	public static volatile SingularAttribute<Meal, BigDecimal> rate;
	public static volatile SingularAttribute<Meal, BigDecimal> price;
	public static volatile SingularAttribute<Meal, String> name;
	public static volatile SingularAttribute<Meal, Integer> weight;
	public static volatile SingularAttribute<Meal, Cuisine> cuisine;
	public static volatile ListAttribute<Meal, Order> orders;
	public static volatile SingularAttribute<Meal, String> shortDescription;
	public static volatile SingularAttribute<Meal, String> fullDescription;
	public static volatile SingularAttribute<Meal, Integer> version;

}

