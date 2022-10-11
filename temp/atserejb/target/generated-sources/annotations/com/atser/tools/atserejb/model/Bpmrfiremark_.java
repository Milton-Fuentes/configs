package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bpmrfiremark.class)
public abstract class Bpmrfiremark_ {

	public static volatile SingularAttribute<Bpmrfiremark, Bpmrfibo> bpmrfiboPid;
	public static volatile SingularAttribute<Bpmrfiremark, BigInteger> persistenceversion;
	public static volatile SingularAttribute<Bpmrfiremark, String> reviewerName;
	public static volatile SingularAttribute<Bpmrfiremark, String> reviewerId;
	public static volatile SingularAttribute<Bpmrfiremark, String> created;
	public static volatile SingularAttribute<Bpmrfiremark, BigDecimal> persistenceid;
	public static volatile SingularAttribute<Bpmrfiremark, String> remark;
	public static volatile SingularAttribute<Bpmrfiremark, BpmTaskInstance> taskInstanceId;
	public static volatile SingularAttribute<Bpmrfiremark, Long> remarksOrder;
	public static volatile SingularAttribute<Bpmrfiremark, String> reviewerRole;

	public static final String BPMRFIBO_PID = "bpmrfiboPid";
	public static final String PERSISTENCEVERSION = "persistenceversion";
	public static final String REVIEWER_NAME = "reviewerName";
	public static final String REVIEWER_ID = "reviewerId";
	public static final String CREATED = "created";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String REMARK = "remark";
	public static final String TASK_INSTANCE_ID = "taskInstanceId";
	public static final String REMARKS_ORDER = "remarksOrder";
	public static final String REVIEWER_ROLE = "reviewerRole";

}

