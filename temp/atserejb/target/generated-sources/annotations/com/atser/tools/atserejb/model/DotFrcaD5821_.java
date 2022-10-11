package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DotFrcaD5821.class)
public abstract class DotFrcaD5821_ {

	public static volatile SingularAttribute<DotFrcaD5821, String> testResults;
	public static volatile SingularAttribute<DotFrcaD5821, String> wbsDescript;
	public static volatile SingularAttribute<DotFrcaD5821, String> sampleTcn;
	public static volatile SingularAttribute<DotFrcaD5821, String> traceNo;
	public static volatile SingularAttribute<DotFrcaD5821, String> cmLocation;
	public static volatile SingularAttribute<DotFrcaD5821, String> totalMassCoarseAgg;
	public static volatile SingularAttribute<DotFrcaD5821, String> testingTech;
	public static volatile SingularAttribute<DotFrcaD5821, String> testNoLink;
	public static volatile SingularAttribute<DotFrcaD5821, BigDecimal> labId;
	public static volatile SingularAttribute<DotFrcaD5821, String> function;
	public static volatile SingularAttribute<DotFrcaD5821, BigDecimal> id;
	public static volatile SingularAttribute<DotFrcaD5821, BigDecimal> mixDesignId;
	public static volatile SingularAttribute<DotFrcaD5821, Character> peReview;
	public static volatile SingularAttribute<DotFrcaD5821, String> method;
	public static volatile SingularAttribute<DotFrcaD5821, Character> testClosed;
	public static volatile SingularAttribute<DotFrcaD5821, String> labname;
	public static volatile SingularAttribute<DotFrcaD5821, BigInteger> subbiditemId;
	public static volatile SingularAttribute<DotFrcaD5821, Character> active;
	public static volatile SingularAttribute<DotFrcaD5821, String> wtCrushedParticles;
	public static volatile SingularAttribute<DotFrcaD5821, String> pNumber;
	public static volatile SingularAttribute<DotFrcaD5821, Date> dateoftest;
	public static volatile SingularAttribute<DotFrcaD5821, Character> passfail;
	public static volatile SingularAttribute<DotFrcaD5821, String> additive;
	public static volatile SingularAttribute<DotFrcaD5821, String> subbiditemDescript;
	public static volatile SingularAttribute<DotFrcaD5821, String> usedSieveNo;
	public static volatile SingularAttribute<DotFrcaD5821, BigInteger> projectId;
	public static volatile SingularAttribute<DotFrcaD5821, String> status;
	public static volatile SingularAttribute<DotFrcaD5821, BigDecimal> sampletestId;
	public static volatile SingularAttribute<DotFrcaD5821, String> specimenNo;
	public static volatile SingularAttribute<DotFrcaD5821, String> testNo;
	public static volatile SingularAttribute<DotFrcaD5821, String> sampleNo;
	public static volatile SingularAttribute<DotFrcaD5821, String> biditemNo;
	public static volatile SingularAttribute<DotFrcaD5821, String> wbsNo;
	public static volatile SingularAttribute<DotFrcaD5821, String> pName;
	public static volatile SingularAttribute<DotFrcaD5821, String> pctParticles;
	public static volatile SingularAttribute<DotFrcaD5821, BigInteger> binderGradeId;
	public static volatile SingularAttribute<DotFrcaD5821, BigDecimal> qaSampleId;
	public static volatile SingularAttribute<DotFrcaD5821, BigDecimal> clientId;
	public static volatile SingularAttribute<DotFrcaD5821, BigInteger> quantity;
	public static volatile SingularAttribute<DotFrcaD5821, String> wtUncrushedParticles;
	public static volatile SingularAttribute<DotFrcaD5821, String> mixDesignNo;
	public static volatile SingularAttribute<DotFrcaD5821, String> equipList;
	public static volatile SingularAttribute<DotFrcaD5821, String> biditemDescript;
	public static volatile SingularAttribute<DotFrcaD5821, String> asphaltcement;
	public static volatile SingularAttribute<DotFrcaD5821, BigDecimal> biditemId;
	public static volatile SingularAttribute<DotFrcaD5821, BigInteger> wbsId;
	public static volatile SingularAttribute<DotFrcaD5821, String> farSummary;
	public static volatile SingularAttribute<DotFrcaD5821, BigDecimal> testId;
	public static volatile SingularAttribute<DotFrcaD5821, String> techId;
	public static volatile SingularAttribute<DotFrcaD5821, String> remarks;

	public static final String TEST_RESULTS = "testResults";
	public static final String WBS_DESCRIPT = "wbsDescript";
	public static final String SAMPLE_TCN = "sampleTcn";
	public static final String TRACE_NO = "traceNo";
	public static final String CM_LOCATION = "cmLocation";
	public static final String TOTAL_MASS_COARSE_AGG = "totalMassCoarseAgg";
	public static final String TESTING_TECH = "testingTech";
	public static final String TEST_NO_LINK = "testNoLink";
	public static final String LAB_ID = "labId";
	public static final String FUNCTION = "function";
	public static final String ID = "id";
	public static final String MIX_DESIGN_ID = "mixDesignId";
	public static final String PE_REVIEW = "peReview";
	public static final String METHOD = "method";
	public static final String TEST_CLOSED = "testClosed";
	public static final String LABNAME = "labname";
	public static final String SUBBIDITEM_ID = "subbiditemId";
	public static final String ACTIVE = "active";
	public static final String WT_CRUSHED_PARTICLES = "wtCrushedParticles";
	public static final String P_NUMBER = "pNumber";
	public static final String DATEOFTEST = "dateoftest";
	public static final String PASSFAIL = "passfail";
	public static final String ADDITIVE = "additive";
	public static final String SUBBIDITEM_DESCRIPT = "subbiditemDescript";
	public static final String USED_SIEVE_NO = "usedSieveNo";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";
	public static final String SAMPLETEST_ID = "sampletestId";
	public static final String SPECIMEN_NO = "specimenNo";
	public static final String TEST_NO = "testNo";
	public static final String SAMPLE_NO = "sampleNo";
	public static final String BIDITEM_NO = "biditemNo";
	public static final String WBS_NO = "wbsNo";
	public static final String P_NAME = "pName";
	public static final String PCT_PARTICLES = "pctParticles";
	public static final String BINDER_GRADE_ID = "binderGradeId";
	public static final String QA_SAMPLE_ID = "qaSampleId";
	public static final String CLIENT_ID = "clientId";
	public static final String QUANTITY = "quantity";
	public static final String WT_UNCRUSHED_PARTICLES = "wtUncrushedParticles";
	public static final String MIX_DESIGN_NO = "mixDesignNo";
	public static final String EQUIP_LIST = "equipList";
	public static final String BIDITEM_DESCRIPT = "biditemDescript";
	public static final String ASPHALTCEMENT = "asphaltcement";
	public static final String BIDITEM_ID = "biditemId";
	public static final String WBS_ID = "wbsId";
	public static final String FAR_SUMMARY = "farSummary";
	public static final String TEST_ID = "testId";
	public static final String TECH_ID = "techId";
	public static final String REMARKS = "remarks";

}

