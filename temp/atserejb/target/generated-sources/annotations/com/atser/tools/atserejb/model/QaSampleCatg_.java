package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaSampleCatg.class)
public abstract class QaSampleCatg_ {

	public static volatile SingularAttribute<QaSampleCatg, String> name;
	public static volatile SingularAttribute<QaSampleCatg, String> description;
	public static volatile SingularAttribute<QaSampleCatg, BigDecimal> id;
	public static volatile SingularAttribute<QaSampleCatg, String> pageName;

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String PAGE_NAME = "pageName";

}

