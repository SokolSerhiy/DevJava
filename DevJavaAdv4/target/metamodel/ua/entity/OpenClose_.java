package ua.entity;

import java.time.LocalTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OpenClose.class)
public abstract class OpenClose_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<OpenClose, LocalTime> time;
	public static volatile ListAttribute<OpenClose, Cafe> closedCafes;
	public static volatile ListAttribute<OpenClose, Cafe> openedCafes;

}

