package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSystemProperties.class)
public abstract class GlobSystemProperties_ {

	public static volatile SingularAttribute<GlobSystemProperties, BigInteger> clientId;
	public static volatile SingularAttribute<GlobSystemProperties, String> pvalue;
	public static volatile SingularAttribute<GlobSystemProperties, BigDecimal> id;
	public static volatile SingularAttribute<GlobSystemProperties, String> pkey;
	public static volatile SingularAttribute<GlobSystemProperties, BigInteger> projectId;
	public static volatile SingularAttribute<GlobSystemProperties, String> remarks;

	public static final String CLIENT_ID = "clientId";
	public static final String PVALUE = "pvalue";
	public static final String ID = "id";
	public static final String PKEY = "pkey";
	public static final String PROJECT_ID = "projectId";
	public static final String REMARKS = "remarks";

}

