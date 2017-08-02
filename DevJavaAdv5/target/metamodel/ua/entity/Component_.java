package ua.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Component.class)
public abstract class Component_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Component, BigDecimal> amount;
	public static volatile SingularAttribute<Component, Ingredient> ingredient;
	public static volatile SingularAttribute<Component, Ms> ms;
	public static volatile ListAttribute<Component, Meal> meals;

}

