package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bpmdispatchbo.class)
public abstract class Bpmdispatchbo_ {

	public static volatile SingularAttribute<Bpmdispatchbo, String> mixDesign;
	public static volatile SingularAttribute<Bpmdispatchbo, String> requestLocation;
	public static volatile SingularAttribute<Bpmdispatchbo, String> finaldisposition;
	public static volatile SingularAttribute<Bpmdispatchbo, String> rejectreason;
	public static volatile SingularAttribute<Bpmdispatchbo, Short> isapprovedfromdispatch;
	public static volatile SingularAttribute<Bpmdispatchbo, String> requestDescription;
	public static volatile SingularAttribute<Bpmdispatchbo, String> activityId;
	public static volatile SingularAttribute<Bpmdispatchbo, String> finalremark;
	public static volatile SingularAttribute<Bpmdispatchbo, String> datetimereqOnjobsite;
	public static volatile SingularAttribute<Bpmdispatchbo, BigInteger> caseId;
	public static volatile SingularAttribute<Bpmdispatchbo, Short> isapprovedfromqa;
	public static volatile SingularAttribute<Bpmdispatchbo, BigDecimal> persistenceid;
	public static volatile SingularAttribute<Bpmdispatchbo, String> decisionid;
	public static volatile SingularAttribute<Bpmdispatchbo, String> requestnumber;
	public static volatile SingularAttribute<Bpmdispatchbo, Long> techrouter;
	public static volatile SingularAttribute<Bpmdispatchbo, BigInteger> persistenceversion;
	public static volatile SingularAttribute<Bpmdispatchbo, String> clientId;
	public static volatile SingularAttribute<Bpmdispatchbo, String> created;
	public static volatile SingularAttribute<Bpmdispatchbo, Short> iscancel;
	public static volatile SingularAttribute<Bpmdispatchbo, String> requestSource;
	public static volatile SingularAttribute<Bpmdispatchbo, Short> isrollback;
	public static volatile ListAttribute<Bpmdispatchbo, Bpmdispatchremark> bpmdispatchremarkList;
	public static volatile SingularAttribute<Bpmdispatchbo, BigInteger> folderId;
	public static volatile SingularAttribute<Bpmdispatchbo, BigInteger> parentId;
	public static volatile SingularAttribute<Bpmdispatchbo, String> requestName;
	public static volatile SingularAttribute<Bpmdispatchbo, String> requestedBy;
	public static volatile SingularAttribute<Bpmdispatchbo, Short> cancreaterevision;
	public static volatile SingularAttribute<Bpmdispatchbo, BigInteger> requestorId;
	public static volatile SingularAttribute<Bpmdispatchbo, String> restorepoint;
	public static volatile SingularAttribute<Bpmdispatchbo, String> reqQty;
	public static volatile SingularAttribute<Bpmdispatchbo, String> internalstatus;
	public static volatile SingularAttribute<Bpmdispatchbo, String> contractId;
	public static volatile SingularAttribute<Bpmdispatchbo, String> doneDate;
	public static volatile SingularAttribute<Bpmdispatchbo, String> projectId;
	public static volatile SingularAttribute<Bpmdispatchbo, String> emailToNotify;
	public static volatile SingularAttribute<Bpmdispatchbo, String> mixDesignType;
	public static volatile SingularAttribute<Bpmdispatchbo, String> status;
	public static volatile SingularAttribute<Bpmdispatchbo, String> batchPlant;

	public static final String MIX_DESIGN = "mixDesign";
	public static final String REQUEST_LOCATION = "requestLocation";
	public static final String FINALDISPOSITION = "finaldisposition";
	public static final String REJECTREASON = "rejectreason";
	public static final String ISAPPROVEDFROMDISPATCH = "isapprovedfromdispatch";
	public static final String REQUEST_DESCRIPTION = "requestDescription";
	public static final String ACTIVITY_ID = "activityId";
	public static final String FINALREMARK = "finalremark";
	public static final String DATETIMEREQ_ONJOBSITE = "datetimereqOnjobsite";
	public static final String CASE_ID = "caseId";
	public static final String ISAPPROVEDFROMQA = "isapprovedfromqa";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String DECISIONID = "decisionid";
	public static final String REQUESTNUMBER = "requestnumber";
	public static final String TECHROUTER = "techrouter";
	public static final String PERSISTENCEVERSION = "persistenceversion";
	public static final String CLIENT_ID = "clientId";
	public static final String CREATED = "created";
	public static final String ISCANCEL = "iscancel";
	public static final String REQUEST_SOURCE = "requestSource";
	public static final String ISROLLBACK = "isrollback";
	public static final String BPMDISPATCHREMARK_LIST = "bpmdispatchremarkList";
	public static final String FOLDER_ID = "folderId";
	public static final String PARENT_ID = "parentId";
	public static final String REQUEST_NAME = "requestName";
	public static final String REQUESTED_BY = "requestedBy";
	public static final String CANCREATEREVISION = "cancreaterevision";
	public static final String REQUESTOR_ID = "requestorId";
	public static final String RESTOREPOINT = "restorepoint";
	public static final String REQ_QTY = "reqQty";
	public static final String INTERNALSTATUS = "internalstatus";
	public static final String CONTRACT_ID = "contractId";
	public static final String DONE_DATE = "doneDate";
	public static final String PROJECT_ID = "projectId";
	public static final String EMAIL_TO_NOTIFY = "emailToNotify";
	public static final String MIX_DESIGN_TYPE = "mixDesignType";
	public static final String STATUS = "status";
	public static final String BATCH_PLANT = "batchPlant";

}

