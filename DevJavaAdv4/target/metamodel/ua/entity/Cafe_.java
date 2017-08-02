package ua.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cafe.class)
public abstract class Cafe_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Cafe, String> address;
	public static volatile SingularAttribute<Cafe, String> shortDescription;
	public static volatile SingularAttribute<Cafe, String> fullDescription;
	public static volatile SingularAttribute<Cafe, Type> type;
	public static volatile SingularAttribute<Cafe, Integer> version;
	public static volatile SingularAttribute<Cafe, String> photoUrl;
	public static volatile ListAttribute<Cafe, Table> tables;
	public static volatile SingularAttribute<Cafe, BigDecimal> rate;
	public static volatile SingularAttribute<Cafe, String> phone;
	public static volatile SingularAttribute<Cafe, String> name;
	public static volatile SingularAttribute<Cafe, OpenClose> close;
	public static volatile SingularAttribute<Cafe, String> email;
	public static volatile SingularAttribute<Cafe, OpenClose> open;
	public static volatile ListAttribute<Cafe, Meal> meals;

}

