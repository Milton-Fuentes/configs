package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScbAllReport.class)
public abstract class ScbAllReport_ {

	public static volatile SingularAttribute<ScbAllReport, BigInteger> sampletestid;
	public static volatile SingularAttribute<ScbAllReport, Character> peReview;
	public static volatile SingularAttribute<ScbAllReport, BigInteger> testNo;
	public static volatile SingularAttribute<ScbAllReport, Character> testClosed;
	public static volatile SingularAttribute<ScbAllReport, String> traceNo;
	public static volatile SingularAttribute<ScbAllReport, BigInteger> testMethodId;
	public static volatile SingularAttribute<ScbAllReport, String> labname;
	public static volatile SingularAttribute<ScbAllReport, String> cmLocation;
	public static volatile SingularAttribute<ScbAllReport, Character> passfail;
	public static volatile SingularAttribute<ScbAllReport, String> testingTech;
	public static volatile SingularAttribute<ScbAllReport, BigInteger> functionId;
	public static volatile SingularAttribute<ScbAllReport, String> projectNo;
	public static volatile SingularAttribute<ScbAllReport, String> pName;
	public static volatile SingularAttribute<ScbAllReport, String> testNoLink;
	public static volatile SingularAttribute<ScbAllReport, BigInteger> labId;
	public static volatile SingularAttribute<ScbAllReport, Date> dateOfTest;
	public static volatile SingularAttribute<ScbAllReport, String> testReportNo;
	public static volatile SingularAttribute<ScbAllReport, String> testId;
	public static volatile SingularAttribute<ScbAllReport, BigDecimal> id;
	public static volatile SingularAttribute<ScbAllReport, BigInteger> projectId;
	public static volatile SingularAttribute<ScbAllReport, BigInteger> techId;
	public static volatile SingularAttribute<ScbAllReport, String> testName;
	public static volatile SingularAttribute<ScbAllReport, String> status;

	public static final String SAMPLETESTID = "sampletestid";
	public static final String PE_REVIEW = "peReview";
	public static final String TEST_NO = "testNo";
	public static final String TEST_CLOSED = "testClosed";
	public static final String TRACE_NO = "traceNo";
	public static final String TEST_METHOD_ID = "testMethodId";
	public static final String LABNAME = "labname";
	public static final String CM_LOCATION = "cmLocation";
	public static final String PASSFAIL = "passfail";
	public static final String TESTING_TECH = "testingTech";
	public static final String FUNCTION_ID = "functionId";
	public static final String PROJECT_NO = "projectNo";
	public static final String P_NAME = "pName";
	public static final String TEST_NO_LINK = "testNoLink";
	public static final String LAB_ID = "labId";
	public static final String DATE_OF_TEST = "dateOfTest";
	public static final String TEST_REPORT_NO = "testReportNo";
	public static final String TEST_ID = "testId";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String TECH_ID = "techId";
	public static final String TEST_NAME = "testName";
	public static final String STATUS = "status";

}

