package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobServicesField.class)
public abstract class GlobServicesField_ {

	public static volatile SingularAttribute<GlobServicesField, BigInteger> clientId;
	public static volatile SingularAttribute<GlobServicesField, Integer> testMethodId;
	public static volatile SingularAttribute<GlobServicesField, String> serviceAbbrev;
	public static volatile SingularAttribute<GlobServicesField, String> serviceLong;
	public static volatile SingularAttribute<GlobServicesField, BigDecimal> id;
	public static volatile SingularAttribute<GlobServicesField, Integer> fieldOrder;

	public static final String CLIENT_ID = "clientId";
	public static final String TEST_METHOD_ID = "testMethodId";
	public static final String SERVICE_ABBREV = "serviceAbbrev";
	public static final String SERVICE_LONG = "serviceLong";
	public static final String ID = "id";
	public static final String FIELD_ORDER = "fieldOrder";

}

