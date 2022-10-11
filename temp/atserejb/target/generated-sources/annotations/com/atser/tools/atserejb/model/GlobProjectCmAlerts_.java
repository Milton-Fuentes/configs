package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectCmAlerts.class)
public abstract class GlobProjectCmAlerts_ {

	public static volatile SingularAttribute<GlobProjectCmAlerts, BigInteger> alertTypeId;
	public static volatile SingularAttribute<GlobProjectCmAlerts, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectCmAlerts, BigInteger> projectId;
	public static volatile SingularAttribute<GlobProjectCmAlerts, BigInteger> alertDays;

	public static final String ALERT_TYPE_ID = "alertTypeId";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String ALERT_DAYS = "alertDays";

}

