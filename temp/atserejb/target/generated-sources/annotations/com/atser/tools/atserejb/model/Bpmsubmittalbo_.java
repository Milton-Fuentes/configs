package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bpmsubmittalbo.class)
public abstract class Bpmsubmittalbo_ {

	public static volatile SingularAttribute<Bpmsubmittalbo, Short> isneededrevision;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> notes;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> referenceDocs;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> finaldisposition;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> rejectreason;
	public static volatile SingularAttribute<Bpmsubmittalbo, Bpmsubmittalmetadata> dcDataPid;
	public static volatile SingularAttribute<Bpmsubmittalbo, Short> canCreateRevision;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> onWorkName;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> contractorNumber;
	public static volatile SingularAttribute<Bpmsubmittalbo, BigInteger> caseId;
	public static volatile SingularAttribute<Bpmsubmittalbo, Short> isreneededreview;
	public static volatile SingularAttribute<Bpmsubmittalbo, BigDecimal> persistenceid;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> subinternalnumber;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> onWorkId;
	public static volatile SingularAttribute<Bpmsubmittalbo, Short> iseorneedreview;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> finalRemark;
	public static volatile ListAttribute<Bpmsubmittalbo, Bpmsubmittalremark> bpmsubmittalremarkList;
	public static volatile SingularAttribute<Bpmsubmittalbo, BigInteger> persistenceversion;
	public static volatile SingularAttribute<Bpmsubmittalbo, Short> isapproved;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> clientId;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> issue;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> created;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> stkhIds;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> companyFrom;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> subnumber;
	public static volatile SingularAttribute<Bpmsubmittalbo, Short> isemneedreview;
	public static volatile SingularAttribute<Bpmsubmittalbo, BigInteger> folderId;
	public static volatile SingularAttribute<Bpmsubmittalbo, BigInteger> parentId;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> requestedDueDate;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> specNumber;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> reIds;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> emIds;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> personFrom;
	public static volatile SingularAttribute<Bpmsubmittalbo, BigInteger> requestorId;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> internalstatus;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> name;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> contractId;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> stkhGrpIds;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> decisionId;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> proposedSolution;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> doneDate;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> projectId;
	public static volatile SingularAttribute<Bpmsubmittalbo, String> status;

	public static final String ISNEEDEDREVISION = "isneededrevision";
	public static final String NOTES = "notes";
	public static final String REFERENCE_DOCS = "referenceDocs";
	public static final String FINALDISPOSITION = "finaldisposition";
	public static final String REJECTREASON = "rejectreason";
	public static final String DC_DATA_PID = "dcDataPid";
	public static final String CAN_CREATE_REVISION = "canCreateRevision";
	public static final String ON_WORK_NAME = "onWorkName";
	public static final String CONTRACTOR_NUMBER = "contractorNumber";
	public static final String CASE_ID = "caseId";
	public static final String ISRENEEDEDREVIEW = "isreneededreview";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String SUBINTERNALNUMBER = "subinternalnumber";
	public static final String ON_WORK_ID = "onWorkId";
	public static final String ISEORNEEDREVIEW = "iseorneedreview";
	public static final String FINAL_REMARK = "finalRemark";
	public static final String BPMSUBMITTALREMARK_LIST = "bpmsubmittalremarkList";
	public static final String PERSISTENCEVERSION = "persistenceversion";
	public static final String ISAPPROVED = "isapproved";
	public static final String CLIENT_ID = "clientId";
	public static final String ISSUE = "issue";
	public static final String CREATED = "created";
	public static final String STKH_IDS = "stkhIds";
	public static final String COMPANY_FROM = "companyFrom";
	public static final String SUBNUMBER = "subnumber";
	public static final String ISEMNEEDREVIEW = "isemneedreview";
	public static final String FOLDER_ID = "folderId";
	public static final String PARENT_ID = "parentId";
	public static final String REQUESTED_DUE_DATE = "requestedDueDate";
	public static final String SPEC_NUMBER = "specNumber";
	public static final String RE_IDS = "reIds";
	public static final String EM_IDS = "emIds";
	public static final String PERSON_FROM = "personFrom";
	public static final String REQUESTOR_ID = "requestorId";
	public static final String INTERNALSTATUS = "internalstatus";
	public static final String NAME = "name";
	public static final String CONTRACT_ID = "contractId";
	public static final String STKH_GRP_IDS = "stkhGrpIds";
	public static final String DECISION_ID = "decisionId";
	public static final String PROPOSED_SOLUTION = "proposedSolution";
	public static final String DONE_DATE = "doneDate";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";

}

