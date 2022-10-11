package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobMgmtPlanDoc.class)
public abstract class GlobMgmtPlanDoc_ {

	public static volatile SingularAttribute<GlobMgmtPlanDoc, String> createdByIp;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, String> lastModBy;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, Date> created;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, String> description;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, Character> active;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, Character> main;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, Integer> version;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, String> lastModIp;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, Character> deleted;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, String> authorizedBy;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, BigInteger> sno;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, String> createdBy;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, String> versionNo;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, BigInteger> planId;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, BigDecimal> id;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, Date> lastMod;
	public static volatile SingularAttribute<GlobMgmtPlanDoc, BigInteger> fileId;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String MAIN = "main";
	public static final String VERSION = "version";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String AUTHORIZED_BY = "authorizedBy";
	public static final String SNO = "sno";
	public static final String CREATED_BY = "createdBy";
	public static final String VERSION_NO = "versionNo";
	public static final String PLAN_ID = "planId";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String FILE_ID = "fileId";

}

