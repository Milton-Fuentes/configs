package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobPortfolioBkt.class)
public abstract class GlobPortfolioBkt_ {

	public static volatile SingularAttribute<GlobPortfolioBkt, String> createdByIp;
	public static volatile SingularAttribute<GlobPortfolioBkt, String> lastModBy;
	public static volatile SingularAttribute<GlobPortfolioBkt, Date> created;
	public static volatile SingularAttribute<GlobPortfolioBkt, String> projectType;
	public static volatile SingularAttribute<GlobPortfolioBkt, Character> active;
	public static volatile SingularAttribute<GlobPortfolioBkt, Integer> version;
	public static volatile SingularAttribute<GlobPortfolioBkt, BigInteger> portfolioId;
	public static volatile SingularAttribute<GlobPortfolioBkt, String> lastModIp;
	public static volatile SingularAttribute<GlobPortfolioBkt, Character> deleted;
	public static volatile SingularAttribute<GlobPortfolioBkt, String> createdBy;
	public static volatile SingularAttribute<GlobPortfolioBkt, BigDecimal> id;
	public static volatile SingularAttribute<GlobPortfolioBkt, BigInteger> projectId;
	public static volatile SingularAttribute<GlobPortfolioBkt, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String PROJECT_TYPE = "projectType";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String PORTFOLIO_ID = "portfolioId";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String LAST_MOD = "lastMod";

}

