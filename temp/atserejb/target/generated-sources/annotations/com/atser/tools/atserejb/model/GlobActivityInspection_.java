package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobActivityInspection.class)
public abstract class GlobActivityInspection_ {

	public static volatile SingularAttribute<GlobActivityInspection, Date> temp;
	public static volatile SingularAttribute<GlobActivityInspection, String> lastModBy;
	public static volatile SingularAttribute<GlobActivityInspection, String> tempTmp;
	public static volatile SingularAttribute<GlobActivityInspection, String> createDateTmp;
	public static volatile SingularAttribute<GlobActivityInspection, Character> active;
	public static volatile SingularAttribute<GlobActivityInspection, String> createByIp;
	public static volatile SingularAttribute<GlobActivityInspection, GlobActivity> activityId;
	public static volatile SingularAttribute<GlobActivityInspection, String> createBy;
	public static volatile SingularAttribute<GlobActivityInspection, String> lastModIp;
	public static volatile SingularAttribute<GlobActivityInspection, String> lastModTmp;
	public static volatile SingularAttribute<GlobActivityInspection, InReport> inReportId;
	public static volatile SingularAttribute<GlobActivityInspection, BigDecimal> id;
	public static volatile SingularAttribute<GlobActivityInspection, Date> lastMod;
	public static volatile SingularAttribute<GlobActivityInspection, Date> createDate;

	public static final String TEMP = "temp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String TEMP_TMP = "tempTmp";
	public static final String CREATE_DATE_TMP = "createDateTmp";
	public static final String ACTIVE = "active";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String ACTIVITY_ID = "activityId";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String LAST_MOD_TMP = "lastModTmp";
	public static final String IN_REPORT_ID = "inReportId";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";

}

