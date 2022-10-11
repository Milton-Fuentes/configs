package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JobInstance.class)
public abstract class JobInstance_ {

	public static volatile ListAttribute<JobInstance, JobExecution> jobExecutionList;
	public static volatile SingularAttribute<JobInstance, BigDecimal> jobinstanceid;
	public static volatile SingularAttribute<JobInstance, BigInteger> version;
	public static volatile SingularAttribute<JobInstance, String> jobname;
	public static volatile SingularAttribute<JobInstance, String> applicationname;

	public static final String JOB_EXECUTION_LIST = "jobExecutionList";
	public static final String JOBINSTANCEID = "jobinstanceid";
	public static final String VERSION = "version";
	public static final String JOBNAME = "jobname";
	public static final String APPLICATIONNAME = "applicationname";

}

