package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobDispatchcallLog.class)
public abstract class GlobDispatchcallLog_ {

	public static volatile SingularAttribute<GlobDispatchcallLog, String> lastModBy;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> createDateTmp;
	public static volatile SingularAttribute<GlobDispatchcallLog, BigInteger> infoId;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> reqLocation;
	public static volatile SingularAttribute<GlobDispatchcallLog, Date> serviceDate;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> specInstr;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> serviceDateTmp;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> lastModIp;
	public static volatile SingularAttribute<GlobDispatchcallLog, BigInteger> techRefId;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> emailReason;
	public static volatile SingularAttribute<GlobDispatchcallLog, BigInteger> requestOrigId;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> timeSite;
	public static volatile SingularAttribute<GlobDispatchcallLog, BigDecimal> id;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> requestedDate;
	public static volatile SingularAttribute<GlobDispatchcallLog, BigInteger> certBillingCodeId;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> cancelledReason;
	public static volatile SingularAttribute<GlobDispatchcallLog, Date> createDate;
	public static volatile SingularAttribute<GlobDispatchcallLog, BigDecimal> hours;
	public static volatile SingularAttribute<GlobDispatchcallLog, GlobWorkorder> woId;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> assignment;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> requestedDateTmp;
	public static volatile SingularAttribute<GlobDispatchcallLog, Character> active;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> technician;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> dept;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> version;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> createByIp;
	public static volatile SingularAttribute<GlobDispatchcallLog, Long> decisionFlag;
	public static volatile SingularAttribute<GlobDispatchcallLog, BigInteger> folderId;
	public static volatile SingularAttribute<GlobDispatchcallLog, BigInteger> parentId;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> requestedBy;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> createBy;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> emailStatus;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> servicesRequested;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> requestedTime;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> lastModTmp;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> cancelled;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> reportKey;
	public static volatile SingularAttribute<GlobDispatchcallLog, BigInteger> projectId;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> lastMod;
	public static volatile SingularAttribute<GlobDispatchcallLog, Character> paperworkReceived;
	public static volatile SingularAttribute<GlobDispatchcallLog, String> status;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATE_DATE_TMP = "createDateTmp";
	public static final String INFO_ID = "infoId";
	public static final String REQ_LOCATION = "reqLocation";
	public static final String SERVICE_DATE = "serviceDate";
	public static final String SPEC_INSTR = "specInstr";
	public static final String SERVICE_DATE_TMP = "serviceDateTmp";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String TECH_REF_ID = "techRefId";
	public static final String EMAIL_REASON = "emailReason";
	public static final String REQUEST_ORIG_ID = "requestOrigId";
	public static final String TIME_SITE = "timeSite";
	public static final String ID = "id";
	public static final String REQUESTED_DATE = "requestedDate";
	public static final String CERT_BILLING_CODE_ID = "certBillingCodeId";
	public static final String CANCELLED_REASON = "cancelledReason";
	public static final String CREATE_DATE = "createDate";
	public static final String HOURS = "hours";
	public static final String WO_ID = "woId";
	public static final String ASSIGNMENT = "assignment";
	public static final String REQUESTED_DATE_TMP = "requestedDateTmp";
	public static final String ACTIVE = "active";
	public static final String TECHNICIAN = "technician";
	public static final String DEPT = "dept";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String DECISION_FLAG = "decisionFlag";
	public static final String FOLDER_ID = "folderId";
	public static final String PARENT_ID = "parentId";
	public static final String REQUESTED_BY = "requestedBy";
	public static final String CREATE_BY = "createBy";
	public static final String EMAIL_STATUS = "emailStatus";
	public static final String SERVICES_REQUESTED = "servicesRequested";
	public static final String REQUESTED_TIME = "requestedTime";
	public static final String LAST_MOD_TMP = "lastModTmp";
	public static final String CANCELLED = "cancelled";
	public static final String REPORT_KEY = "reportKey";
	public static final String PROJECT_ID = "projectId";
	public static final String LAST_MOD = "lastMod";
	public static final String PAPERWORK_RECEIVED = "paperworkReceived";
	public static final String STATUS = "status";

}

