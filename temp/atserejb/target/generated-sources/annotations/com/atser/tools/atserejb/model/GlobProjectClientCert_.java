package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectClientCert.class)
public abstract class GlobProjectClientCert_ {

	public static volatile SingularAttribute<GlobProjectClientCert, BigInteger> listOrder;
	public static volatile SingularAttribute<GlobProjectClientCert, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectClientCert, BigInteger> projectClientId;
	public static volatile SingularAttribute<GlobProjectClientCert, String> certification;

	public static final String LIST_ORDER = "listOrder";
	public static final String ID = "id";
	public static final String PROJECT_CLIENT_ID = "projectClientId";
	public static final String CERTIFICATION = "certification";

}

