package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BpmCondition.class)
public abstract class BpmCondition_ {

	public static volatile SingularAttribute<BpmCondition, String> condition;
	public static volatile SingularAttribute<BpmCondition, String> createdByIp;
	public static volatile SingularAttribute<BpmCondition, String> deleted;
	public static volatile SingularAttribute<BpmCondition, String> lastModBy;
	public static volatile SingularAttribute<BpmCondition, String> createdBy;
	public static volatile SingularAttribute<BpmCondition, Date> created;
	public static volatile SingularAttribute<BpmCondition, String> active;
	public static volatile SingularAttribute<BpmCondition, String> lastModByIp;
	public static volatile SingularAttribute<BpmCondition, BigDecimal> id;
	public static volatile SingularAttribute<BpmCondition, Date> lastMod;
	public static volatile SingularAttribute<BpmCondition, BigDecimal> taskId;

	public static final String CONDITION = "condition";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String DELETED = "deleted";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String LAST_MOD_BY_IP = "lastModByIp";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String TASK_ID = "taskId";

}

