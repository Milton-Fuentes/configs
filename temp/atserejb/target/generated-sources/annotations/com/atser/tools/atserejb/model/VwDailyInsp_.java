package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwDailyInsp.class)
public abstract class VwDailyInsp_ {

	public static volatile SingularAttribute<VwDailyInsp, BigInteger> clientId;
	public static volatile SingularAttribute<VwDailyInsp, String> testNo;
	public static volatile SingularAttribute<VwDailyInsp, String> traceNo;
	public static volatile SingularAttribute<VwDailyInsp, BigInteger> leadInspId;
	public static volatile SingularAttribute<VwDailyInsp, String> inspectorId;
	public static volatile SingularAttribute<VwDailyInsp, String> cmLocation;
	public static volatile SingularAttribute<VwDailyInsp, String> lunchDuration;
	public static volatile SingularAttribute<VwDailyInsp, String> firm;
	public static volatile SingularAttribute<VwDailyInsp, BigDecimal> totalHrs;
	public static volatile SingularAttribute<VwDailyInsp, String> projectNo;
	public static volatile SingularAttribute<VwDailyInsp, String> pName;
	public static volatile SingularAttribute<VwDailyInsp, Date> reportDate;
	public static volatile SingularAttribute<VwDailyInsp, BigInteger> contractId;
	public static volatile SingularAttribute<VwDailyInsp, Date> dateOfTest;
	public static volatile SingularAttribute<VwDailyInsp, String> inspName;
	public static volatile SingularAttribute<VwDailyInsp, String> reportNoLink;
	public static volatile SingularAttribute<VwDailyInsp, String> startTime;
	public static volatile SingularAttribute<VwDailyInsp, BigDecimal> id;
	public static volatile SingularAttribute<VwDailyInsp, String> endTime;
	public static volatile SingularAttribute<VwDailyInsp, BigInteger> projectId;
	public static volatile SingularAttribute<VwDailyInsp, String> reportNo;
	public static volatile SingularAttribute<VwDailyInsp, String> status;

	public static final String CLIENT_ID = "clientId";
	public static final String TEST_NO = "testNo";
	public static final String TRACE_NO = "traceNo";
	public static final String LEAD_INSP_ID = "leadInspId";
	public static final String INSPECTOR_ID = "inspectorId";
	public static final String CM_LOCATION = "cmLocation";
	public static final String LUNCH_DURATION = "lunchDuration";
	public static final String FIRM = "firm";
	public static final String TOTAL_HRS = "totalHrs";
	public static final String PROJECT_NO = "projectNo";
	public static final String P_NAME = "pName";
	public static final String REPORT_DATE = "reportDate";
	public static final String CONTRACT_ID = "contractId";
	public static final String DATE_OF_TEST = "dateOfTest";
	public static final String INSP_NAME = "inspName";
	public static final String REPORT_NO_LINK = "reportNoLink";
	public static final String START_TIME = "startTime";
	public static final String ID = "id";
	public static final String END_TIME = "endTime";
	public static final String PROJECT_ID = "projectId";
	public static final String REPORT_NO = "reportNo";
	public static final String STATUS = "status";

}

