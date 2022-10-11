package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DotSoildenT310.class)
public abstract class DotSoildenT310_ {

	public static volatile SingularAttribute<DotSoildenT310, String> testResults;
	public static volatile SingularAttribute<DotSoildenT310, String> wbsDescript;
	public static volatile SingularAttribute<DotSoildenT310, String> compspec;
	public static volatile SingularAttribute<DotSoildenT310, String> compspecMax;
	public static volatile SingularAttribute<DotSoildenT310, String> sampleTcn;
	public static volatile SingularAttribute<DotSoildenT310, String> testLocation;
	public static volatile SingularAttribute<DotSoildenT310, String> traceNo;
	public static volatile SingularAttribute<DotSoildenT310, String> dateCalibration;
	public static volatile SingularAttribute<DotSoildenT310, String> cmLocation;
	public static volatile SingularAttribute<DotSoildenT310, String> stdctmoisture;
	public static volatile SingularAttribute<DotSoildenT310, String> testingTech;
	public static volatile SingularAttribute<DotSoildenT310, String> testNoLink;
	public static volatile SingularAttribute<DotSoildenT310, BigDecimal> labId;
	public static volatile SingularAttribute<DotSoildenT310, String> function;
	public static volatile SingularAttribute<DotSoildenT310, String> testOffset;
	public static volatile SingularAttribute<DotSoildenT310, BigDecimal> id;
	public static volatile SingularAttribute<DotSoildenT310, BigDecimal> mixDesignId;
	public static volatile SingularAttribute<DotSoildenT310, String> testDuration;
	public static volatile SingularAttribute<DotSoildenT310, Character> peReview;
	public static volatile SingularAttribute<DotSoildenT310, Character> testClosed;
	public static volatile SingularAttribute<DotSoildenT310, String> labname;
	public static volatile SingularAttribute<DotSoildenT310, BigInteger> subbiditemId;
	public static volatile SingularAttribute<DotSoildenT310, Character> active;
	public static volatile SingularAttribute<DotSoildenT310, String> testinstr;
	public static volatile SingularAttribute<DotSoildenT310, String> passfail;
	public static volatile SingularAttribute<DotSoildenT310, String> pNumber;
	public static volatile SingularAttribute<DotSoildenT310, Date> dateoftest;
	public static volatile SingularAttribute<DotSoildenT310, String> additive;
	public static volatile SingularAttribute<DotSoildenT310, String> maxdrydensity;
	public static volatile SingularAttribute<DotSoildenT310, String> subbiditemDescript;
	public static volatile SingularAttribute<DotSoildenT310, BigInteger> projectId;
	public static volatile SingularAttribute<DotSoildenT310, String> stdctdensity;
	public static volatile SingularAttribute<DotSoildenT310, String> status;
	public static volatile SingularAttribute<DotSoildenT310, BigDecimal> sampletestId;
	public static volatile SingularAttribute<DotSoildenT310, String> genTestloc;
	public static volatile SingularAttribute<DotSoildenT310, String> testNo;
	public static volatile SingularAttribute<DotSoildenT310, String> fieldTestNo;
	public static volatile SingularAttribute<DotSoildenT310, String> testStation;
	public static volatile SingularAttribute<DotSoildenT310, String> optmoisture;
	public static volatile SingularAttribute<DotSoildenT310, String> elevdepth;
	public static volatile SingularAttribute<DotSoildenT310, String> sampleNo;
	public static volatile SingularAttribute<DotSoildenT310, String> biditemNo;
	public static volatile SingularAttribute<DotSoildenT310, String> serialno;
	public static volatile SingularAttribute<DotSoildenT310, String> wbsNo;
	public static volatile SingularAttribute<DotSoildenT310, String> gaugeNo;
	public static volatile SingularAttribute<DotSoildenT310, String> pName;
	public static volatile SingularAttribute<DotSoildenT310, String> materialdesc;
	public static volatile SingularAttribute<DotSoildenT310, String> compaction;
	public static volatile SingularAttribute<DotSoildenT310, BigInteger> binderGradeId;
	public static volatile SingularAttribute<DotSoildenT310, BigDecimal> qaSampleId;
	public static volatile SingularAttribute<DotSoildenT310, String> moisturecontent;
	public static volatile SingularAttribute<DotSoildenT310, BigDecimal> clientId;
	public static volatile SingularAttribute<DotSoildenT310, String> proctorNo;
	public static volatile SingularAttribute<DotSoildenT310, String> targetLiftThickness;
	public static volatile SingularAttribute<DotSoildenT310, String> mixDesignNo;
	public static volatile SingularAttribute<DotSoildenT310, String> equipList;
	public static volatile SingularAttribute<DotSoildenT310, String> biditemDescript;
	public static volatile SingularAttribute<DotSoildenT310, String> asphaltcement;
	public static volatile SingularAttribute<DotSoildenT310, BigDecimal> biditemId;
	public static volatile SingularAttribute<DotSoildenT310, String> testtype;
	public static volatile SingularAttribute<DotSoildenT310, BigInteger> wbsId;
	public static volatile SingularAttribute<DotSoildenT310, String> drydensity;
	public static volatile SingularAttribute<DotSoildenT310, String> wetdensity;
	public static volatile SingularAttribute<DotSoildenT310, BigDecimal> testId;
	public static volatile SingularAttribute<DotSoildenT310, String> gaugeModelNo;
	public static volatile SingularAttribute<DotSoildenT310, String> remarks;
	public static volatile SingularAttribute<DotSoildenT310, String> techId;

