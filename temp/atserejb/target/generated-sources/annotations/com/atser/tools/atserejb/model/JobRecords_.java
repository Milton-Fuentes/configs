package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JobRecords.class)
public abstract class JobRecords_ {

	public static volatile SingularAttribute<JobRecords, String> createBy;
	public static volatile SingularAttribute<JobRecords, String> jobdescription;
	public static volatile SingularAttribute<JobRecords, BigInteger> clientId;
	public static volatile SingularAttribute<JobRecords, Character> visible;
	public static volatile SingularAttribute<JobRecords, String> jobtitle;
	public static volatile SingularAttribute<JobRecords, Date> created;
	public static volatile SingularAttribute<JobRecords, BigDecimal> id;
	public static volatile SingularAttribute<JobRecords, String> parameters;
	public static volatile SingularAttribute<JobRecords, String> jobname;
	public static volatile SingularAttribute<JobRecords, Short> status;

	public static final String CREATE_BY = "createBy";
	public static final String JOBDESCRIPTION = "jobdescription";
	public static final String CLIENT_ID = "clientId";
	public static final String VISIBLE = "visible";
	public static final String JOBTITLE = "jobtitle";
	public static final String CREATED = "created";
	public static final String ID = "id";
	public static final String PARAMETERS = "parameters";
	public static final String JOBNAME = "jobname";
	public static final String STATUS = "status";

}

