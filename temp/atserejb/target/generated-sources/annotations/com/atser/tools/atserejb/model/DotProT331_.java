package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DotProT331.class)
public abstract class DotProT331_ {

	public static volatile SingularAttribute<DotProT331, String> testResults;
	public static volatile SingularAttribute<DotProT331, String> wbsDescript;
	public static volatile SingularAttribute<DotProT331, String> sampleTcn;
	public static volatile SingularAttribute<DotProT331, String> traceNo;
	public static volatile SingularAttribute<DotProT331, String> cmLocation;
	public static volatile SingularAttribute<DotProT331, String> testingTech;
	public static volatile SingularAttribute<DotProT331, String> testNoLink;
	public static volatile SingularAttribute<DotProT331, BigDecimal> labId;
	public static volatile SingularAttribute<DotProT331, String> function;
	public static volatile SingularAttribute<DotProT331, BigDecimal> id;
	public static volatile SingularAttribute<DotProT331, BigDecimal> mixDesignId;
	public static volatile SingularAttribute<DotProT331, String> doubleBagLimit;
	public static volatile SingularAttribute<DotProT331, Character> peReview;
	public static volatile SingularAttribute<DotProT331, String> sealedSampleWtInWater;
	public static volatile SingularAttribute<DotProT331, Character> testClosed;
	public static volatile SingularAttribute<DotProT331, String> labname;
	public static volatile SingularAttribute<DotProT331, BigInteger> subbiditemId;
	public static volatile SingularAttribute<DotProT331, Character> active;
	public static volatile SingularAttribute<DotProT331, String> pNumber;
	public static volatile SingularAttribute<DotProT331, Date> dateoftest;
	public static volatile SingularAttribute<DotProT331, String> additive;
	public static volatile SingularAttribute<DotProT331, String> subbiditemDescript;
	public static volatile SingularAttribute<DotProT331, BigInteger> projectId;
	public static volatile SingularAttribute<DotProT331, String> status;
	public static volatile SingularAttribute<DotProT331, BigDecimal> sampletestId;
	public static volatile SingularAttribute<DotProT331, String> avgBulkspecgrav;
	public static volatile SingularAttribute<DotProT331, String> specimenNo;
	public static volatile SingularAttribute<DotProT331, String> testNo;
	public static volatile SingularAttribute<DotProT331, String> sampleNo;
	public static volatile SingularAttribute<DotProT331, String> biditemNo;
	public static volatile SingularAttribute<DotProT331, String> wbsNo;
	public static volatile SingularAttribute<DotProT331, String> pName;
	public static volatile SingularAttribute<DotProT331, String> bulkspecgrav;
	public static volatile SingularAttribute<DotProT331, String> drySampleWtBeforeSealing;
	public static volatile SingularAttribute<DotProT331, String> sampleWtAfterWaterSubmers;
	public static volatile SingularAttribute<DotProT331, String> avgPorosity;
	public static volatile SingularAttribute<DotProT331, BigInteger> binderGradeId;
	public static volatile SingularAttribute<DotProT331, BigDecimal> qaSampleId;
	public static volatile SingularAttribute<DotProT331, BigDecimal> clientId;
	public static volatile SingularAttribute<DotProT331, BigInteger> quantity;
	public static volatile SingularAttribute<DotProT331, String> porosity;
	public static volatile SingularAttribute<DotProT331, String> mixDesignNo;
	public static volatile SingularAttribute<DotProT331, String> equipList;
	public static volatile SingularAttribute<DotProT331, String> biditemDescript;
	public static volatile SingularAttribute<DotProT331, String> asphaltcement;
	public static volatile SingularAttribute<DotProT331, BigDecimal> biditemId;
	public static volatile SingularAttribute<DotProT331, BigInteger> wbsId;
	public static volatile SingularAttribute<DotProT331, String> testMethod;
	public static volatile SingularAttribute<DotProT331, String> farSummary;
	public static volatile SingularAttribute<DotProT331, BigDecimal> testId;
	public static volatile SingularAttribute<DotProT331, String> bagWeight;
	public static volatile SingularAttribute<DotProT331, String> techId;
	public static volatile SingularAttribute<DotProT331, String> remarks;

	public static final String TEST_RESULTS = "testResults";
	public static final String WBS_DESCRIPT = "wbsDescript";
	public static final String SAMPLE_TCN = "sampleTcn";
	public static final String TRACE_NO = "traceNo";
	public static final String CM_LOCATION = "cmLocation";
	public static final String TESTING_TECH = "testingTech";
	public static final String TEST_NO_LINK = "testNoLink";
	public static final String LAB_ID = "labId";
	public static final String FUNCTION = "function";
	public static final String ID = "id";
	public static final String MIX_DESIGN_ID = "mixDesignId";
	public static final String DOUBLE_BAG_LIMIT = "doubleBagLimit";
	public static final String PE_REVIEW = "peReview";
	public static final String SEALED_SAMPLE_WT_IN_WATER = "sealedSampleWtInWater";
	public static final String TEST_CLOSED = "testClosed";
	public static final String LABNAME = "labname";
	public static final String SUBBIDITEM_ID = "subbiditemId";
	public static final String ACTIVE = "active";
	public static final String P_NUMBER = "pNumber";
	public static final String DATEOFTEST = "dateoftest";
	public static final String ADDITIVE = "additive";
	public static final String SUBBIDITEM_DESCRIPT = "subbiditemDescript";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";
	public static final String SAMPLETEST_ID = "sampletestId";
	public static final String AVG_BULKSPECGRAV = "avgBulkspecgrav";
	public static final String SPECIMEN_NO = "specimenNo";
	public static final String TEST_NO = "testNo";
	public static final String SAMPLE_NO = "sampleNo";
	public static final String BIDITEM_NO = "biditemNo";
	public static final String WBS_NO = "wbsNo";
	public static final String P_NAME = "pName";
	public static final String BULKSPECGRAV = "bulkspecgrav";
	public static final String DRY_SAMPLE_WT_BEFORE_SEALING = "drySampleWtBeforeSealing";
	public static final String SAMPLE_WT_AFTER_WATER_SUBMERS = "sampleWtAfterWaterSubmers";
	public static final String AVG_POROSITY = "avgPorosity";
	public static final String BINDER_GRADE_ID = "binderGradeId";
	public static final String QA_SAMPLE_ID = "qaSampleId";
	public static final String CLIENT_ID = "clientId";
	public static final String QUANTITY = "quantity";
	public static final String POROSITY = "porosity";
	public static final String MIX_DESIGN_NO = "mixDesignNo";
	public static final String EQUIP_LIST = "equipList";
	public static final String BIDITEM_DESCRIPT = "biditemDescript";
	public static final String ASPHALTCEMENT = "asphaltcement";
	public static final String BIDITEM_ID = "biditemId";
	public static final String WBS_ID = "wbsId";
	public static final String TEST_METHOD = "testMethod";
	public static final String FAR_SUMMARY = "farSummary";
	public static final String TEST_ID = "testId";
	public static final String BAG_WEIGHT = "bagWeight";
	public static final String TECH_ID = "techId";
	public static final String REMARKS = "remarks";

}

