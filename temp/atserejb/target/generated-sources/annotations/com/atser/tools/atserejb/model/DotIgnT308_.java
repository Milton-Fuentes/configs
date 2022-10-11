package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DotIgnT308.class)
public abstract class DotIgnT308_ {

	public static volatile SingularAttribute<DotIgnT308, String> testResults;
	public static volatile SingularAttribute<DotIgnT308, String> wbsDescript;
	public static volatile SingularAttribute<DotIgnT308, String> reason;
	public static volatile SingularAttribute<DotIgnT308, String> sampleTcn;
	public static volatile SingularAttribute<DotIgnT308, String> lowerSpecLimit;
	public static volatile SingularAttribute<DotIgnT308, String> finalSampleMass;
	public static volatile SingularAttribute<DotIgnT308, String> traceNo;
	public static volatile SingularAttribute<DotIgnT308, String> ovenSetPoint;
	public static volatile SingularAttribute<DotIgnT308, String> cmLocation;
	public static volatile SingularAttribute<DotIgnT308, String> upperSpecLimit;
	public static volatile SingularAttribute<DotIgnT308, String> pctPgBinder;
	public static volatile SingularAttribute<DotIgnT308, String> testingTech;
	public static volatile SingularAttribute<DotIgnT308, String> correctedSampleMass;
	public static volatile SingularAttribute<DotIgnT308, String> initialSampleMass;
	public static volatile SingularAttribute<DotIgnT308, String> testNoLink;
	public static volatile SingularAttribute<DotIgnT308, BigDecimal> labId;
	public static volatile SingularAttribute<DotIgnT308, String> function;
	public static volatile SingularAttribute<DotIgnT308, BigDecimal> id;
	public static volatile SingularAttribute<DotIgnT308, BigDecimal> mixDesignId;
	public static volatile SingularAttribute<DotIgnT308, String> basketTareMass;
	public static volatile SingularAttribute<DotIgnT308, String> maxAllowableDifference5;
	public static volatile SingularAttribute<DotIgnT308, Character> peReview;
	public static volatile SingularAttribute<DotIgnT308, String> pgBinderMass;
	public static volatile SingularAttribute<DotIgnT308, Character> testClosed;
	public static volatile SingularAttribute<DotIgnT308, String> labname;
	public static volatile SingularAttribute<DotIgnT308, BigInteger> subbiditemId;
	public static volatile SingularAttribute<DotIgnT308, Character> active;
	public static volatile SingularAttribute<DotIgnT308, String> pNumber;
	public static volatile SingularAttribute<DotIgnT308, Date> dateoftest;
	public static volatile SingularAttribute<DotIgnT308, String> passfail;
	public static volatile SingularAttribute<DotIgnT308, String> additive;
	public static volatile SingularAttribute<DotIgnT308, String> temperatureCorrectionFactor;
	public static volatile SingularAttribute<DotIgnT308, String> subbiditemDescript;
	public static volatile SingularAttribute<DotIgnT308, String> pgBinderJmf;
	public static volatile SingularAttribute<DotIgnT308, String> avgPctPgBinder;
	public static volatile SingularAttribute<DotIgnT308, String> difference;
	public static volatile SingularAttribute<DotIgnT308, BigInteger> projectId;
	public static volatile SingularAttribute<DotIgnT308, String> status;
	public static volatile SingularAttribute<DotIgnT308, BigDecimal> sampletestId;
	public static volatile SingularAttribute<DotIgnT308, String> specimenNo;
	public static volatile SingularAttribute<DotIgnT308, String> testNo;
	public static volatile SingularAttribute<DotIgnT308, String> aggregateCorrectionFactor;
	public static volatile SingularAttribute<DotIgnT308, String> sampleNo;
	public static volatile SingularAttribute<DotIgnT308, String> biditemNo;
	public static volatile SingularAttribute<DotIgnT308, String> lowerEngLimit;
	public static volatile SingularAttribute<DotIgnT308, String> wbsNo;
	public static volatile SingularAttribute<DotIgnT308, String> pName;
	public static volatile SingularAttribute<DotIgnT308, String> testTime;
	public static volatile SingularAttribute<DotIgnT308, BigInteger> binderGradeId;
	public static volatile SingularAttribute<DotIgnT308, BigDecimal> qaSampleId;
	public static volatile SingularAttribute<DotIgnT308, String> upperEngLimit;
	public static volatile SingularAttribute<DotIgnT308, BigDecimal> clientId;
	public static volatile SingularAttribute<DotIgnT308, BigInteger> quantity;
	public static volatile SingularAttribute<DotIgnT308, String> beginningOvenWeight;
	public static volatile SingularAttribute<DotIgnT308, String> mixDesignNo;
	public static volatile SingularAttribute<DotIgnT308, String> equipList;
	public static volatile SingularAttribute<DotIgnT308, String> biditemDescript;
	public static volatile SingularAttribute<DotIgnT308, String> asphaltcement;
	public static volatile SingularAttribute<DotIgnT308, BigDecimal> biditemId;
	public static volatile SingularAttribute<DotIgnT308, BigInteger> wbsId;
	public static volatile SingularAttribute<DotIgnT308, String> farSummary;
	public static volatile SingularAttribute<DotIgnT308, BigDecimal> testId;
	public static volatile SingularAttribute<DotIgnT308, String> pctMoisture;
	public static volatile SingularAttribute<DotIgnT308, String> techId;
	public static volatile SingularAttribute<DotIgnT308, String> remarks;

