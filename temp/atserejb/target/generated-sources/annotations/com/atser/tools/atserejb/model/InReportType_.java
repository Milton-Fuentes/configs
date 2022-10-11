package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(InReportType.class)
public abstract class InReportType_ {

	public static volatile SingularAttribute<InReportType, Date> temp;
	public static volatile SingularAttribute<InReportType, String> reportJsp;
	public static volatile SingularAttribute<InReportType, String> lastModBy;
	public static volatile SingularAttribute<InReportType, String> tempTmp;
	public static volatile SingularAttribute<InReportType, String> createDateTmp;
	public static volatile SingularAttribute<InReportType, String> reportName;
	public static volatile SingularAttribute<InReportType, Character> active;
	public static volatile SingularAttribute<InReportType, String> createByIp;
	public static volatile SingularAttribute<InReportType, String> reportTable;
	public static volatile SingularAttribute<InReportType, String> createBy;
	public static volatile SingularAttribute<InReportType, String> lastModIp;
	public static volatile SingularAttribute<InReportType, String> reportPrintout;
	public static volatile SingularAttribute<InReportType, String> lastModTmp;
	public static volatile ListAttribute<InReportType, InReport> inReportList;
	public static volatile SingularAttribute<InReportType, BigDecimal> id;
	public static volatile SingularAttribute<InReportType, String> lastMod;
	public static volatile SingularAttribute<InReportType, Date> createDate;

	public static final String TEMP = "temp";
	public static final String REPORT_JSP = "reportJsp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String TEMP_TMP = "tempTmp";
	public static final String CREATE_DATE_TMP = "createDateTmp";
	public static final String REPORT_NAME = "reportName";
	public static final String ACTIVE = "active";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String REPORT_TABLE = "reportTable";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String REPORT_PRINTOUT = "reportPrintout";
	public static final String LAST_MOD_TMP = "lastModTmp";
	public static final String IN_REPORT_LIST = "inReportList";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";

}

