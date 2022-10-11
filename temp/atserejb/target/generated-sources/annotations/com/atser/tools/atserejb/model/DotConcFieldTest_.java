package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DotConcFieldTest.class)
public abstract class DotConcFieldTest_ {

	public static volatile SingularAttribute<DotConcFieldTest, String> testResults;
	public static volatile SingularAttribute<DotConcFieldTest, String> wbsDescript;
	public static volatile SingularAttribute<DotConcFieldTest, String> sampleTcn;
	public static volatile SingularAttribute<DotConcFieldTest, String> traceNo;
	public static volatile SingularAttribute<DotConcFieldTest, String> corrAircontent;
	public static volatile SingularAttribute<DotConcFieldTest, String> cmLocation;
	public static volatile SingularAttribute<DotConcFieldTest, String> aircontent;
	public static volatile SingularAttribute<DotConcFieldTest, String> testingTech;
	public static volatile SingularAttribute<DotConcFieldTest, BigInteger> labId;
	public static volatile SingularAttribute<DotConcFieldTest, String> function;
	public static volatile SingularAttribute<DotConcFieldTest, BigInteger> id;
	public static volatile SingularAttribute<DotConcFieldTest, BigInteger> mixDesignId;
	public static volatile SingularAttribute<DotConcFieldTest, String> peReview;
	public static volatile SingularAttribute<DotConcFieldTest, BigDecimal> reqAircontSpecMax;
	public static volatile SingularAttribute<DotConcFieldTest, String> testClosed;
	public static volatile SingularAttribute<DotConcFieldTest, String> labname;
	public static volatile SingularAttribute<DotConcFieldTest, BigInteger> subbiditemId;
	public static volatile SingularAttribute<DotConcFieldTest, String> active;
	public static volatile SingularAttribute<DotConcFieldTest, String> pNumber;
	public static volatile SingularAttribute<DotConcFieldTest, Date> dateoftest;
	public static volatile SingularAttribute<DotConcFieldTest, String> subbiditemDescript;
	public static volatile SingularAttribute<DotConcFieldTest, String> slumpSpecMin;
	public static volatile SingularAttribute<DotConcFieldTest, BigInteger> projectId;
	public static volatile SingularAttribute<DotConcFieldTest, String> status;
	public static volatile SingularAttribute<DotConcFieldTest, String> corrFactor;
	public static volatile SingularAttribute<DotConcFieldTest, String> testNo;
	public static volatile SingularAttribute<DotConcFieldTest, String> mixdesignno;
	public static volatile SingularAttribute<DotConcFieldTest, String> sampleNo;
	public static volatile SingularAttribute<DotConcFieldTest, String> slumpSpecMax;
	public static volatile SingularAttribute<DotConcFieldTest, String> slumpPassfail;
	public static volatile SingularAttribute<DotConcFieldTest, String> biditemNo;
	public static volatile SingularAttribute<DotConcFieldTest, String> wbsNo;
	public static volatile SingularAttribute<DotConcFieldTest, String> pName;
	public static volatile SingularAttribute<DotConcFieldTest, BigDecimal> reqAircontSpecMin;
	public static volatile SingularAttribute<DotConcFieldTest, String> slump;
	public static volatile SingularAttribute<DotConcFieldTest, BigInteger> qaSampleId;
	public static volatile SingularAttribute<DotConcFieldTest, String> tempSpecMin;
	public static volatile SingularAttribute<DotConcFieldTest, String> aircontentPassfail;
	public static volatile SingularAttribute<DotConcFieldTest, BigInteger> clientId;
	public static volatile SingularAttribute<DotConcFieldTest, Integer> quantity;
	public static volatile SingularAttribute<DotConcFieldTest, String> testno;
	public static volatile SingularAttribute<DotConcFieldTest, String> aircontentSpecMax;
	public static volatile SingularAttribute<DotConcFieldTest, String> tempPassfail;
	public static volatile SingularAttribute<DotConcFieldTest, String> mixTemperature;
	public static volatile SingularAttribute<DotConcFieldTest, String> aircontentSpecMin;
	public static volatile SingularAttribute<DotConcFieldTest, String> equipList;
	public static volatile SingularAttribute<DotConcFieldTest, String> biditemDescript;
	public static volatile SingularAttribute<DotConcFieldTest, String> thermometerNo;
	public static volatile SingularAttribute<DotConcFieldTest, BigInteger> biditemId;
	public static volatile SingularAttribute<DotConcFieldTest, String> tempSpecMax;
	public static volatile SingularAttribute<DotConcFieldTest, BigInteger> wbsId;
	public static volatile SingularAttribute<DotConcFieldTest, String> farSummary;
	public static volatile SingularAttribute<DotConcFieldTest, BigInteger> testId;
	public static volatile SingularAttribute<DotConcFieldTest, String> techId;
	public static volatile SingularAttribute<DotConcFieldTest, String> remarks;

