package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bpminspectordispatchbo.class)
public abstract class Bpminspectordispatchbo_ {

	public static volatile SingularAttribute<Bpminspectordispatchbo, String> requestLocation;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> finaldisposition;
	public static volatile SingularAttribute<Bpminspectordispatchbo, Long> inspectorrouter;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> rejectreason;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> requestDescription;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> activityId;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> finalremark;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> requestServicedate;
	public static volatile SingularAttribute<Bpminspectordispatchbo, BigInteger> caseId;
	public static volatile SingularAttribute<Bpminspectordispatchbo, BigDecimal> persistenceid;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> decisionid;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> requestnumber;
	public static volatile ListAttribute<Bpminspectordispatchbo, GlobInspworkorder> globInspworkorderList;
	public static volatile SingularAttribute<Bpminspectordispatchbo, BigInteger> persistenceversion;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> clientId;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> created;
	public static volatile SingularAttribute<Bpminspectordispatchbo, Short> iscancel;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> requestSource;
	public static volatile SingularAttribute<Bpminspectordispatchbo, Short> isrollback;
	public static volatile SingularAttribute<Bpminspectordispatchbo, BigInteger> folderId;
	public static volatile SingularAttribute<Bpminspectordispatchbo, BigInteger> parentId;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> requestName;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> requestedBy;
	public static volatile SingularAttribute<Bpminspectordispatchbo, Short> cancreaterevision;
	public static volatile SingularAttribute<Bpminspectordispatchbo, BigInteger> requestorId;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> restorepoint;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> internalstatus;
	public static volatile ListAttribute<Bpminspectordispatchbo, Bpminspectordispatchremark> bpminspectordispatchremarkList;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> contractId;
	public static volatile SingularAttribute<Bpminspectordispatchbo, Short> isapprovedfromre;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> doneDate;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> emailToNotify;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> projectId;
	public static volatile SingularAttribute<Bpminspectordispatchbo, String> status;

	public static final String REQUEST_LOCATION = "requestLocation";
	public static final String FINALDISPOSITION = "finaldisposition";
	public static final String INSPECTORROUTER = "inspectorrouter";
	public static final String REJECTREASON = "rejectreason";
	public static final String REQUEST_DESCRIPTION = "requestDescription";
	public static final String ACTIVITY_ID = "activityId";
	public static final String FINALREMARK = "finalremark";
	public static final String REQUEST_SERVICEDATE = "requestServicedate";
	public static final String CASE_ID = "caseId";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String DECISIONID = "decisionid";
	public static final String REQUESTNUMBER = "requestnumber";
	public static final String GLOB_INSPWORKORDER_LIST = "globInspworkorderList";
	public static final String PERSISTENCEVERSION = "persistenceversion";
	public static final String CLIENT_ID = "clientId";
	public static final String CREATED = "created";
	public static final String ISCANCEL = "iscancel";
	public static final String REQUEST_SOURCE = "requestSource";
	public static final String ISROLLBACK = "isrollback";
	public static final String FOLDER_ID = "folderId";
	public static final String PARENT_ID = "parentId";
	public static final String REQUEST_NAME = "requestName";
	public static final String REQUESTED_BY = "requestedBy";
	public static final String CANCREATEREVISION = "cancreaterevision";
	public static final String REQUESTOR_ID = "requestorId";
	public static final String RESTOREPOINT = "restorepoint";
	public static final String INTERNALSTATUS = "internalstatus";
	public static final String BPMINSPECTORDISPATCHREMARK_LIST = "bpminspectordispatchremarkList";
	public static final String CONTRACT_ID = "contractId";
	public static final String ISAPPROVEDFROMRE = "isapprovedfromre";
	public static final String DONE_DATE = "doneDate";
	public static final String EMAIL_TO_NOTIFY = "emailToNotify";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";

}

