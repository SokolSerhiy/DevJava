package ua.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Goods.class)
public abstract class Goods_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Goods, String> name;
	public static volatile ListAttribute<Goods, Cargo> cargos;

}

