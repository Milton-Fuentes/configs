package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bpmcorrespondencebo.class)
public abstract class Bpmcorrespondencebo_ {

	public static volatile SingularAttribute<Bpmcorrespondencebo, Short> isneededrevision;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> notes;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> finaldisposition;
	public static volatile SingularAttribute<Bpmcorrespondencebo, Bpmcorrespondencemetadata> dcDataPid;
	public static volatile SingularAttribute<Bpmcorrespondencebo, Short> canCreateRevision;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> informationStatus;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> contractorNumber;
	public static volatile SingularAttribute<Bpmcorrespondencebo, BigInteger> caseId;
	public static volatile SingularAttribute<Bpmcorrespondencebo, Short> isreneededreview;
	public static volatile SingularAttribute<Bpmcorrespondencebo, BigDecimal> persistenceid;
	public static volatile SingularAttribute<Bpmcorrespondencebo, Short> iseorneedreview;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> clientId;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> created;
	public static volatile ListAttribute<Bpmcorrespondencebo, Bpmcorrespondenceremark> bpmcorrespondenceremarkList;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> stkhIds;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> companyFrom;
	public static volatile SingularAttribute<Bpmcorrespondencebo, Short> isemneedreview;
	public static volatile SingularAttribute<Bpmcorrespondencebo, BigInteger> folderId;
	public static volatile SingularAttribute<Bpmcorrespondencebo, BigInteger> parentId;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> requestedDueDate;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> reIds;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> personFrom;
	public static volatile SingularAttribute<Bpmcorrespondencebo, BigInteger> requestorId;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> cornumber;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> name;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> contractId;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> stkhGrpIds;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> pdIds;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> category;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> doneDate;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> projectId;
	public static volatile SingularAttribute<Bpmcorrespondencebo, String> status;

	public static final String ISNEEDEDREVISION = "isneededrevision";
	public static final String NOTES = "notes";
	public static final String FINALDISPOSITION = "finaldisposition";
	public static final String DC_DATA_PID = "dcDataPid";
	public static final String CAN_CREATE_REVISION = "canCreateRevision";
	public static final String INFORMATION_STATUS = "informationStatus";
	public static final String CONTRACTOR_NUMBER = "contractorNumber";
	public static final String CASE_ID = "caseId";
	public static final String ISRENEEDEDREVIEW = "isreneededreview";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String ISEORNEEDREVIEW = "iseorneedreview";
	public static final String CLIENT_ID = "clientId";
	public static final String CREATED = "created";
	public static final String BPMCORRESPONDENCEREMARK_LIST = "bpmcorrespondenceremarkList";
	public static final String STKH_IDS = "stkhIds";
	public static final String COMPANY_FROM = "companyFrom";
	public static final String ISEMNEEDREVIEW = "isemneedreview";
	public static final String FOLDER_ID = "folderId";
	public static final String PARENT_ID = "parentId";
	public static final String REQUESTED_DUE_DATE = "requestedDueDate";
	public static final String RE_IDS = "reIds";
	public static final String PERSON_FROM = "personFrom";
	public static final String REQUESTOR_ID = "requestorId";
	public static final String CORNUMBER = "cornumber";
	public static final String NAME = "name";
	public static final String CONTRACT_ID = "contractId";
	public static final String STKH_GRP_IDS = "stkhGrpIds";
	public static final String PD_IDS = "pdIds";
	public static final String CATEGORY = "category";
	public static final String DONE_DATE = "doneDate";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";

}

