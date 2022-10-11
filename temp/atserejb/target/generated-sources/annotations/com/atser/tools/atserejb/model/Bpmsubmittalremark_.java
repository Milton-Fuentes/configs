package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bpmsubmittalremark.class)
public abstract class Bpmsubmittalremark_ {

	public static volatile SingularAttribute<Bpmsubmittalremark, BigInteger> persistenceversion;
	public static volatile SingularAttribute<Bpmsubmittalremark, String> reviewerName;
	public static volatile SingularAttribute<Bpmsubmittalremark, String> reviewerId;
	public static volatile SingularAttribute<Bpmsubmittalremark, Bpmsubmittalbo> bpmsubmittalboPid;
	public static volatile SingularAttribute<Bpmsubmittalremark, String> created;
	public static volatile SingularAttribute<Bpmsubmittalremark, BigDecimal> persistenceid;
	public static volatile SingularAttribute<Bpmsubmittalremark, String> remark;
	public static volatile SingularAttribute<Bpmsubmittalremark, BpmTaskInstance> taskInstanceId;
	public static volatile SingularAttribute<Bpmsubmittalremark, Long> remarksOrder;
	public static volatile SingularAttribute<Bpmsubmittalremark, String> reviewerRole;

	public static final String PERSISTENCEVERSION = "persistenceversion";
	public static final String REVIEWER_NAME = "reviewerName";
	public static final String REVIEWER_ID = "reviewerId";
	public static final String BPMSUBMITTALBO_PID = "bpmsubmittalboPid";
	public static final String CREATED = "created";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String REMARK = "remark";
	public static final String TASK_INSTANCE_ID = "taskInstanceId";
	public static final String REMARKS_ORDER = "remarksOrder";
	public static final String REVIEWER_ROLE = "reviewerRole";

}

