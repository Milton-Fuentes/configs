package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DotTshcT131.class)
public abstract class DotTshcT131_ {

	public static volatile SingularAttribute<DotTshcT131, String> testResults;
	public static volatile SingularAttribute<DotTshcT131, String> wbsDescript;
	public static volatile SingularAttribute<DotTshcT131, String> sampleTcn;
	public static volatile SingularAttribute<DotTshcT131, String> traceNo;
	public static volatile SingularAttribute<DotTshcT131, String> cmLocation;
	public static volatile SingularAttribute<DotTshcT131, String> testingTech;
	public static volatile SingularAttribute<DotTshcT131, String> penetLastReading;
	public static volatile SingularAttribute<DotTshcT131, String> testNoLink;
	public static volatile SingularAttribute<DotTshcT131, BigDecimal> labId;
	public static volatile SingularAttribute<DotTshcT131, String> function;
	public static volatile SingularAttribute<DotTshcT131, String> timeFirstPenetration;
	public static volatile SingularAttribute<DotTshcT131, String> penetFirstReading;
	public static volatile SingularAttribute<DotTshcT131, BigDecimal> id;
	public static volatile SingularAttribute<DotTshcT131, BigDecimal> mixDesignId;
	public static volatile SingularAttribute<DotTshcT131, Character> peReview;
	public static volatile SingularAttribute<DotTshcT131, Character> testClosed;
	public static volatile SingularAttribute<DotTshcT131, BigInteger> subbiditemId;
	public static volatile SingularAttribute<DotTshcT131, String> labname;
	public static volatile SingularAttribute<DotTshcT131, Character> active;
	public static volatile SingularAttribute<DotTshcT131, String> passfail;
	public static volatile SingularAttribute<DotTshcT131, String> pNumber;
	public static volatile SingularAttribute<DotTshcT131, Date> dateoftest;
	public static volatile SingularAttribute<DotTshcT131, String> additive;
	public static volatile SingularAttribute<DotTshcT131, String> subbiditemDescript;
	public static volatile SingularAttribute<DotTshcT131, BigInteger> projectId;
	public static volatile SingularAttribute<DotTshcT131, String> status;
	public static volatile SingularAttribute<DotTshcT131, BigDecimal> sampletestId;
	public static volatile SingularAttribute<DotTshcT131, String> timeLastPenetration;
	public static volatile SingularAttribute<DotTshcT131, String> specimenNo;
	public static volatile SingularAttribute<DotTshcT131, String> testNo;
	public static volatile SingularAttribute<DotTshcT131, String> sampleNo;
	public static volatile SingularAttribute<DotTshcT131, String> biditemNo;
	public static volatile SingularAttribute<DotTshcT131, String> wbsNo;
	public static volatile SingularAttribute<DotTshcT131, String> pName;
	public static volatile SingularAttribute<DotTshcT131, String> vicatFinalTimeSetting;
	public static volatile SingularAttribute<DotTshcT131, String> specMin;
	public static volatile SingularAttribute<DotTshcT131, String> vicatTimeSetting;
	public static volatile SingularAttribute<DotTshcT131, BigInteger> binderGradeId;
	public static volatile SingularAttribute<DotTshcT131, String> specMax;
	public static volatile SingularAttribute<DotTshcT131, BigDecimal> qaSampleId;
	public static volatile SingularAttribute<DotTshcT131, BigDecimal> clientId;
	public static volatile SingularAttribute<DotTshcT131, String> mixDesignNo;
	public static volatile SingularAttribute<DotTshcT131, String> biditemDescript;
	public static volatile SingularAttribute<DotTshcT131, String> equipList;
	public static volatile SingularAttribute<DotTshcT131, BigDecimal> biditemId;
	public static volatile SingularAttribute<DotTshcT131, String> asphaltcement;
	public static volatile SingularAttribute<DotTshcT131, BigInteger> wbsId;
	public static volatile SingularAttribute<DotTshcT131, BigDecimal> testId;
	public static volatile SingularAttribute<DotTshcT131, String> remarks;
	public static volatile SingularAttribute<DotTshcT131, String> techId;

	public static final String TEST_RESULTS = "testResults";
	public static final String WBS_DESCRIPT = "wbsDescript";
	public static final String SAMPLE_TCN = "sampleTcn";
	public static final String TRACE_NO = "traceNo";
	public static final String CM_LOCATION = "cmLocation";
	public static final String TESTING_TECH = "testingTech";
	public static final String PENET_LAST_READING = "penetLastReading";
	public static final String TEST_NO_LINK = "testNoLink";
	public static final String LAB_ID = "labId";
	public static final String FUNCTION = "function";
	public static final String TIME_FIRST_PENETRATION = "timeFirstPenetration";
	public static final String PENET_FIRST_READING = "penetFirstReading";
	public static final String ID = "id";
	public static final String MIX_DESIGN_ID = "mixDesignId";
	public static final String PE_REVIEW = "peReview";
	public static final String TEST_CLOSED = "testClosed";
	public static final String SUBBIDITEM_ID = "subbiditemId";
	public static final String LABNAME = "labname";
	public static final String ACTIVE = "active";
	public static final String PASSFAIL = "passfail";
	public static final String P_NUMBER = "pNumber";
	public static final String DATEOFTEST = "dateoftest";
	public static final String ADDITIVE = "additive";
	public static final String SUBBIDITEM_DESCRIPT = "subbiditemDescript";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";
	public static final String SAMPLETEST_ID = "sampletestId";
	public static final String TIME_LAST_PENETRATION = "timeLastPenetration";
	public static final String SPECIMEN_NO = "specimenNo";
	public static final String TEST_NO = "testNo";
	public static final String SAMPLE_NO = "sampleNo";
	public static final String BIDITEM_NO = "biditemNo";
	public static final String WBS_NO = "wbsNo";
	public static final String P_NAME = "pName";
	public static final String VICAT_FINAL_TIME_SETTING = "vicatFinalTimeSetting";
	public static final String SPEC_MIN = "specMin";
	public static final String VICAT_TIME_SETTING = "vicatTimeSetting";
	public static final String BINDER_GRADE_ID = "binderGradeId";
	public static final String SPEC_MAX = "specMax";
	public static final String QA_SAMPLE_ID = "qaSampleId";
	public static final String CLIENT_ID = "clientId";
	public static final String MIX_DESIGN_NO = "mixDesignNo";
	public static final String BIDITEM_DESCRIPT = "biditemDescript";
	public static final String EQUIP_LIST = "equipList";
	public static final String BIDITEM_ID = "biditemId";
	public static final String ASPHALTCEMENT = "asphaltcement";
	public static final String WBS_ID = "wbsId";
	public static final String TEST_ID = "testId";
	public static final String REMARKS = "remarks";
	public static final String TECH_ID = "techId";

}