	public static final String TEST_RESULTS = "testResults";
	public static final String WBS_DESCRIPT = "wbsDescript";
	public static final String REASON = "reason";
	public static final String SAMPLE_TCN = "sampleTcn";
	public static final String LOWER_SPEC_LIMIT = "lowerSpecLimit";
	public static final String FINAL_SAMPLE_MASS = "finalSampleMass";
	public static final String TRACE_NO = "traceNo";
	public static final String OVEN_SET_POINT = "ovenSetPoint";
	public static final String CM_LOCATION = "cmLocation";
	public static final String UPPER_SPEC_LIMIT = "upperSpecLimit";
	public static final String PCT_PG_BINDER = "pctPgBinder";
	public static final String TESTING_TECH = "testingTech";
	public static final String CORRECTED_SAMPLE_MASS = "correctedSampleMass";
	public static final String INITIAL_SAMPLE_MASS = "initialSampleMass";
	public static final String TEST_NO_LINK = "testNoLink";
	public static final String LAB_ID = "labId";
	public static final String FUNCTION = "function";
	public static final String ID = "id";
	public static final String MIX_DESIGN_ID = "mixDesignId";
	public static final String BASKET_TARE_MASS = "basketTareMass";
	public static final String MAX_ALLOWABLE_DIFFERENCE5 = "maxAllowableDifference5";
	public static final String PE_REVIEW = "peReview";
	public static final String PG_BINDER_MASS = "pgBinderMass";
	public static final String TEST_CLOSED = "testClosed";
	public static final String LABNAME = "labname";
	public static final String SUBBIDITEM_ID = "subbiditemId";
	public static final String ACTIVE = "active";
	public static final String P_NUMBER = "pNumber";
	public static final String DATEOFTEST = "dateoftest";
	public static final String PASSFAIL = "passfail";
	public static final String ADDITIVE = "additive";
	public static final String TEMPERATURE_CORRECTION_FACTOR = "temperatureCorrectionFactor";
	public static final String SUBBIDITEM_DESCRIPT = "subbiditemDescript";
	public static final String PG_BINDER_JMF = "pgBinderJmf";
	public static final String AVG_PCT_PG_BINDER = "avgPctPgBinder";
	public static final String DIFFERENCE = "difference";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";
	public static final String SAMPLETEST_ID = "sampletestId";
	public static final String SPECIMEN_NO = "specimenNo";
	public static final String TEST_NO = "testNo";
	public static final String AGGREGATE_CORRECTION_FACTOR = "aggregateCorrectionFactor";
	public static final String SAMPLE_NO = "sampleNo";
	public static final String BIDITEM_NO = "biditemNo";
	public static final String LOWER_ENG_LIMIT = "lowerEngLimit";
	public static final String WBS_NO = "wbsNo";
	public static final String P_NAME = "pName";
	public static final String TEST_TIME = "testTime";
	public static final String BINDER_GRADE_ID = "binderGradeId";
	public static final String QA_SAMPLE_ID = "qaSampleId";
	public static final String UPPER_ENG_LIMIT = "upperEngLimit";
	public static final String CLIENT_ID = "clientId";
	public static final String QUANTITY = "quantity";
	public static final String BEGINNING_OVEN_WEIGHT = "beginningOvenWeight";
	public static final String MIX_DESIGN_NO = "mixDesignNo";
	public static final String EQUIP_LIST = "equipList";
	public static final String BIDITEM_DESCRIPT = "biditemDescript";
	public static final String ASPHALTCEMENT = "asphaltcement";
	public static final String BIDITEM_ID = "biditemId";
	public static final String WBS_ID = "wbsId";
	public static final String FAR_SUMMARY = "farSummary";
	public static final String TEST_ID = "testId";
	public static final String PCT_MOISTURE = "pctMoisture";
	public static final String TECH_ID = "techId";
	public static final String REMARKS = "remarks";

}
