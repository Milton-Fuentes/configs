package com.atser.tools.atserejb.model;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PartitionExecution.class)
public abstract class PartitionExecution_ {

	public static volatile SingularAttribute<PartitionExecution, String> batchstatus;
	public static volatile SingularAttribute<PartitionExecution, String> executionexception;
	public static volatile SingularAttribute<PartitionExecution, String> writercheckpointinfo;
	public static volatile SingularAttribute<PartitionExecution, String> exitstatus;
	public static volatile SingularAttribute<PartitionExecution, String> readercheckpointinfo;
	public static volatile SingularAttribute<PartitionExecution, PartitionExecutionPK> partitionExecutionPK;
	public static volatile SingularAttribute<PartitionExecution, String> persistentuserdata;
	public static volatile SingularAttribute<PartitionExecution, BigInteger> version;
	public static volatile SingularAttribute<PartitionExecution, StepExecution> stepExecution;

	public static final String BATCHSTATUS = "batchstatus";
	public static final String EXECUTIONEXCEPTION = "executionexception";
	public static final String WRITERCHECKPOINTINFO = "writercheckpointinfo";
	public static final String EXITSTATUS = "exitstatus";
	public static final String READERCHECKPOINTINFO = "readercheckpointinfo";
	public static final String PARTITION_EXECUTION_PK = "partitionExecutionPK";
	public static final String PERSISTENTUSERDATA = "persistentuserdata";
	public static final String VERSION = "version";
	public static final String STEP_EXECUTION = "stepExecution";

}