	public static final String TEST_RESULTS = "testResults";
	public static final String WBS_DESCRIPT = "wbsDescript";
	public static final String SAMPLE_TCN = "sampleTcn";
	public static final String TRACE_NO = "traceNo";
	public static final String CORR_AIRCONTENT = "corrAircontent";
	public static final String CM_LOCATION = "cmLocation";
	public static final String AIRCONTENT = "aircontent";
	public static final String TESTING_TECH = "testingTech";
	public static final String LAB_ID = "labId";
	public static final String FUNCTION = "function";
	public static final String ID = "id";
	public static final String MIX_DESIGN_ID = "mixDesignId";
	public static final String PE_REVIEW = "peReview";
	public static final String REQ_AIRCONT_SPEC_MAX = "reqAircontSpecMax";
	public static final String TEST_CLOSED = "testClosed";
	public static final String LABNAME = "labname";
	public static final String SUBBIDITEM_ID = "subbiditemId";
	public static final String ACTIVE = "active";
	public static final String P_NUMBER = "pNumber";
	public static final String DATEOFTEST = "dateoftest";
	public static final String SUBBIDITEM_DESCRIPT = "subbiditemDescript";
	public static final String SLUMP_SPEC_MIN = "slumpSpecMin";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";
	public static final String CORR_FACTOR = "corrFactor";
	public static final String TEST_NO = "testNo";
	public static final String MIXDESIGNNO = "mixdesignno";
	public static final String SAMPLE_NO = "sampleNo";
	public static final String SLUMP_SPEC_MAX = "slumpSpecMax";
	public static final String SLUMP_PASSFAIL = "slumpPassfail";
	public static final String BIDITEM_NO = "biditemNo";
	public static final String WBS_NO = "wbsNo";
	public static final String P_NAME = "pName";
	public static final String REQ_AIRCONT_SPEC_MIN = "reqAircontSpecMin";
	public static final String SLUMP = "slump";
	public static final String QA_SAMPLE_ID = "qaSampleId";
	public static final String TEMP_SPEC_MIN = "tempSpecMin";
	public static final String AIRCONTENT_PASSFAIL = "aircontentPassfail";
	public static final String CLIENT_ID = "clientId";
	public static final String QUANTITY = "quantity";
	public static final String TESTNO = "testno";
	public static final String AIRCONTENT_SPEC_MAX = "aircontentSpecMax";
	public static final String TEMP_PASSFAIL = "tempPassfail";
	public static final String MIX_TEMPERATURE = "mixTemperature";
	public static final String AIRCONTENT_SPEC_MIN = "aircontentSpecMin";
	public static final String EQUIP_LIST = "equipList";
	public static final String BIDITEM_DESCRIPT = "biditemDescript";
	public static final String THERMOMETER_NO = "thermometerNo";
	public static final String BIDITEM_ID = "biditemId";
	public static final String TEMP_SPEC_MAX = "tempSpecMax";
	public static final String WBS_ID = "wbsId";
	public static final String FAR_SUMMARY = "farSummary";
	public static final String TEST_ID = "testId";
	public static final String TECH_ID = "techId";
	public static final String REMARKS = "remarks";

}
