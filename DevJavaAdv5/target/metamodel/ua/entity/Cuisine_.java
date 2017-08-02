package ua.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cuisine.class)
public abstract class Cuisine_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Cuisine, String> name;
	public static volatile ListAttribute<Cuisine, Meal> meals;

}

