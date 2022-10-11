package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(WsSubreport.class)
public abstract class WsSubreport_ {

	public static volatile SingularAttribute<WsSubreport, String> createdByIp;
	public static volatile SingularAttribute<WsSubreport, BigInteger> clientId;
	public static volatile SingularAttribute<WsSubreport, String> lastModBy;
	public static volatile SingularAttribute<WsSubreport, Date> created;
	public static volatile ListAttribute<WsSubreport, WsReport> reportList;
	public static volatile SingularAttribute<WsSubreport, String> active;
	public static volatile SingularAttribute<WsSubreport, String> lastModByIp;
	public static volatile SingularAttribute<WsSubreport, String> subreportName;
	public static volatile SingularAttribute<WsSubreport, String> subreportPath;
	public static volatile SingularAttribute<WsSubreport, String> deleted;
	public static volatile SingularAttribute<WsSubreport, String> createdBy;
	public static volatile SingularAttribute<WsSubreport, BigDecimal> id;
	public static volatile SingularAttribute<WsSubreport, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String REPORT_LIST = "reportList";
	public static final String ACTIVE = "active";
	public static final String LAST_MOD_BY_IP = "lastModByIp";
	public static final String SUBREPORT_NAME = "subreportName";
	public static final String SUBREPORT_PATH = "subreportPath";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

