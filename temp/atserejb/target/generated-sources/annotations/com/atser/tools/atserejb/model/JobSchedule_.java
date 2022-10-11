package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JobSchedule.class)
public abstract class JobSchedule_ {

	public static volatile SingularAttribute<JobSchedule, BigInteger> targetmin;
	public static volatile SingularAttribute<JobSchedule, BigInteger> period;
	public static volatile SingularAttribute<JobSchedule, BigInteger> targetsec;
	public static volatile SingularAttribute<JobSchedule, BigInteger> clientId;
	public static volatile SingularAttribute<JobSchedule, String> jobparams;
	public static volatile SingularAttribute<JobSchedule, Date> created;
	public static volatile SingularAttribute<JobSchedule, String> active;
	public static volatile SingularAttribute<JobSchedule, String> hasdelay;
	public static volatile SingularAttribute<JobSchedule, String> createBy;
	public static volatile SingularAttribute<JobSchedule, String> deleted;
	public static volatile SingularAttribute<JobSchedule, BigDecimal> id;
	public static volatile SingularAttribute<JobSchedule, String> jobname;
	public static volatile SingularAttribute<JobSchedule, BigInteger> targethour;

	public static final String TARGETMIN = "targetmin";
	public static final String PERIOD = "period";
	public static final String TARGETSEC = "targetsec";
	public static final String CLIENT_ID = "clientId";
	public static final String JOBPARAMS = "jobparams";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String HASDELAY = "hasdelay";
	public static final String CREATE_BY = "createBy";
	public static final String DELETED = "deleted";
	public static final String ID = "id";
	public static final String JOBNAME = "jobname";
	public static final String TARGETHOUR = "targethour";

}

