package ua.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ingredient.class)
public abstract class Ingredient_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Ingredient, String> name;
	public static volatile ListAttribute<Ingredient, Meal> meals;

}

