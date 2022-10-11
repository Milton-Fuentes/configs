package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientAlerts.class)
public abstract class GlobClientAlerts_ {

	public static volatile SingularAttribute<GlobClientAlerts, BigInteger> alertTypeId;
	public static volatile SingularAttribute<GlobClientAlerts, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientAlerts, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientAlerts, BigInteger> alertDays;

	public static final String ALERT_TYPE_ID = "alertTypeId";
	public static final String CLIENT_ID = "clientId";
	public static final String ID = "id";
	public static final String ALERT_DAYS = "alertDays";

}

