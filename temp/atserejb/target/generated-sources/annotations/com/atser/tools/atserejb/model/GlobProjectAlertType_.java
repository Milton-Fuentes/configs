package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectAlertType.class)
public abstract class GlobProjectAlertType_ {

	public static volatile SingularAttribute<GlobProjectAlertType, String> createBy;
	public static volatile SingularAttribute<GlobProjectAlertType, String> alertType;
	public static volatile SingularAttribute<GlobProjectAlertType, String> lastModBy;
	public static volatile SingularAttribute<GlobProjectAlertType, String> lastModIp;
	public static volatile SingularAttribute<GlobProjectAlertType, String> alertCaption;
	public static volatile SingularAttribute<GlobProjectAlertType, BigInteger> alertDefault;
	public static volatile SingularAttribute<GlobProjectAlertType, Character> active;
	public static volatile SingularAttribute<GlobProjectAlertType, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectAlertType, String> alertValueType;
	public static volatile SingularAttribute<GlobProjectAlertType, String> lastMod;
	public static volatile SingularAttribute<GlobProjectAlertType, String> createByIp;
	public static volatile SingularAttribute<GlobProjectAlertType, Date> createDate;

	public static final String CREATE_BY = "createBy";
	public static final String ALERT_TYPE = "alertType";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ALERT_CAPTION = "alertCaption";
	public static final String ALERT_DEFAULT = "alertDefault";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String ALERT_VALUE_TYPE = "alertValueType";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_DATE = "createDate";

}

