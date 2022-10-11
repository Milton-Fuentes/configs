package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobDataGatewayLog.class)
public abstract class GlobDataGatewayLog_ {

	public static volatile SingularAttribute<GlobDataGatewayLog, String> functionalityName;
	public static volatile SingularAttribute<GlobDataGatewayLog, String> createdByIp;
	public static volatile SingularAttribute<GlobDataGatewayLog, BigInteger> clientId;
	public static volatile SingularAttribute<GlobDataGatewayLog, String> lastModBy;
	public static volatile SingularAttribute<GlobDataGatewayLog, Date> created;
	public static volatile SingularAttribute<GlobDataGatewayLog, String> active;
	public static volatile SingularAttribute<GlobDataGatewayLog, String> documentName;
	public static volatile SingularAttribute<GlobDataGatewayLog, Long> version;
	public static volatile SingularAttribute<GlobDataGatewayLog, String> lastModIp;
	public static volatile SingularAttribute<GlobDataGatewayLog, String> deleted;
	public static volatile SingularAttribute<GlobDataGatewayLog, String> createdBy;
	public static volatile SingularAttribute<GlobDataGatewayLog, BigInteger> recordTotal;
	public static volatile SingularAttribute<GlobDataGatewayLog, BigDecimal> id;
	public static volatile SingularAttribute<GlobDataGatewayLog, BigInteger> projectId;
	public static volatile SingularAttribute<GlobDataGatewayLog, Date> lastMod;

	public static final String FUNCTIONALITY_NAME = "functionalityName";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String DOCUMENT_NAME = "documentName";
	public static final String VERSION = "version";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String RECORD_TOTAL = "recordTotal";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String LAST_MOD = "lastMod";

}

