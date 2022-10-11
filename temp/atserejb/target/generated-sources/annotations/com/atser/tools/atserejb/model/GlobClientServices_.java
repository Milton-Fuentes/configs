package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientServices.class)
public abstract class GlobClientServices_ {

	public static volatile SingularAttribute<GlobClientServices, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientServices, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientServices, BigInteger> serviceId;

	public static final String CLIENT_ID = "clientId";
	public static final String ID = "id";
	public static final String SERVICE_ID = "serviceId";

}

