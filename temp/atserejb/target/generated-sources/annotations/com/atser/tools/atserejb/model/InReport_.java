package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(InReport.class)
public abstract class InReport_ {

	public static volatile SingularAttribute<InReport, String> approvedDateTmp;
	public static volatile SingularAttribute<InReport, String> reason;
	public static volatile SingularAttribute<InReport, String> lastModBy;
	public static volatile SingularAttribute<InReport, BigInteger> infoId;
	public static volatile SingularAttribute<InReport, String> tempTmp;
	public static volatile SingularAttribute<InReport, String> createDateTmp;
	public static volatile SingularAttribute<InReport, String> approvedBy;
	public static volatile SingularAttribute<InReport, Character> unapproved;
	public static volatile SingularAttribute<InReport, BigInteger> functionId;
	public static volatile SingularAttribute<InReport, String> lastModIp;
	public static volatile SingularAttribute<InReport, Date> reportDate;
	public static volatile ListAttribute<InReport, GlobActivityInspection> globActivityInspectionList;
	public static volatile SingularAttribute<InReport, BigDecimal> id;
	public static volatile SingularAttribute<InReport, String> unapprovedBy;
	public static volatile SingularAttribute<InReport, GlobContractorContract> contractorContractId;
	public static volatile SingularAttribute<InReport, BigInteger> reportNo;
	public static volatile SingularAttribute<InReport, Date> createDate;
	public static volatile SingularAttribute<InReport, Date> temp;
	public static volatile SingularAttribute<InReport, String> reportDateTmp;
	public static volatile SingularAttribute<InReport, String> reportTitle;
	public static volatile SingularAttribute<InReport, Character> active;
	public static volatile SingularAttribute<InReport, String> version;
	public static volatile SingularAttribute<InReport, String> createByIp;
	public static volatile SingularAttribute<InReport, Date> approvedDate;
	public static volatile SingularAttribute<InReport, String> createBy;
	public static volatile SingularAttribute<InReport, String> lastModTmp;
	public static volatile SingularAttribute<InReport, InReportType> reportTypeId;
	public static volatile SingularAttribute<InReport, String> lastMod;
	public static volatile SingularAttribute<InReport, Date> reportTime;
	public static volatile SingularAttribute<InReport, String> status;

	public static final String APPROVED_DATE_TMP = "approvedDateTmp";
	public static final String REASON = "reason";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String INFO_ID = "infoId";
	public static final String TEMP_TMP = "tempTmp";
	public static final String CREATE_DATE_TMP = "createDateTmp";
	public static final String APPROVED_BY = "approvedBy";
	public static final String UNAPPROVED = "unapproved";
	public static final String FUNCTION_ID = "functionId";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String REPORT_DATE = "reportDate";
	public static final String GLOB_ACTIVITY_INSPECTION_LIST = "globActivityInspectionList";
	public static final String ID = "id";
	public static final String UNAPPROVED_BY = "unapprovedBy";
	public static final String CONTRACTOR_CONTRACT_ID = "contractorContractId";
	public static final String REPORT_NO = "reportNo";
	public static final String CREATE_DATE = "createDate";
	public static final String TEMP = "temp";
	public static final String REPORT_DATE_TMP = "reportDateTmp";
	public static final String REPORT_TITLE = "reportTitle";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String APPROVED_DATE = "approvedDate";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_TMP = "lastModTmp";
	public static final String REPORT_TYPE_ID = "reportTypeId";
	public static final String LAST_MOD = "lastMod";
	public static final String REPORT_TIME = "reportTime";
	public static final String STATUS = "status";

}

