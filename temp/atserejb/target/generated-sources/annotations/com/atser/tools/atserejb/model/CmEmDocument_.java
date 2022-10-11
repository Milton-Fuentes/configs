package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmEmDocument.class)
public abstract class CmEmDocument_ {

	public static volatile SingularAttribute<CmEmDocument, String> lastModBy;
	public static volatile SingularAttribute<CmEmDocument, BigInteger> docId;
	public static volatile SingularAttribute<CmEmDocument, String> title;
	public static volatile SingularAttribute<CmEmDocument, String> version;
	public static volatile SingularAttribute<CmEmDocument, String> createByIp;
	public static volatile SingularAttribute<CmEmDocument, String> createBy;
	public static volatile SingularAttribute<CmEmDocument, String> lastModIp;
	public static volatile SingularAttribute<CmEmDocument, Date> lastRevisionDate;
	public static volatile SingularAttribute<CmEmDocument, String> location;
	public static volatile SingularAttribute<CmEmDocument, BigDecimal> id;
	public static volatile SingularAttribute<CmEmDocument, String> lastMod;
	public static volatile SingularAttribute<CmEmDocument, GlobProject> projectId;
	public static volatile SingularAttribute<CmEmDocument, String> status;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String DOC_ID = "docId";
	public static final String TITLE = "title";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String LAST_REVISION_DATE = "lastRevisionDate";
	public static final String LOCATION = "location";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";

}

