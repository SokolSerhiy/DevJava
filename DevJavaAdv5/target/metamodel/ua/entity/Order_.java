package ua.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Order, Place> place;
	public static volatile ListAttribute<Order, Meal> meals;

}

