package ua.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Transporter.class)
public abstract class Transporter_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Transporter, LocalDateTime> dateArrive;
	public static volatile SingularAttribute<Transporter, Integer> count;
	public static volatile SingularAttribute<Transporter, Integer> maxWeight;
	public static volatile SingularAttribute<Transporter, Integer> version;
	public static volatile SingularAttribute<Transporter, Integer> carAge;
	public static volatile SingularAttribute<Transporter, String> photoUrl;
	public static volatile SingularAttribute<Transporter, BigDecimal> rate;
	public static volatile SingularAttribute<Transporter, String> phone;
	public static volatile SingularAttribute<Transporter, String> name;
	public static volatile SingularAttribute<Transporter, Model> model;
	public static volatile SingularAttribute<Transporter, City> cityArrive;
	public static volatile SingularAttribute<Transporter, Brand> brand;
	public static volatile SingularAttribute<Transporter, Integer> age;
	public static volatile SingularAttribute<Transporter, Status> status;

}

