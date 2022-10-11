package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bpmrfibo.class)
public abstract class Bpmrfibo_ {

	public static volatile SingularAttribute<Bpmrfibo, String> referenceDocs;
	public static volatile SingularAttribute<Bpmrfibo, String> rfinumber;
	public static volatile SingularAttribute<Bpmrfibo, String> finaldisposition;
	public static volatile SingularAttribute<Bpmrfibo, Short> isResponseAccepted;
	public static volatile SingularAttribute<Bpmrfibo, String> prioritycode;
	public static volatile SingularAttribute<Bpmrfibo, String> rejectreason;
	public static volatile SingularAttribute<Bpmrfibo, Character> checkWorkImpact;
	public static volatile SingularAttribute<Bpmrfibo, String> rfiname;
	public static volatile SingularAttribute<Bpmrfibo, Character> checkCostImpact;
	public static volatile SingularAttribute<Bpmrfibo, Bpmrfimetadata> dcDataPid;
	public static volatile SingularAttribute<Bpmrfibo, Short> canCreateRevision;
	public static volatile SingularAttribute<Bpmrfibo, String> contractorNumber;
	public static volatile SingularAttribute<Bpmrfibo, BigInteger> requestorid;
	public static volatile SingularAttribute<Bpmrfibo, String> responseDueDate;
	public static volatile SingularAttribute<Bpmrfibo, Short> isInitialReviewAccepted;
	public static volatile SingularAttribute<Bpmrfibo, BigInteger> caseId;
	public static volatile SingularAttribute<Bpmrfibo, BigDecimal> persistenceid;
	public static volatile SingularAttribute<Bpmrfibo, Short> isInitialInformationAccepted;
	public static volatile SingularAttribute<Bpmrfibo, String> decisionid;
	public static volatile SingularAttribute<Bpmrfibo, String> reply;
	public static volatile SingularAttribute<Bpmrfibo, String> rfiinternalnumber;
	public static volatile SingularAttribute<Bpmrfibo, BigInteger> persistenceversion;
	public static volatile SingularAttribute<Bpmrfibo, String> clientId;
	public static volatile SingularAttribute<Bpmrfibo, String> onworkname;
	public static volatile SingularAttribute<Bpmrfibo, String> question;
	public static volatile SingularAttribute<Bpmrfibo, String> issue;
	public static volatile SingularAttribute<Bpmrfibo, String> created;
	public static volatile ListAttribute<Bpmrfibo, Bpmrfiremark> bpmrfiremarkList;
	public static volatile SingularAttribute<Bpmrfibo, String> stkhIds;
	public static volatile SingularAttribute<Bpmrfibo, String> companyFrom;
	public static volatile SingularAttribute<Bpmrfibo, String> drwnumber;
	public static volatile SingularAttribute<Bpmrfibo, BigInteger> folderId;
	public static volatile SingularAttribute<Bpmrfibo, BigInteger> parentId;
	public static volatile SingularAttribute<Bpmrfibo, String> reIds;
	public static volatile SingularAttribute<Bpmrfibo, Character> checkScheduleImpact;
	public static volatile SingularAttribute<Bpmrfibo, String> emIds;
	public static volatile SingularAttribute<Bpmrfibo, Short> isNeededReviewEor;
	public static volatile SingularAttribute<Bpmrfibo, String> personFrom;
	public static volatile SingularAttribute<Bpmrfibo, String> internalstatus;
	public static volatile SingularAttribute<Bpmrfibo, String> contractId;
	public static volatile SingularAttribute<Bpmrfibo, String> onworkid;
	public static volatile SingularAttribute<Bpmrfibo, String> stkhGrpIds;
	public static volatile SingularAttribute<Bpmrfibo, String> eorIds;
	public static volatile SingularAttribute<Bpmrfibo, String> proposedSolution;
	public static volatile SingularAttribute<Bpmrfibo, String> doneDate;
	public static volatile SingularAttribute<Bpmrfibo, String> projectId;
	public static volatile SingularAttribute<Bpmrfibo, String> status;

	public static final String REFERENCE_DOCS = "referenceDocs";
	public static final String RFINUMBER = "rfinumber";
	public static final String FINALDISPOSITION = "finaldisposition";
	public static final String IS_RESPONSE_ACCEPTED = "isResponseAccepted";
	public static final String PRIORITYCODE = "prioritycode";
	public static final String REJECTREASON = "rejectreason";
	public static final String CHECK_WORK_IMPACT = "checkWorkImpact";
	public static final String RFINAME = "rfiname";
	public static final String CHECK_COST_IMPACT = "checkCostImpact";
	public static final String DC_DATA_PID = "dcDataPid";
	public static final String CAN_CREATE_REVISION = "canCreateRevision";
	public static final String CONTRACTOR_NUMBER = "contractorNumber";
	public static final String REQUESTORID = "requestorid";
	public static final String RESPONSE_DUE_DATE = "responseDueDate";
	public static final String IS_INITIAL_REVIEW_ACCEPTED = "isInitialReviewAccepted";
	public static final String CASE_ID = "caseId";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String IS_INITIAL_INFORMATION_ACCEPTED = "isInitialInformationAccepted";
	public static final String DECISIONID = "decisionid";
	public static final String REPLY = "reply";
	public static final String RFIINTERNALNUMBER = "rfiinternalnumber";
	public static final String PERSISTENCEVERSION = "persistenceversion";
	public static final String CLIENT_ID = "clientId";
	public static final String ONWORKNAME = "onworkname";
	public static final String QUESTION = "question";
	public static final String ISSUE = "issue";
	public static final String CREATED = "created";
	public static final String BPMRFIREMARK_LIST = "bpmrfiremarkList";
	public static final String STKH_IDS = "stkhIds";
	public static final String COMPANY_FROM = "companyFrom";
	public static final String DRWNUMBER = "drwnumber";
	public static final String FOLDER_ID = "folderId";
	public static final String PARENT_ID = "parentId";
	public static final String RE_IDS = "reIds";
	public static final String CHECK_SCHEDULE_IMPACT = "checkScheduleImpact";
	public static final String EM_IDS = "emIds";
	public static final String IS_NEEDED_REVIEW_EOR = "isNeededReviewEor";
	public static final String PERSON_FROM = "personFrom";
	public static final String INTERNALSTATUS = "internalstatus";
	public static final String CONTRACT_ID = "contractId";
	public static final String ONWORKID = "onworkid";
	public static final String STKH_GRP_IDS = "stkhGrpIds";
	public static final String EOR_IDS = "eorIds";
	public static final String PROPOSED_SOLUTION = "proposedSolution";
	public static final String DONE_DATE = "doneDate";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";

}
