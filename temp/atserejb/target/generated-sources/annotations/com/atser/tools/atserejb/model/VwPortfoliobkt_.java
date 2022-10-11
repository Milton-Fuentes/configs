package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwPortfoliobkt.class)
public abstract class VwPortfoliobkt_ {

	public static volatile SingularAttribute<VwPortfoliobkt, BigInteger> portfolioId;
	public static volatile SingularAttribute<VwPortfoliobkt, String> pName;
	public static volatile SingularAttribute<VwPortfoliobkt, String> pType;
	public static volatile SingularAttribute<VwPortfoliobkt, String> description;
	public static volatile SingularAttribute<VwPortfoliobkt, BigDecimal> id;
	public static volatile SingularAttribute<VwPortfoliobkt, BigInteger> projectId;
	public static volatile SingularAttribute<VwPortfoliobkt, String> pNumber;

	public static final String PORTFOLIO_ID = "portfolioId";
	public static final String P_NAME = "pName";
	public static final String P_TYPE = "pType";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String P_NUMBER = "pNumber";

}

