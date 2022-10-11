package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientOfficeLocation.class)
public abstract class GlobClientOfficeLocation_ {

	public static volatile SingularAttribute<GlobClientOfficeLocation, String> locationNo;
	public static volatile SingularAttribute<GlobClientOfficeLocation, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientOfficeLocation, BigInteger> regionId;
	public static volatile SingularAttribute<GlobClientOfficeLocation, String> location;
	public static volatile SingularAttribute<GlobClientOfficeLocation, BigDecimal> id;

	public static final String LOCATION_NO = "locationNo";
	public static final String CLIENT_ID = "clientId";
	public static final String REGION_ID = "regionId";
	public static final String LOCATION = "location";
	public static final String ID = "id";

}

