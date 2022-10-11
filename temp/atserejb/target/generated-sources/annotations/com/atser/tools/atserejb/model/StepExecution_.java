package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StepExecution.class)
public abstract class StepExecution_ {

	public static volatile SingularAttribute<StepExecution, String> batchstatus;
	public static volatile SingularAttribute<StepExecution, BigInteger> readcount;
	public static volatile SingularAttribute<StepExecution, String> executionexception;
	public static volatile SingularAttribute<StepExecution, String> stepname;
	public static volatile SingularAttribute<StepExecution, String> writercheckpointinfo;
	public static volatile SingularAttribute<StepExecution, BigInteger> writeskipcount;
	public static volatile SingularAttribute<StepExecution, Date> endtime;
	public static volatile SingularAttribute<StepExecution, BigInteger> rollbackcount;
	public static volatile SingularAttribute<StepExecution, String> readercheckpointinfo;
	public static volatile SingularAttribute<StepExecution, Date> starttime;
	public static volatile SingularAttribute<StepExecution, String> persistentuserdata;
	public static volatile SingularAttribute<StepExecution, BigInteger> commitcount;
	public static volatile SingularAttribute<StepExecution, BigInteger> version;
	public static volatile SingularAttribute<StepExecution, BigInteger> readskipcount;
	public static volatile ListAttribute<StepExecution, PartitionExecution> partitionExecutionList;
	public static volatile SingularAttribute<StepExecution, String> exitstatus;
	public static volatile SingularAttribute<StepExecution, BigDecimal> stepexecutionid;
	public static volatile SingularAttribute<StepExecution, BigInteger> writecount;
	public static volatile SingularAttribute<StepExecution, BigInteger> processskipcount;
	public static volatile SingularAttribute<StepExecution, BigInteger> filtercount;
	public static volatile SingularAttribute<StepExecution, JobExecution> jobexecutionid;

	public static final String BATCHSTATUS = "batchstatus";
	public static final String READCOUNT = "readcount";
	public static final String EXECUTIONEXCEPTION = "executionexception";
	public static final String STEPNAME = "stepname";
	public static final String WRITERCHECKPOINTINFO = "writercheckpointinfo";
	public static final String WRITESKIPCOUNT = "writeskipcount";
	public static final String ENDTIME = "endtime";
	public static final String ROLLBACKCOUNT = "rollbackcount";
	public static final String READERCHECKPOINTINFO = "readercheckpointinfo";
	public static final String STARTTIME = "starttime";
	public static final String PERSISTENTUSERDATA = "persistentuserdata";
	public static final String COMMITCOUNT = "commitcount";
	public static final String VERSION = "version";
	public static final String READSKIPCOUNT = "readskipcount";
	public static final String PARTITION_EXECUTION_LIST = "partitionExecutionList";
	public static final String EXITSTATUS = "exitstatus";
	public static final String STEPEXECUTIONID = "stepexecutionid";
	public static final String WRITECOUNT = "writecount";
	public static final String PROCESSSKIPCOUNT = "processskipcount";
	public static final String FILTERCOUNT = "filtercount";
	public static final String JOBEXECUTIONID = "jobexecutionid";

}

