package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobAnaSumrpt.class)
public abstract class GlobAnaSumrpt_ {

	public static volatile SingularAttribute<GlobAnaSumrpt, BigInteger> reportOrder;
	public static volatile SingularAttribute<GlobAnaSumrpt, BigInteger> clientId;
	public static volatile SingularAttribute<GlobAnaSumrpt, String> reportName;
	public static volatile SingularAttribute<GlobAnaSumrpt, Character> active;
	public static volatile SingularAttribute<GlobAnaSumrpt, BigDecimal> id;
	public static volatile SingularAttribute<GlobAnaSumrpt, BigInteger> reportNo;

	public static final String REPORT_ORDER = "reportOrder";
	public static final String CLIENT_ID = "clientId";
	public static final String REPORT_NAME = "reportName";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String REPORT_NO = "reportNo";

}