	public static final String TEST_RESULTS = "testResults";
	public static final String WBS_DESCRIPT = "wbsDescript";
	public static final String COMPSPEC = "compspec";
	public static final String COMPSPEC_MAX = "compspecMax";
	public static final String SAMPLE_TCN = "sampleTcn";
	public static final String TEST_LOCATION = "testLocation";
	public static final String TRACE_NO = "traceNo";
	public static final String DATE_CALIBRATION = "dateCalibration";
	public static final String CM_LOCATION = "cmLocation";
	public static final String STDCTMOISTURE = "stdctmoisture";
	public static final String TESTING_TECH = "testingTech";
	public static final String TEST_NO_LINK = "testNoLink";
	public static final String LAB_ID = "labId";
	public static final String FUNCTION = "function";
	public static final String TEST_OFFSET = "testOffset";
	public static final String ID = "id";
	public static final String MIX_DESIGN_ID = "mixDesignId";
	public static final String TEST_DURATION = "testDuration";
	public static final String PE_REVIEW = "peReview";
	public static final String TEST_CLOSED = "testClosed";
	public static final String LABNAME = "labname";
	public static final String SUBBIDITEM_ID = "subbiditemId";
	public static final String ACTIVE = "active";
	public static final String TESTINSTR = "testinstr";
	public static final String PASSFAIL = "passfail";
	public static final String P_NUMBER = "pNumber";
	public static final String DATEOFTEST = "dateoftest";
	public static final String ADDITIVE = "additive";
	public static final String MAXDRYDENSITY = "maxdrydensity";
	public static final String SUBBIDITEM_DESCRIPT = "subbiditemDescript";
	public static final String PROJECT_ID = "projectId";
	public static final String STDCTDENSITY = "stdctdensity";
	public static final String STATUS = "status";
	public static final String SAMPLETEST_ID = "sampletestId";
	public static final String GEN_TESTLOC = "genTestloc";
	public static final String TEST_NO = "testNo";
	public static final String FIELD_TEST_NO = "fieldTestNo";
	public static final String TEST_STATION = "testStation";
	public static final String OPTMOISTURE = "optmoisture";
	public static final String ELEVDEPTH = "elevdepth";
	public static final String SAMPLE_NO = "sampleNo";
	public static final String BIDITEM_NO = "biditemNo";
	public static final String SERIALNO = "serialno";
	public static final String WBS_NO = "wbsNo";
	public static final String GAUGE_NO = "gaugeNo";
	public static final String P_NAME = "pName";
	public static final String MATERIALDESC = "materialdesc";
	public static final String COMPACTION = "compaction";
	public static final String BINDER_GRADE_ID = "binderGradeId";
	public static final String QA_SAMPLE_ID = "qaSampleId";
	public static final String MOISTURECONTENT = "moisturecontent";
	public static final String CLIENT_ID = "clientId";
	public static final String PROCTOR_NO = "proctorNo";
	public static final String TARGET_LIFT_THICKNESS = "targetLiftThickness";
	public static final String MIX_DESIGN_NO = "mixDesignNo";
	public static final String EQUIP_LIST = "equipList";
	public static final String BIDITEM_DESCRIPT = "biditemDescript";
	public static final String ASPHALTCEMENT = "asphaltcement";
	public static final String BIDITEM_ID = "biditemId";
	public static final String TESTTYPE = "testtype";
	public static final String WBS_ID = "wbsId";
	public static final String DRYDENSITY = "drydensity";
	public static final String WETDENSITY = "wetdensity";
	public static final String TEST_ID = "testId";
	public static final String GAUGE_MODEL_NO = "gaugeModelNo";
	public static final String REMARKS = "remarks";
	public static final String TECH_ID = "techId";

}

