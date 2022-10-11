package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobDepartmentLocation.class)
public abstract class GlobDepartmentLocation_ {

	public static volatile SingularAttribute<GlobDepartmentLocation, String> locationNo;
	public static volatile SingularAttribute<GlobDepartmentLocation, BigInteger> clientId;
	public static volatile SingularAttribute<GlobDepartmentLocation, String> locationName;
	public static volatile SingularAttribute<GlobDepartmentLocation, BigDecimal> id;

	public static final String LOCATION_NO = "locationNo";
	public static final String CLIENT_ID = "clientId";
	public static final String LOCATION_NAME = "locationName";
	public static final String ID = "id";

}

