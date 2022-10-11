package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BpmTask.class)
public abstract class BpmTask_ {

	public static volatile SingularAttribute<BpmTask, String> multiUserTaskSrc;
	public static volatile SingularAttribute<BpmTask, String> createdByIp;
	public static volatile SingularAttribute<BpmTask, String> code;
	public static volatile SingularAttribute<BpmTask, String> lastModBy;
	public static volatile SingularAttribute<BpmTask, Date> created;
	public static volatile SingularAttribute<BpmTask, Short> taskNotificationNew;
	public static volatile SingularAttribute<BpmTask, String> description;
	public static volatile SingularAttribute<BpmTask, String> active;
	public static volatile SingularAttribute<BpmTask, String> lastModByIp;
	public static volatile SingularAttribute<BpmTask, String> type;
	public static volatile SingularAttribute<BpmTask, Integer> requiredRespDays;
	public static volatile SingularAttribute<BpmTask, GlobRoles> actorId;
	public static volatile SingularAttribute<BpmTask, String> deleted;
	public static volatile SingularAttribute<BpmTask, BpmProcess> processId;
	public static volatile SingularAttribute<BpmTask, String> createdBy;
	public static volatile ListAttribute<BpmTask, BpmCondition> bpmConditionList;
	public static volatile SingularAttribute<BpmTask, Short> taskNotificationOther;
	public static volatile SingularAttribute<BpmTask, String> name;
	public static volatile SingularAttribute<BpmTask, String> pageUrl;
	public static volatile SingularAttribute<BpmTask, Short> isMultiUserTask;
	public static volatile SingularAttribute<BpmTask, BigDecimal> id;
	public static volatile SingularAttribute<BpmTask, String> taskNtfTmplCode;
	public static volatile SingularAttribute<BpmTask, String> taskNtfTmpl;
	public static volatile SingularAttribute<BpmTask, Date> lastMod;

	public static final String MULTI_USER_TASK_SRC = "multiUserTaskSrc";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CODE = "code";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String TASK_NOTIFICATION_NEW = "taskNotificationNew";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String LAST_MOD_BY_IP = "lastModByIp";
	public static final String TYPE = "type";
	public static final String REQUIRED_RESP_DAYS = "requiredRespDays";
	public static final String ACTOR_ID = "actorId";
	public static final String DELETED = "deleted";
	public static final String PROCESS_ID = "processId";
	public static final String CREATED_BY = "createdBy";
	public static final String BPM_CONDITION_LIST = "bpmConditionList";
	public static final String TASK_NOTIFICATION_OTHER = "taskNotificationOther";
	public static final String NAME = "name";
	public static final String PAGE_URL = "pageUrl";
	public static final String IS_MULTI_USER_TASK = "isMultiUserTask";
	public static final String ID = "id";
	public static final String TASK_NTF_TMPL_CODE = "taskNtfTmplCode";
	public static final String TASK_NTF_TMPL = "taskNtfTmpl";
	public static final String LAST_MOD = "lastMod";

}

