package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSchedule.class)
public abstract class GlobSchedule_ {

	public static volatile SingularAttribute<GlobSchedule, String> name;
	public static volatile SingularAttribute<GlobSchedule, String> description;
	public static volatile SingularAttribute<GlobSchedule, BigDecimal> id;

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}

