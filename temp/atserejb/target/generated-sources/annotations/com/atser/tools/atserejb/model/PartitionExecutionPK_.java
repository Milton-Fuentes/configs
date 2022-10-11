package com.atser.tools.atserejb.model;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PartitionExecutionPK.class)
public abstract class PartitionExecutionPK_ {

	public static volatile SingularAttribute<PartitionExecutionPK, BigInteger> partitionexecutionid;
	public static volatile SingularAttribute<PartitionExecutionPK, BigInteger> stepexecutionid;

	public static final String PARTITIONEXECUTIONID = "partitionexecutionid";
	public static final String STEPEXECUTIONID = "stepexecutionid";

}

