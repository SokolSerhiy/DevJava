package ua.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Place.class)
public abstract class Place_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Place, Integer> number;
	public static volatile SingularAttribute<Place, Boolean> isFree;
	public static volatile ListAttribute<Place, Order> orders;
	public static volatile SingularAttribute<Place, Integer> countOfPeople;

}

