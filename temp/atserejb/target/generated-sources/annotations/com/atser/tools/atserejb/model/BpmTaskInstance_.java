package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BpmTaskInstance.class)
public abstract class BpmTaskInstance_ {

	public static volatile SingularAttribute<BpmTaskInstance, BpmProcessInstance> processInstanceId;
	public static volatile SingularAttribute<BpmTaskInstance, String> createdByIp;
	public static volatile SingularAttribute<BpmTaskInstance, String> lastModBy;
	public static volatile SingularAttribute<BpmTaskInstance, Date> created;
	public static volatile SingularAttribute<BpmTaskInstance, String> active;
	public static volatile SingularAttribute<BpmTaskInstance, String> lastModByIp;
	public static volatile SingularAttribute<BpmTaskInstance, String> type;
	public static volatile SingularAttribute<BpmTaskInstance, String> priority;
	public static volatile SingularAttribute<BpmTaskInstance, GlobUsers> userId;
	public static volatile SingularAttribute<BpmTaskInstance, BigDecimal> parentId;
	public static volatile SingularAttribute<BpmTaskInstance, String> deleted;
	public static volatile SingularAttribute<BpmTaskInstance, String> createdBy;
	public static volatile SingularAttribute<BpmTaskInstance, BigDecimal> id;
	public static volatile SingularAttribute<BpmTaskInstance, BigDecimal> refId;
	public static volatile SingularAttribute<BpmTaskInstance, String> state;
	public static volatile SingularAttribute<BpmTaskInstance, Date> lastMod;
	public static volatile SingularAttribute<BpmTaskInstance, BpmTask> taskId;

	public static final String PROCESS_INSTANCE_ID = "processInstanceId";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String LAST_MOD_BY_IP = "lastModByIp";
	public static final String TYPE = "type";
	public static final String PRIORITY = "priority";
	public static final String USER_ID = "userId";
	public static final String PARENT_ID = "parentId";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String REF_ID = "refId";
	public static final String STATE = "state";
	public static final String LAST_MOD = "lastMod";
	public static final String TASK_ID = "taskId";

}

