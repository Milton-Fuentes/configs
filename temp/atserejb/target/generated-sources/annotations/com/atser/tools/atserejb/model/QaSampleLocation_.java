package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaSampleLocation.class)
public abstract class QaSampleLocation_ {

	public static volatile SingularAttribute<QaSampleLocation, String> name;
	public static volatile SingularAttribute<QaSampleLocation, String> active;
	public static volatile SingularAttribute<QaSampleLocation, BigDecimal> id;

	public static final String NAME = "name";
	public static final String ACTIVE = "active";
	public static final String ID = "id";

}

