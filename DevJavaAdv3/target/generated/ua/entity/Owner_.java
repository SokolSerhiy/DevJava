package ua.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Owner.class)
public abstract class Owner_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Owner, String> address;
	public static volatile SingularAttribute<Owner, String> phone;
	public static volatile SingularAttribute<Owner, String> name;
	public static volatile SingularAttribute<Owner, Integer> count;
	public static volatile ListAttribute<Owner, Cargo> cargos;

}

