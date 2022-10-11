package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobQacomplianceLog.class)
public abstract class GlobQacomplianceLog_ {

	public static volatile SingularAttribute<GlobQacomplianceLog, String> lastModBy;
	public static volatile SingularAttribute<GlobQacomplianceLog, BigInteger> qcTypeId;
	public static volatile SingularAttribute<GlobQacomplianceLog, String> reqNo;
	public static volatile SingularAttribute<GlobQacomplianceLog, String> description;
	public static volatile SingularAttribute<GlobQacomplianceLog, String> range;
	public static volatile SingularAttribute<GlobQacomplianceLog, String> threshold;
	public static volatile SingularAttribute<GlobQacomplianceLog, BigDecimal> scorecard;
	public static volatile SingularAttribute<GlobQacomplianceLog, String> objective;
	public static volatile SingularAttribute<GlobQacomplianceLog, Character> meetRequirement;
	public static volatile SingularAttribute<GlobQacomplianceLog, String> lastModIp;
	public static volatile SingularAttribute<GlobQacomplianceLog, BigDecimal> warning;
	public static volatile SingularAttribute<GlobQacomplianceLog, BigDecimal> id;
	public static volatile SingularAttribute<GlobQacomplianceLog, String> createdByIp;
	public static volatile SingularAttribute<GlobQacomplianceLog, BigInteger> clientId;
	public static volatile SingularAttribute<GlobQacomplianceLog, Date> created;
	public static volatile SingularAttribute<GlobQacomplianceLog, Character> active;
	public static volatile SingularAttribute<GlobQacomplianceLog, Integer> version;
	public static volatile SingularAttribute<GlobQacomplianceLog, String> qcpcn;
	public static volatile SingularAttribute<GlobQacomplianceLog, BigInteger> folderId;
	public static volatile SingularAttribute<GlobQacomplianceLog, Character> deleted;
	public static volatile SingularAttribute<GlobQacomplianceLog, BigInteger> sno;
	public static volatile SingularAttribute<GlobQacomplianceLog, String> createdBy;
	public static volatile SingularAttribute<GlobQacomplianceLog, String> response;
	public static volatile SingularAttribute<GlobQacomplianceLog, BigInteger> qcPeriodId;
	public static volatile SingularAttribute<GlobQacomplianceLog, String> refId;
	public static volatile SingularAttribute<GlobQacomplianceLog, BigInteger> projectId;
	public static volatile SingularAttribute<GlobQacomplianceLog, String> spattern;
	public static volatile SingularAttribute<GlobQacomplianceLog, Date> lastMod;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String QC_TYPE_ID = "qcTypeId";
	public static final String REQ_NO = "reqNo";
	public static final String DESCRIPTION = "description";
	public static final String RANGE = "range";
	public static final String THRESHOLD = "threshold";
	public static final String SCORECARD = "scorecard";
	public static final String OBJECTIVE = "objective";
	public static final String MEET_REQUIREMENT = "meetRequirement";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String WARNING = "warning";
	public static final String ID = "id";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String QCPCN = "qcpcn";
	public static final String FOLDER_ID = "folderId";
	public static final String DELETED = "deleted";
	public static final String SNO = "sno";
	public static final String CREATED_BY = "createdBy";
	public static final String RESPONSE = "response";
	public static final String QC_PERIOD_ID = "qcPeriodId";
	public static final String REF_ID = "refId";
	public static final String PROJECT_ID = "projectId";
	public static final String SPATTERN = "spattern";
	public static final String LAST_MOD = "lastMod";

}

