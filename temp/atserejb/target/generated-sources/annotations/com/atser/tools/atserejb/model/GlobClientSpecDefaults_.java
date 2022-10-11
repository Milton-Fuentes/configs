package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientSpecDefaults.class)
public abstract class GlobClientSpecDefaults_ {

	public static volatile SingularAttribute<GlobClientSpecDefaults, BigInteger> specificationId;
	public static volatile SingularAttribute<GlobClientSpecDefaults, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientSpecDefaults, BigDecimal> id;

	public static final String SPECIFICATION_ID = "specificationId";
	public static final String CLIENT_ID = "clientId";
	public static final String ID = "id";

}

