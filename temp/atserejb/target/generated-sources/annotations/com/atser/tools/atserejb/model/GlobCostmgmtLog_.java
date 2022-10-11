package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobCostmgmtLog.class)
public abstract class GlobCostmgmtLog_ {

	public static volatile SingularAttribute<GlobCostmgmtLog, String> lastModBy;
	public static volatile SingularAttribute<GlobCostmgmtLog, String> reqNo;
	public static volatile SingularAttribute<GlobCostmgmtLog, String> remark;
	public static volatile SingularAttribute<GlobCostmgmtLog, BigDecimal> forecastFinalCost;
	public static volatile SingularAttribute<GlobCostmgmtLog, BigDecimal> earned;
	public static volatile SingularAttribute<GlobCostmgmtLog, String> lastModIp;
	public static volatile SingularAttribute<GlobCostmgmtLog, BigDecimal> planedValue;
	public static volatile SingularAttribute<GlobCostmgmtLog, String> cmpcn;
	public static volatile SingularAttribute<GlobCostmgmtLog, BigDecimal> committedCost;
	public static volatile SingularAttribute<GlobCostmgmtLog, BigDecimal> id;
	public static volatile SingularAttribute<GlobCostmgmtLog, BigDecimal> actualCost;
	public static volatile SingularAttribute<GlobCostmgmtLog, String> createdByIp;
	public static volatile SingularAttribute<GlobCostmgmtLog, BigInteger> clientId;
	public static volatile SingularAttribute<GlobCostmgmtLog, BigDecimal> invoiced;
	public static volatile SingularAttribute<GlobCostmgmtLog, Date> created;
	public static volatile SingularAttribute<GlobCostmgmtLog, String> workPackage;
	public static volatile SingularAttribute<GlobCostmgmtLog, Character> active;
	public static volatile SingularAttribute<GlobCostmgmtLog, Integer> version;
	public static volatile SingularAttribute<GlobCostmgmtLog, BigDecimal> remaining;
	public static volatile SingularAttribute<GlobCostmgmtLog, BigInteger> folderId;
	public static volatile SingularAttribute<GlobCostmgmtLog, Character> deleted;
	public static volatile SingularAttribute<GlobCostmgmtLog, BigInteger> sno;
	public static volatile SingularAttribute<GlobCostmgmtLog, String> createdBy;
	public static volatile SingularAttribute<GlobCostmgmtLog, BigDecimal> paid;
	public static volatile SingularAttribute<GlobCostmgmtLog, BigInteger> projectId;
	public static volatile SingularAttribute<GlobCostmgmtLog, String> spattern;
	public static volatile SingularAttribute<GlobCostmgmtLog, Date> lastMod;
	public static volatile SingularAttribute<GlobCostmgmtLog, BigInteger> programId;
	public static volatile SingularAttribute<GlobCostmgmtLog, BigDecimal> approvedControlBudget;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String REQ_NO = "reqNo";
	public static final String REMARK = "remark";
	public static final String FORECAST_FINAL_COST = "forecastFinalCost";
	public static final String EARNED = "earned";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String PLANED_VALUE = "planedValue";
	public static final String CMPCN = "cmpcn";
	public static final String COMMITTED_COST = "committedCost";
	public static final String ID = "id";
	public static final String ACTUAL_COST = "actualCost";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String INVOICED = "invoiced";
	public static final String CREATED = "created";
	public static final String WORK_PACKAGE = "workPackage";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String REMAINING = "remaining";
	public static final String FOLDER_ID = "folderId";
	public static final String DELETED = "deleted";
	public static final String SNO = "sno";
	public static final String CREATED_BY = "createdBy";
	public static final String PAID = "paid";
	public static final String PROJECT_ID = "projectId";
	public static final String SPATTERN = "spattern";
	public static final String LAST_MOD = "lastMod";
	public static final String PROGRAM_ID = "programId";
	public static final String APPROVED_CONTROL_BUDGET = "approvedControlBudget";

}

