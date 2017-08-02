package ua.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cargo.class)
public abstract class Cargo_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Cargo, Owner> owner;
	public static volatile SingularAttribute<Cargo, BigDecimal> price;
	public static volatile SingularAttribute<Cargo, Integer> width;
	public static volatile SingularAttribute<Cargo, Integer> length;
	public static volatile SingularAttribute<Cargo, Goods> goods;
	public static volatile SingularAttribute<Cargo, Integer> weight;
	public static volatile SingularAttribute<Cargo, City> cityFrom;
	public static volatile SingularAttribute<Cargo, City> cityTo;
	public static volatile SingularAttribute<Cargo, Integer> height;

}

