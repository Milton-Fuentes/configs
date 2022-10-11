package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmEmEmail.class)
public abstract class CmEmEmail_ {

	public static volatile SingularAttribute<CmEmEmail, String> emailNo;
	public static volatile SingularAttribute<CmEmEmail, Date> temp;
	public static volatile SingularAttribute<CmEmEmail, String> lastModBy;
	public static volatile SingularAttribute<CmEmEmail, String> emailBody;
	public static volatile SingularAttribute<CmEmEmail, GlobUsers> fromUserid;
	public static volatile SingularAttribute<CmEmEmail, Short> empriority;
	public static volatile SingularAttribute<CmEmEmail, String> emailSubject;
	public static volatile SingularAttribute<CmEmEmail, String> requiredAction;
	public static volatile SingularAttribute<CmEmEmail, String> version;
	public static volatile SingularAttribute<CmEmEmail, BigInteger> respEmailId;
	public static volatile SingularAttribute<CmEmEmail, Date> actionDeadline;
	public static volatile SingularAttribute<CmEmEmail, String> createByIp;
	public static volatile SingularAttribute<CmEmEmail, Date> emailDate;
	public static volatile SingularAttribute<CmEmEmail, String> createBy;
	public static volatile SingularAttribute<CmEmEmail, String> lastModIp;
	public static volatile SingularAttribute<CmEmEmail, BigDecimal> id;
	public static volatile SingularAttribute<CmEmEmail, String> contentType;
	public static volatile SingularAttribute<CmEmEmail, String> lastMod;
	public static volatile SingularAttribute<CmEmEmail, GlobProject> projectId;
	public static volatile SingularAttribute<CmEmEmail, String> status;
	public static volatile SingularAttribute<CmEmEmail, Date> createDate;

	public static final String EMAIL_NO = "emailNo";
	public static final String TEMP = "temp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String EMAIL_BODY = "emailBody";
	public static final String FROM_USERID = "fromUserid";
	public static final String EMPRIORITY = "empriority";
	public static final String EMAIL_SUBJECT = "emailSubject";
	public static final String REQUIRED_ACTION = "requiredAction";
	public static final String VERSION = "version";
	public static final String RESP_EMAIL_ID = "respEmailId";
	public static final String ACTION_DEADLINE = "actionDeadline";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String EMAIL_DATE = "emailDate";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ID = "id";
	public static final String CONTENT_TYPE = "contentType";
	public static final String LAST_MOD = "lastMod";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";
	public static final String CREATE_DATE = "createDate";

}

