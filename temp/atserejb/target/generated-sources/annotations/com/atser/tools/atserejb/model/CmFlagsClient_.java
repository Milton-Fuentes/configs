package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmFlagsClient.class)
public abstract class CmFlagsClient_ {

	public static volatile SingularAttribute<CmFlagsClient, BigInteger> clientId;
	public static volatile SingularAttribute<CmFlagsClient, Character> flagValue;
	public static volatile SingularAttribute<CmFlagsClient, BigInteger> flagId;
	public static volatile SingularAttribute<CmFlagsClient, BigDecimal> id;

	public static final String CLIENT_ID = "clientId";
	public static final String FLAG_VALUE = "flagValue";
	public static final String FLAG_ID = "flagId";
	public static final String ID = "id";

}

