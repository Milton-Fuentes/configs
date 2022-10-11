package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobServices.class)
public abstract class GlobServices_ {

	public static volatile SingularAttribute<GlobServices, String> serviceTableName;
	public static volatile SingularAttribute<GlobServices, String> serviceNameAbbr;
	public static volatile SingularAttribute<GlobServices, BigDecimal> id;
	public static volatile SingularAttribute<GlobServices, String> serviceName;

	public static final String SERVICE_TABLE_NAME = "serviceTableName";
	public static final String SERVICE_NAME_ABBR = "serviceNameAbbr";
	public static final String ID = "id";
	public static final String SERVICE_NAME = "serviceName";

}

