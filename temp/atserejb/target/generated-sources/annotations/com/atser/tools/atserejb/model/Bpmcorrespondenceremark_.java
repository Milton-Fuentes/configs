package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bpmcorrespondenceremark.class)
public abstract class Bpmcorrespondenceremark_ {

	public static volatile SingularAttribute<Bpmcorrespondenceremark, BigInteger> persistenceversion;
	public static volatile SingularAttribute<Bpmcorrespondenceremark, String> reviewerName;
	public static volatile SingularAttribute<Bpmcorrespondenceremark, String> reviewerId;
	public static volatile SingularAttribute<Bpmcorrespondenceremark, Bpmcorrespondencebo> bpmcorrespondenceboPid;
	public static volatile SingularAttribute<Bpmcorrespondenceremark, String> created;
	public static volatile SingularAttribute<Bpmcorrespondenceremark, BigDecimal> persistenceid;
	public static volatile SingularAttribute<Bpmcorrespondenceremark, String> remark;
	public static volatile SingularAttribute<Bpmcorrespondenceremark, BpmTaskInstance> taskInstanceId;
	public static volatile SingularAttribute<Bpmcorrespondenceremark, Long> remarksOrder;
	public static volatile SingularAttribute<Bpmcorrespondenceremark, String> reviewerRole;

	public static final String PERSISTENCEVERSION = "persistenceversion";
	public static final String REVIEWER_NAME = "reviewerName";
	public static final String REVIEWER_ID = "reviewerId";
	public static final String BPMCORRESPONDENCEBO_PID = "bpmcorrespondenceboPid";
	public static final String CREATED = "created";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String REMARK = "remark";
	public static final String TASK_INSTANCE_ID = "taskInstanceId";
	public static final String REMARKS_ORDER = "remarksOrder";
	public static final String REVIEWER_ROLE = "reviewerRole";

}

