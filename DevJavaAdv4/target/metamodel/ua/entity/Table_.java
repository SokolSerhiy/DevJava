package ua.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Table.class)
public abstract class Table_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Table, Cafe> cafe;
	public static volatile SingularAttribute<Table, Boolean> isFree;
	public static volatile SingularAttribute<Table, Integer> countOfPeople;

}

