package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobServiceCenter.class)
public abstract class GlobServiceCenter_ {

	public static volatile SingularAttribute<GlobServiceCenter, BigInteger> clientId;
	public static volatile SingularAttribute<GlobServiceCenter, BigDecimal> id;
	public static volatile SingularAttribute<GlobServiceCenter, String> serviceCenter;

	public static final String CLIENT_ID = "clientId";
	public static final String ID = "id";
	public static final String SERVICE_CENTER = "serviceCenter";

}

