package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientkey.class)
public abstract class GlobClientkey_ {

	public static volatile SingularAttribute<GlobClientkey, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientkey, String> clientkey;
	public static volatile SingularAttribute<GlobClientkey, BigDecimal> id;

	public static final String CLIENT_ID = "clientId";
	public static final String CLIENTKEY = "clientkey";
	public static final String ID = "id";

}

