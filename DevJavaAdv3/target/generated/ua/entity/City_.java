package ua.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(City.class)
public abstract class City_ extends ua.entity.AbstractEntity_ {

	public static volatile ListAttribute<City, Transporter> transporters;
	public static volatile SingularAttribute<City, String> name;
	public static volatile ListAttribute<City, Cargo> cargosTo;
	public static volatile ListAttribute<City, Cargo> cargosFrom;

}

