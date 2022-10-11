package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSieveListClient.class)
public abstract class GlobSieveListClient_ {

	public static volatile SingularAttribute<GlobSieveListClient, String> commonName;
	public static volatile SingularAttribute<GlobSieveListClient, BigInteger> clientId;
	public static volatile SingularAttribute<GlobSieveListClient, GlobSievelist> sieveId;
	public static volatile SingularAttribute<GlobSieveListClient, BigDecimal> id;

	public static final String COMMON_NAME = "commonName";
	public static final String CLIENT_ID = "clientId";
	public static final String SIEVE_ID = "sieveId";
	public static final String ID = "id";

}

