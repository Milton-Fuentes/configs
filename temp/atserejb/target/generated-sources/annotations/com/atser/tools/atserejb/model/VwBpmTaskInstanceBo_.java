package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwBpmTaskInstanceBo.class)
public abstract class VwBpmTaskInstanceBo_ {

	public static volatile SingularAttribute<VwBpmTaskInstanceBo, BpmProcessInstance> processInstanceId;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, String> createdByIp;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, BigDecimal> clientId;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, String> role;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, String> lastModBy;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, Date> created;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, String> active;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, String> lastModByIp;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, String> userName;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, String> type;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, String> priority;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, GlobUsers> userId;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, BigDecimal> parentId;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, String> deleted;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, String> createdBy;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, String> modelNumber;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, String> taskName;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, BigDecimal> id;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, BigDecimal> refId;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, String> state;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, BigDecimal> projectId;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, Date> lastMod;
	public static volatile SingularAttribute<VwBpmTaskInstanceBo, BpmTask> taskId;

	public static final String PROCESS_INSTANCE_ID = "processInstanceId";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String ROLE = "role";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String LAST_MOD_BY_IP = "lastModByIp";
	public static final String USER_NAME = "userName";
	public static final String TYPE = "type";
	public static final String PRIORITY = "priority";
	public static final String USER_ID = "userId";
	public static final String PARENT_ID = "parentId";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String MODEL_NUMBER = "modelNumber";
	public static final String TASK_NAME = "taskName";
	public static final String ID = "id";
	public static final String REF_ID = "refId";
	public static final String STATE = "state";
	public static final String PROJECT_ID = "projectId";
	public static final String LAST_MOD = "lastMod";
	public static final String TASK_ID = "taskId";

}

