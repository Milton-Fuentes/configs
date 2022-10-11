package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientDivisions.class)
public abstract class GlobClientDivisions_ {

	public static volatile SingularAttribute<GlobClientDivisions, String> division;
	public static volatile SingularAttribute<GlobClientDivisions, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientDivisions, BigDecimal> id;

	public static final String DIVISION = "division";
	public static final String CLIENT_ID = "clientId";
	public static final String ID = "id";

}

