package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobMgmtPlan.class)
public abstract class GlobMgmtPlan_ {

	public static volatile SingularAttribute<GlobMgmtPlan, String> createdByIp;
	public static volatile SingularAttribute<GlobMgmtPlan, BigInteger> clientId;
	public static volatile SingularAttribute<GlobMgmtPlan, String> lastModBy;
	public static volatile SingularAttribute<GlobMgmtPlan, Date> created;
	public static volatile SingularAttribute<GlobMgmtPlan, String> description;
	public static volatile SingularAttribute<GlobMgmtPlan, Character> active;
	public static volatile SingularAttribute<GlobMgmtPlan, Integer> version;
	public static volatile SingularAttribute<GlobMgmtPlan, BigInteger> folderId;
	public static volatile SingularAttribute<GlobMgmtPlan, String> lastModIp;
	public static volatile SingularAttribute<GlobMgmtPlan, Character> deleted;
	public static volatile SingularAttribute<GlobMgmtPlan, BigInteger> planCatgId;
	public static volatile SingularAttribute<GlobMgmtPlan, String> createdBy;
	public static volatile SingularAttribute<GlobMgmtPlan, BigDecimal> id;
	public static volatile SingularAttribute<GlobMgmtPlan, BigInteger> projectId;
	public static volatile SingularAttribute<GlobMgmtPlan, Date> lastMod;
	public static volatile SingularAttribute<GlobMgmtPlan, BigInteger> programId;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String PLAN_CATG_ID = "planCatgId";
	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String LAST_MOD = "lastMod";
	public static final String PROGRAM_ID = "programId";

}

