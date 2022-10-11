package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(WsDocTemplate.class)
public abstract class WsDocTemplate_ {

	public static volatile SingularAttribute<WsDocTemplate, String> createdByIp;
	public static volatile SingularAttribute<WsDocTemplate, BigInteger> clientId;
	public static volatile SingularAttribute<WsDocTemplate, String> lastModBy;
	public static volatile SingularAttribute<WsDocTemplate, String> docType;
	public static volatile SingularAttribute<WsDocTemplate, Date> created;
	public static volatile SingularAttribute<WsDocTemplate, String> docCode;
	public static volatile SingularAttribute<WsDocTemplate, String> active;
	public static volatile SingularAttribute<WsDocTemplate, String> lastModByIp;
	public static volatile SingularAttribute<WsDocTemplate, String> docPath;
	public static volatile SingularAttribute<WsDocTemplate, String> docFunctionality;
	public static volatile SingularAttribute<WsDocTemplate, String> deleted;
	public static volatile SingularAttribute<WsDocTemplate, String> createdBy;
	public static volatile SingularAttribute<WsDocTemplate, BigDecimal> id;
	public static volatile SingularAttribute<WsDocTemplate, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String DOC_TYPE = "docType";
	public static final String CREATED = "created";
	public static final String DOC_CODE = "docCode";
	public static final String ACTIVE = "active";
	public static final String LAST_MOD_BY_IP = "lastModByIp";
	public static final String DOC_PATH = "docPath";
	public static final String DOC_FUNCTIONALITY = "docFunctionality";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

