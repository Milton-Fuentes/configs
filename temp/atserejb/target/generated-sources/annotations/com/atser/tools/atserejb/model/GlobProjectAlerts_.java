package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectAlerts.class)
public abstract class GlobProjectAlerts_ {

	public static volatile SingularAttribute<GlobProjectAlerts, String> alertType;
	public static volatile SingularAttribute<GlobProjectAlerts, String> lastModBy;
	public static volatile SingularAttribute<GlobProjectAlerts, BigInteger> contactId;
	public static volatile SingularAttribute<GlobProjectAlerts, Character> active;
	public static volatile SingularAttribute<GlobProjectAlerts, String> createByIp;
	public static volatile SingularAttribute<GlobProjectAlerts, String> createBy;
	public static volatile SingularAttribute<GlobProjectAlerts, String> lastModIp;
	public static volatile SingularAttribute<GlobProjectAlerts, Date> alerted;
	public static volatile SingularAttribute<GlobProjectAlerts, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectAlerts, BigInteger> projectId;
	public static volatile SingularAttribute<GlobProjectAlerts, String> lastMod;
	public static volatile SingularAttribute<GlobProjectAlerts, BigInteger> alertDays;
	public static volatile SingularAttribute<GlobProjectAlerts, Date> createDate;

	public static final String ALERT_TYPE = "alertType";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CONTACT_ID = "contactId";
	public static final String ACTIVE = "active";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ALERTED = "alerted";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String LAST_MOD = "lastMod";
	public static final String ALERT_DAYS = "alertDays";
	public static final String CREATE_DATE = "createDate";

}

