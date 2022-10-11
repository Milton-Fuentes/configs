package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BpmTaskMatrix.class)
public abstract class BpmTaskMatrix_ {

	public static volatile SingularAttribute<BpmTaskMatrix, String> createdByIp;
	public static volatile SingularAttribute<BpmTaskMatrix, BigDecimal> clientId;
	public static volatile SingularAttribute<BpmTaskMatrix, String> lastModBy;
	public static volatile SingularAttribute<BpmTaskMatrix, BigDecimal> trgTaskId;
	public static volatile SingularAttribute<BpmTaskMatrix, Date> created;
	public static volatile SingularAttribute<BpmTaskMatrix, String> active;
	public static volatile SingularAttribute<BpmTaskMatrix, String> lastModByIp;
	public static volatile SingularAttribute<BpmTaskMatrix, String> condition;
	public static volatile SingularAttribute<BpmTaskMatrix, BigDecimal> orgTaskId;
	public static volatile SingularAttribute<BpmTaskMatrix, String> deleted;
	public static volatile SingularAttribute<BpmTaskMatrix, BigDecimal> processId;
	public static volatile SingularAttribute<BpmTaskMatrix, String> createdBy;
	public static volatile ListAttribute<BpmTaskMatrix, BpmCondition> bpmConditionList;
	public static volatile SingularAttribute<BpmTaskMatrix, BigDecimal> id;
	public static volatile SingularAttribute<BpmTaskMatrix, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String TRG_TASK_ID = "trgTaskId";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String LAST_MOD_BY_IP = "lastModByIp";
	public static final String CONDITION = "condition";
	public static final String ORG_TASK_ID = "orgTaskId";
	public static final String DELETED = "deleted";
	public static final String PROCESS_ID = "processId";
	public static final String CREATED_BY = "createdBy";
	public static final String BPM_CONDITION_LIST = "bpmConditionList";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

