package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DotMcD2216.class)
public abstract class DotMcD2216_ {

	public static volatile SingularAttribute<DotMcD2216, String> testResults;
	public static volatile SingularAttribute<DotMcD2216, String> wbsDescript;
	public static volatile SingularAttribute<DotMcD2216, String> sampleTcn;
	public static volatile SingularAttribute<DotMcD2216, String> traceNo;
	public static volatile SingularAttribute<DotMcD2216, String> dryWeight;
	public static volatile SingularAttribute<DotMcD2216, String> moistureContent;
	public static volatile SingularAttribute<DotMcD2216, String> cmLocation;
	public static volatile SingularAttribute<DotMcD2216, String> testingTech;
	public static volatile SingularAttribute<DotMcD2216, String> testNoLink;
	public static volatile SingularAttribute<DotMcD2216, BigDecimal> labId;
	public static volatile SingularAttribute<DotMcD2216, String> function;
	public static volatile SingularAttribute<DotMcD2216, BigDecimal> id;
	public static volatile SingularAttribute<DotMcD2216, BigDecimal> mixDesignId;
	public static volatile SingularAttribute<DotMcD2216, Character> peReview;
	public static volatile SingularAttribute<DotMcD2216, Character> testClosed;
	public static volatile SingularAttribute<DotMcD2216, String> labname;
	public static volatile SingularAttribute<DotMcD2216, BigInteger> subbiditemId;
	public static volatile SingularAttribute<DotMcD2216, Character> active;
	public static volatile SingularAttribute<DotMcD2216, String> passfail;
	public static volatile SingularAttribute<DotMcD2216, String> pNumber;
	public static volatile SingularAttribute<DotMcD2216, Date> dateoftest;
	public static volatile SingularAttribute<DotMcD2216, String> additive;
	public static volatile SingularAttribute<DotMcD2216, String> subbiditemDescript;
	public static volatile SingularAttribute<DotMcD2216, BigInteger> projectId;
	public static volatile SingularAttribute<DotMcD2216, String> status;
	public static volatile SingularAttribute<DotMcD2216, BigDecimal> sampletestId;
	public static volatile SingularAttribute<DotMcD2216, String> testNo;
	public static volatile SingularAttribute<DotMcD2216, String> sampleNo;
	public static volatile SingularAttribute<DotMcD2216, String> biditemNo;
	public static volatile SingularAttribute<DotMcD2216, String> wetWeight;
	public static volatile SingularAttribute<DotMcD2216, String> wbsNo;
	public static volatile SingularAttribute<DotMcD2216, String> pName;
	public static volatile SingularAttribute<DotMcD2216, String> waterWeight;
	public static volatile SingularAttribute<DotMcD2216, String> specMin;
	public static volatile SingularAttribute<DotMcD2216, BigInteger> binderGradeId;
	public static volatile SingularAttribute<DotMcD2216, String> specMax;
	public static volatile SingularAttribute<DotMcD2216, BigDecimal> qaSampleId;
	public static volatile SingularAttribute<DotMcD2216, BigInteger> quantity;
	public static volatile SingularAttribute<DotMcD2216, BigDecimal> clientId;
	public static volatile SingularAttribute<DotMcD2216, String> mixDesignNo;
	public static volatile SingularAttribute<DotMcD2216, String> biditemDescript;
	public static volatile SingularAttribute<DotMcD2216, String> equipList;
	public static volatile SingularAttribute<DotMcD2216, String> asphaltcement;
	public static volatile SingularAttribute<DotMcD2216, BigDecimal> biditemId;
	public static volatile SingularAttribute<DotMcD2216, BigInteger> wbsId;
	public static volatile SingularAttribute<DotMcD2216, String> farSummary;
	public static volatile SingularAttribute<DotMcD2216, BigDecimal> testId;
	public static volatile SingularAttribute<DotMcD2216, String> remarks;
	public static volatile SingularAttribute<DotMcD2216, String> techId;

	public static final String TEST_RESULTS = "testResults";
	public static final String WBS_DESCRIPT = "wbsDescript";
	public static final String SAMPLE_TCN = "sampleTcn";
	public static final String TRACE_NO = "traceNo";
	public static final String DRY_WEIGHT = "dryWeight";
	public static final String MOISTURE_CONTENT = "moistureContent";
	public static final String CM_LOCATION = "cmLocation";
	public static final String TESTING_TECH = "testingTech";
	public static final String TEST_NO_LINK = "testNoLink";
	public static final String LAB_ID = "labId";
	public static final String FUNCTION = "function";
	public static final String ID = "id";
	public static final String MIX_DESIGN_ID = "mixDesignId";
	public static final String PE_REVIEW = "peReview";
	public static final String TEST_CLOSED = "testClosed";
	public static final String LABNAME = "labname";
	public static final String SUBBIDITEM_ID = "subbiditemId";
	public static final String ACTIVE = "active";
	public static final String PASSFAIL = "passfail";
	public static final String P_NUMBER = "pNumber";
	public static final String DATEOFTEST = "dateoftest";
	public static final String ADDITIVE = "additive";
	public static final String SUBBIDITEM_DESCRIPT = "subbiditemDescript";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";
	public static final String SAMPLETEST_ID = "sampletestId";
	public static final String TEST_NO = "testNo";
	public static final String SAMPLE_NO = "sampleNo";
	public static final String BIDITEM_NO = "biditemNo";
	public static final String WET_WEIGHT = "wetWeight";
	public static final String WBS_NO = "wbsNo";
	public static final String P_NAME = "pName";
	public static final String WATER_WEIGHT = "waterWeight";
	public static final String SPEC_MIN = "specMin";
	public static final String BINDER_GRADE_ID = "binderGradeId";
	public static final String SPEC_MAX = "specMax";
	public static final String QA_SAMPLE_ID = "qaSampleId";
	public static final String QUANTITY = "quantity";
	public static final String CLIENT_ID = "clientId";
	public static final String MIX_DESIGN_NO = "mixDesignNo";
	public static final String BIDITEM_DESCRIPT = "biditemDescript";
	public static final String EQUIP_LIST = "equipList";
	public static final String ASPHALTCEMENT = "asphaltcement";
	public static final String BIDITEM_ID = "biditemId";
	public static final String WBS_ID = "wbsId";
	public static final String FAR_SUMMARY = "farSummary";
	public static final String TEST_ID = "testId";
	public static final String REMARKS = "remarks";
	public static final String TECH_ID = "techId";

}

