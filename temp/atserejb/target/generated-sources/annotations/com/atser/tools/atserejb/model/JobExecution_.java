package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JobExecution.class)
public abstract class JobExecution_ {

	public static volatile SingularAttribute<JobExecution, String> batchstatus;
	public static volatile SingularAttribute<JobExecution, Date> createtime;
	public static volatile SingularAttribute<JobExecution, Date> endtime;
	public static volatile SingularAttribute<JobExecution, String> exitstatus;
	public static volatile SingularAttribute<JobExecution, String> restartposition;
	public static volatile SingularAttribute<JobExecution, JobInstance> jobinstanceid;
	public static volatile SingularAttribute<JobExecution, Date> starttime;
	public static volatile ListAttribute<JobExecution, StepExecution> stepExecutionList;
	public static volatile SingularAttribute<JobExecution, String> jobparameters;
	public static volatile SingularAttribute<JobExecution, BigInteger> version;
	public static volatile SingularAttribute<JobExecution, BigDecimal> jobexecutionid;
	public static volatile SingularAttribute<JobExecution, Date> lastupdatedtime;

	public static final String BATCHSTATUS = "batchstatus";
	public static final String CREATETIME = "createtime";
	public static final String ENDTIME = "endtime";
	public static final String EXITSTATUS = "exitstatus";
	public static final String RESTARTPOSITION = "restartposition";
	public static final String JOBINSTANCEID = "jobinstanceid";
	public static final String STARTTIME = "starttime";
	public static final String STEP_EXECUTION_LIST = "stepExecutionList";
	public static final String JOBPARAMETERS = "jobparameters";
	public static final String VERSION = "version";
	public static final String JOBEXECUTIONID = "jobexecutionid";
	public static final String LASTUPDATEDTIME = "lastupdatedtime";

}

