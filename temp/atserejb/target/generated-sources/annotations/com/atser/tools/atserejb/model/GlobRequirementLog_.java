package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobRequirementLog.class)
public abstract class GlobRequirementLog_ {

	public static volatile SingularAttribute<GlobRequirementLog, String> lastModBy;
	public static volatile SingularAttribute<GlobRequirementLog, String> rqpcn;
	public static volatile SingularAttribute<GlobRequirementLog, String> reqNo;
	public static volatile SingularAttribute<GlobRequirementLog, String> description;
	public static volatile SingularAttribute<GlobRequirementLog, String> designDocRef;
	public static volatile SingularAttribute<GlobRequirementLog, String> lastModIp;
	public static volatile SingularAttribute<GlobRequirementLog, BigDecimal> id;
	public static volatile SingularAttribute<GlobRequirementLog, String> wbsDeliverablesRef;
	public static volatile SingularAttribute<GlobRequirementLog, String> implementedIn;
	public static volatile SingularAttribute<GlobRequirementLog, String> createdByIp;
	public static volatile SingularAttribute<GlobRequirementLog, BigInteger> clientId;
	public static volatile SingularAttribute<GlobRequirementLog, Date> created;
	public static volatile SingularAttribute<GlobRequirementLog, Character> active;
	public static volatile SingularAttribute<GlobRequirementLog, BigInteger> classificationId;
	public static volatile SingularAttribute<GlobRequirementLog, Integer> version;
	public static volatile SingularAttribute<GlobRequirementLog, Date> verificationDate;
	public static volatile SingularAttribute<GlobRequirementLog, BigInteger> folderId;
	public static volatile SingularAttribute<GlobRequirementLog, String> techSpecRef;
	public static volatile SingularAttribute<GlobRequirementLog, Character> deleted;
	public static volatile SingularAttribute<GlobRequirementLog, BigInteger> statusId;
	public static volatile SingularAttribute<GlobRequirementLog, BigInteger> sno;
	public static volatile SingularAttribute<GlobRequirementLog, String> createdBy;
	public static volatile SingularAttribute<GlobRequirementLog, Character> closed;
	public static volatile SingularAttribute<GlobRequirementLog, String> refId;
	public static volatile SingularAttribute<GlobRequirementLog, BigInteger> projectId;
	public static volatile SingularAttribute<GlobRequirementLog, String> spattern;
	public static volatile SingularAttribute<GlobRequirementLog, Date> lastMod;
	public static volatile SingularAttribute<GlobRequirementLog, BigInteger> categoryId;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String RQPCN = "rqpcn";
	public static final String REQ_NO = "reqNo";
	public static final String DESCRIPTION = "description";
	public static final String DESIGN_DOC_REF = "designDocRef";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ID = "id";
	public static final String WBS_DELIVERABLES_REF = "wbsDeliverablesRef";
	public static final String IMPLEMENTED_IN = "implementedIn";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String CLASSIFICATION_ID = "classificationId";
	public static final String VERSION = "version";
	public static final String VERIFICATION_DATE = "verificationDate";
	public static final String FOLDER_ID = "folderId";
	public static final String TECH_SPEC_REF = "techSpecRef";
	public static final String DELETED = "deleted";
	public static final String STATUS_ID = "statusId";
	public static final String SNO = "sno";
	public static final String CREATED_BY = "createdBy";
	public static final String CLOSED = "closed";
	public static final String REF_ID = "refId";
	public static final String PROJECT_ID = "projectId";
	public static final String SPATTERN = "spattern";
	public static final String LAST_MOD = "lastMod";
	public static final String CATEGORY_ID = "categoryId";

}

