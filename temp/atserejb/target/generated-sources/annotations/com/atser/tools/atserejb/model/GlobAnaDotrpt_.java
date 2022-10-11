package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobAnaDotrpt.class)
public abstract class GlobAnaDotrpt_ {

	public static volatile SingularAttribute<GlobAnaDotrpt, BigInteger> reportOrder;
	public static volatile SingularAttribute<GlobAnaDotrpt, BigInteger> clientId;
	public static volatile SingularAttribute<GlobAnaDotrpt, String> reportName;
	public static volatile SingularAttribute<GlobAnaDotrpt, Character> active;
	public static volatile SingularAttribute<GlobAnaDotrpt, BigDecimal> id;
	public static volatile SingularAttribute<GlobAnaDotrpt, BigInteger> reportNo;

	public static final String REPORT_ORDER = "reportOrder";
	public static final String CLIENT_ID = "clientId";
	public static final String REPORT_NAME = "reportName";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String REPORT_NO = "reportNo";

}

