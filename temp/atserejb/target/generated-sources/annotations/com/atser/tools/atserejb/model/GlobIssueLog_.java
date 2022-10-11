package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobIssueLog.class)
public abstract class GlobIssueLog_ {

	public static volatile SingularAttribute<GlobIssueLog, String> lastModBy;
	public static volatile SingularAttribute<GlobIssueLog, BigInteger> projectPhase;
	public static volatile SingularAttribute<GlobIssueLog, String> description;
	public static volatile SingularAttribute<GlobIssueLog, String> issueNo;
	public static volatile SingularAttribute<GlobIssueLog, String> assignedTo;
	public static volatile SingularAttribute<GlobIssueLog, Date> dateResolved;
	public static volatile SingularAttribute<GlobIssueLog, String> lastModIp;
	public static volatile SingularAttribute<GlobIssueLog, BigDecimal> id;
	public static volatile SingularAttribute<GlobIssueLog, BigInteger> identifiedBy;
	public static volatile SingularAttribute<GlobIssueLog, String> ilpcn;
	public static volatile SingularAttribute<GlobIssueLog, String> createdByIp;
	public static volatile SingularAttribute<GlobIssueLog, BigInteger> clientId;
	public static volatile SingularAttribute<GlobIssueLog, Date> created;
	public static volatile SingularAttribute<GlobIssueLog, Character> active;
	public static volatile SingularAttribute<GlobIssueLog, Integer> version;
	public static volatile SingularAttribute<GlobIssueLog, BigInteger> folderId;
	public static volatile SingularAttribute<GlobIssueLog, BigInteger> issueType;
	public static volatile SingularAttribute<GlobIssueLog, Character> deleted;
	public static volatile SingularAttribute<GlobIssueLog, BigInteger> statusId;
	public static volatile SingularAttribute<GlobIssueLog, BigInteger> sno;
	public static volatile SingularAttribute<GlobIssueLog, String> createdBy;
	public static volatile SingularAttribute<GlobIssueLog, String> refId;
	public static volatile SingularAttribute<GlobIssueLog, Date> dateFound;
	public static volatile SingularAttribute<GlobIssueLog, BigInteger> projectId;
	public static volatile SingularAttribute<GlobIssueLog, String> spattern;
	public static volatile SingularAttribute<GlobIssueLog, Date> lastMod;
	public static volatile SingularAttribute<GlobIssueLog, Date> dateSubmitted;
	public static volatile SingularAttribute<GlobIssueLog, String> remarks;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String PROJECT_PHASE = "projectPhase";
	public static final String DESCRIPTION = "description";
	public static final String ISSUE_NO = "issueNo";
	public static final String ASSIGNED_TO = "assignedTo";
	public static final String DATE_RESOLVED = "dateResolved";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ID = "id";
	public static final String IDENTIFIED_BY = "identifiedBy";
	public static final String ILPCN = "ilpcn";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String ISSUE_TYPE = "issueType";
	public static final String DELETED = "deleted";
	public static final String STATUS_ID = "statusId";
	public static final String SNO = "sno";
	public static final String CREATED_BY = "createdBy";
	public static final String REF_ID = "refId";
	public static final String DATE_FOUND = "dateFound";
	public static final String PROJECT_ID = "projectId";
	public static final String SPATTERN = "spattern";
	public static final String LAST_MOD = "lastMod";
	public static final String DATE_SUBMITTED = "dateSubmitted";
	public static final String REMARKS = "remarks";

}

