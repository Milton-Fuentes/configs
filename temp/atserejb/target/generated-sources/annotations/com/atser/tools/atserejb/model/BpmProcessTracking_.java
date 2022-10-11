package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BpmProcessTracking.class)
public abstract class BpmProcessTracking_ {

	public static volatile SingularAttribute<BpmProcessTracking, String> createdByIp;
	public static volatile SingularAttribute<BpmProcessTracking, Integer> persistenceversion;
	public static volatile SingularAttribute<BpmProcessTracking, BigInteger> clientId;
	public static volatile SingularAttribute<BpmProcessTracking, String> created;
	public static volatile SingularAttribute<BpmProcessTracking, Short> active;
	public static volatile SingularAttribute<BpmProcessTracking, String> systemModule;
	public static volatile SingularAttribute<BpmProcessTracking, BigInteger> processCatgId;
	public static volatile SingularAttribute<BpmProcessTracking, String> internalStatus;
	public static volatile SingularAttribute<BpmProcessTracking, Short> deleted;
	public static volatile SingularAttribute<BpmProcessTracking, BigInteger> processId;
	public static volatile SingularAttribute<BpmProcessTracking, String> createdBy;
	public static volatile SingularAttribute<BpmProcessTracking, BigInteger> caseId;
	public static volatile SingularAttribute<BpmProcessTracking, BigInteger> contractId;
	public static volatile SingularAttribute<BpmProcessTracking, BigDecimal> persistenceid;
	public static volatile SingularAttribute<BpmProcessTracking, BigInteger> refId;
	public static volatile SingularAttribute<BpmProcessTracking, BigInteger> functionalityId;
	public static volatile SingularAttribute<BpmProcessTracking, BigInteger> projectId;
	public static volatile SingularAttribute<BpmProcessTracking, BigInteger> createdById;
	public static volatile SingularAttribute<BpmProcessTracking, String> status;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String PERSISTENCEVERSION = "persistenceversion";
	public static final String CLIENT_ID = "clientId";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String SYSTEM_MODULE = "systemModule";
	public static final String PROCESS_CATG_ID = "processCatgId";
	public static final String INTERNAL_STATUS = "internalStatus";
	public static final String DELETED = "deleted";
	public static final String PROCESS_ID = "processId";
	public static final String CREATED_BY = "createdBy";
	public static final String CASE_ID = "caseId";
	public static final String CONTRACT_ID = "contractId";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String REF_ID = "refId";
	public static final String FUNCTIONALITY_ID = "functionalityId";
	public static final String PROJECT_ID = "projectId";
	public static final String CREATED_BY_ID = "createdById";
	public static final String STATUS = "status";

}

