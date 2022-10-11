package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScbAggSv.class)
public abstract class ScbAggSv_ {

	public static volatile SingularAttribute<ScbAggSv, String> setName;
	public static volatile SingularAttribute<ScbAggSv, BigInteger> testNo;
	public static volatile SingularAttribute<ScbAggSv, String> traceNo;
	public static volatile SingularAttribute<ScbAggSv, String> cmLocation;
	public static volatile SingularAttribute<ScbAggSv, String> testingTech;
	public static volatile SingularAttribute<ScbAggSv, BigInteger> functionId;
	public static volatile SingularAttribute<ScbAggSv, String> projectNo;
	public static volatile SingularAttribute<ScbAggSv, String> pName;
	public static volatile SingularAttribute<ScbAggSv, String> testNoLink;
	public static volatile SingularAttribute<ScbAggSv, BigInteger> labId;
	public static volatile SingularAttribute<ScbAggSv, Date> dateOfTest;
	public static volatile SingularAttribute<ScbAggSv, String> testReportNo;
	public static volatile SingularAttribute<ScbAggSv, BigInteger> setId;
	public static volatile SingularAttribute<ScbAggSv, BigDecimal> id;
	public static volatile SingularAttribute<ScbAggSv, BigInteger> sampletestid;
	public static volatile SingularAttribute<ScbAggSv, Character> peReview;
	public static volatile SingularAttribute<ScbAggSv, String> percentpass;
	public static volatile SingularAttribute<ScbAggSv, Character> testClosed;
	public static volatile SingularAttribute<ScbAggSv, BigInteger> sieveId;
	public static volatile SingularAttribute<ScbAggSv, String> labname;
	public static volatile SingularAttribute<ScbAggSv, String> totalwt;
	public static volatile SingularAttribute<ScbAggSv, String> svName;
	public static volatile SingularAttribute<ScbAggSv, String> accumwtret;
	public static volatile SingularAttribute<ScbAggSv, String> percentret;
	public static volatile SingularAttribute<ScbAggSv, BigInteger> testId;
	public static volatile SingularAttribute<ScbAggSv, String> projRequire;
	public static volatile SingularAttribute<ScbAggSv, BigInteger> projectId;
	public static volatile SingularAttribute<ScbAggSv, BigInteger> techId;
	public static volatile SingularAttribute<ScbAggSv, String> remarks;
	public static volatile SingularAttribute<ScbAggSv, String> status;

	public static final String SET_NAME = "setName";
	public static final String TEST_NO = "testNo";
	public static final String TRACE_NO = "traceNo";
	public static final String CM_LOCATION = "cmLocation";
	public static final String TESTING_TECH = "testingTech";
	public static final String FUNCTION_ID = "functionId";
	public static final String PROJECT_NO = "projectNo";
	public static final String P_NAME = "pName";
	public static final String TEST_NO_LINK = "testNoLink";
	public static final String LAB_ID = "labId";
	public static final String DATE_OF_TEST = "dateOfTest";
	public static final String TEST_REPORT_NO = "testReportNo";
	public static final String SET_ID = "setId";
	public static final String ID = "id";
	public static final String SAMPLETESTID = "sampletestid";
	public static final String PE_REVIEW = "peReview";
	public static final String PERCENTPASS = "percentpass";
	public static final String TEST_CLOSED = "testClosed";
	public static final String SIEVE_ID = "sieveId";
	public static final String LABNAME = "labname";
	public static final String TOTALWT = "totalwt";
	public static final String SV_NAME = "svName";
	public static final String ACCUMWTRET = "accumwtret";
	public static final String PERCENTRET = "percentret";
	public static final String TEST_ID = "testId";
	public static final String PROJ_REQUIRE = "projRequire";
	public static final String PROJECT_ID = "projectId";
	public static final String TECH_ID = "techId";
	public static final String REMARKS = "remarks";
	public static final String STATUS = "status";

}

