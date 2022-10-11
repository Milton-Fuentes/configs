package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectInsptplanInfo.class)
public abstract class GlobProjectInsptplanInfo_ {

	public static volatile SingularAttribute<GlobProjectInsptplanInfo, String> lastModBy;
	public static volatile SingularAttribute<GlobProjectInsptplanInfo, BigInteger> planInterval;
	public static volatile SingularAttribute<GlobProjectInsptplanInfo, String> planName;
	public static volatile SingularAttribute<GlobProjectInsptplanInfo, String> version;
	public static volatile SingularAttribute<GlobProjectInsptplanInfo, String> createByIp;
	public static volatile SingularAttribute<GlobProjectInsptplanInfo, BigInteger> duration;
	public static volatile SingularAttribute<GlobProjectInsptplanInfo, String> createBy;
	public static volatile SingularAttribute<GlobProjectInsptplanInfo, String> lastModIp;
	public static volatile SingularAttribute<GlobProjectInsptplanInfo, BigInteger> labId;
	public static volatile SingularAttribute<GlobProjectInsptplanInfo, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectInsptplanInfo, BigInteger> projectId;
	public static volatile SingularAttribute<GlobProjectInsptplanInfo, String> lastMod;
	public static volatile SingularAttribute<GlobProjectInsptplanInfo, Date> startDate;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String PLAN_INTERVAL = "planInterval";
	public static final String PLAN_NAME = "planName";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String DURATION = "duration";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String LAB_ID = "labId";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String LAST_MOD = "lastMod";
	public static final String START_DATE = "startDate";

}

