package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobContractmgmtLog.class)
public abstract class GlobContractmgmtLog_ {

	public static volatile SingularAttribute<GlobContractmgmtLog, String> createdByIp;
	public static volatile SingularAttribute<GlobContractmgmtLog, BigInteger> clientId;
	public static volatile SingularAttribute<GlobContractmgmtLog, String> lastModBy;
	public static volatile SingularAttribute<GlobContractmgmtLog, Date> created;
	public static volatile SingularAttribute<GlobContractmgmtLog, String> reqNo;
	public static volatile SingularAttribute<GlobContractmgmtLog, String> description;
	public static volatile SingularAttribute<GlobContractmgmtLog, Character> active;
	public static volatile SingularAttribute<GlobContractmgmtLog, Integer> version;
	public static volatile SingularAttribute<GlobContractmgmtLog, BigInteger> folderId;
	public static volatile SingularAttribute<GlobContractmgmtLog, String> lastModIp;
	public static volatile SingularAttribute<GlobContractmgmtLog, Character> deleted;
	public static volatile SingularAttribute<GlobContractmgmtLog, BigInteger> sno;
	public static volatile SingularAttribute<GlobContractmgmtLog, String> createdBy;
	public static volatile SingularAttribute<GlobContractmgmtLog, String> cmpcn;
	public static volatile SingularAttribute<GlobContractmgmtLog, String> versionNo;
	public static volatile SingularAttribute<GlobContractmgmtLog, BigDecimal> id;
	public static volatile SingularAttribute<GlobContractmgmtLog, String> refId;
	public static volatile SingularAttribute<GlobContractmgmtLog, BigInteger> projectId;
	public static volatile SingularAttribute<GlobContractmgmtLog, String> spattern;
	public static volatile SingularAttribute<GlobContractmgmtLog, Date> lastMod;
	public static volatile SingularAttribute<GlobContractmgmtLog, BigInteger> categoryId;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String REQ_NO = "reqNo";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String SNO = "sno";
	public static final String CREATED_BY = "createdBy";
	public static final String CMPCN = "cmpcn";
	public static final String VERSION_NO = "versionNo";
	public static final String ID = "id";
	public static final String REF_ID = "refId";
	public static final String PROJECT_ID = "projectId";
	public static final String SPATTERN = "spattern";
	public static final String LAST_MOD = "lastMod";
	public static final String CATEGORY_ID = "categoryId";

}

