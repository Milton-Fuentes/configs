package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(WsReport.class)
public abstract class WsReport_ {

	public static volatile SingularAttribute<WsReport, String> createdByIp;
	public static volatile SingularAttribute<WsReport, BigInteger> clientId;
	public static volatile SingularAttribute<WsReport, String> lastModBy;
	public static volatile SingularAttribute<WsReport, String> reportName;
	public static volatile SingularAttribute<WsReport, String> reportFunctionality;
	public static volatile SingularAttribute<WsReport, String> reportPath;
	public static volatile SingularAttribute<WsReport, Date> created;
	public static volatile SingularAttribute<WsReport, String> active;
	public static volatile SingularAttribute<WsReport, String> lastModByIp;
	public static volatile SingularAttribute<WsReport, Integer> reportOrder;
	public static volatile SingularAttribute<WsReport, String> deleted;
	public static volatile SingularAttribute<WsReport, String> createdBy;
	public static volatile SingularAttribute<WsReport, String> reportCode;
	public static volatile ListAttribute<WsReport, WsSubreport> subReportList;
	public static volatile SingularAttribute<WsReport, BigDecimal> id;
	public static volatile SingularAttribute<WsReport, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String REPORT_NAME = "reportName";
	public static final String REPORT_FUNCTIONALITY = "reportFunctionality";
	public static final String REPORT_PATH = "reportPath";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String LAST_MOD_BY_IP = "lastModByIp";
	public static final String REPORT_ORDER = "reportOrder";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String REPORT_CODE = "reportCode";
	public static final String SUB_REPORT_LIST = "subReportList";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

