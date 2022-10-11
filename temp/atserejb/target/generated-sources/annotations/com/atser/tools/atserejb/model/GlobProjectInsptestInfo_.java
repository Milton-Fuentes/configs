package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectInsptestInfo.class)
public abstract class GlobProjectInsptestInfo_ {

	public static volatile SingularAttribute<GlobProjectInsptestInfo, String> lastModBy;
	public static volatile SingularAttribute<GlobProjectInsptestInfo, BigInteger> planInterval;
	public static volatile SingularAttribute<GlobProjectInsptestInfo, String> planName;
	public static volatile SingularAttribute<GlobProjectInsptestInfo, String> version;
	public static volatile SingularAttribute<GlobProjectInsptestInfo, String> createByIp;
	public static volatile SingularAttribute<GlobProjectInsptestInfo, BigInteger> duration;
	public static volatile SingularAttribute<GlobProjectInsptestInfo, String> createBy;
	public static volatile SingularAttribute<GlobProjectInsptestInfo, String> lastModIp;
	public static volatile SingularAttribute<GlobProjectInsptestInfo, BigInteger> labId;
	public static volatile SingularAttribute<GlobProjectInsptestInfo, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectInsptestInfo, BigInteger> projectId;
	public static volatile SingularAttribute<GlobProjectInsptestInfo, String> lastMod;
	public static volatile SingularAttribute<GlobProjectInsptestInfo, Date> startDate;

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

