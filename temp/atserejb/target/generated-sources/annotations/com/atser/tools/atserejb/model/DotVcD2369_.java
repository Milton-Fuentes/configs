package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DotVcD2369.class)
public abstract class DotVcD2369_ {

	public static volatile SingularAttribute<DotVcD2369, String> testResults;
	public static volatile SingularAttribute<DotVcD2369, String> wbsDescript;
	public static volatile SingularAttribute<DotVcD2369, String> sampleTcn;
	public static volatile SingularAttribute<DotVcD2369, String> averagePctSolids;
	public static volatile SingularAttribute<DotVcD2369, String> traceNo;
	public static volatile SingularAttribute<DotVcD2369, String> duplicateSpecimenWeight;
	public static volatile SingularAttribute<DotVcD2369, String> cmLocation;
	public static volatile SingularAttribute<DotVcD2369, String> testingTech;
	public static volatile SingularAttribute<DotVcD2369, String> testNoLink;
	public static volatile SingularAttribute<DotVcD2369, BigDecimal> labId;
	public static volatile SingularAttribute<DotVcD2369, String> function;
	public static volatile SingularAttribute<DotVcD2369, BigDecimal> id;
	public static volatile SingularAttribute<DotVcD2369, BigDecimal> mixDesignId;
	public static volatile SingularAttribute<DotVcD2369, Character> peReview;
	public static volatile SingularAttribute<DotVcD2369, Character> testClosed;
	public static volatile SingularAttribute<DotVcD2369, String> labname;
	public static volatile SingularAttribute<DotVcD2369, BigInteger> subbiditemId;
	public static volatile SingularAttribute<DotVcD2369, String> initialPctSolids;
	public static volatile SingularAttribute<DotVcD2369, Character> active;
	public static volatile SingularAttribute<DotVcD2369, String> passfail;
	public static volatile SingularAttribute<DotVcD2369, String> pNumber;
	public static volatile SingularAttribute<DotVcD2369, Date> dateoftest;
	public static volatile SingularAttribute<DotVcD2369, String> additive;
	public static volatile SingularAttribute<DotVcD2369, String> subbiditemDescript;
	public static volatile SingularAttribute<DotVcD2369, String> duplicateWtDishPlusSpec;
	public static volatile SingularAttribute<DotVcD2369, BigInteger> projectId;
	public static volatile SingularAttribute<DotVcD2369, String> status;
	public static volatile SingularAttribute<DotVcD2369, String> initialSpecimenWeight;
	public static volatile SingularAttribute<DotVcD2369, BigDecimal> sampletestId;
	public static volatile SingularAttribute<DotVcD2369, String> testNo;
	public static volatile SingularAttribute<DotVcD2369, String> sampleNo;
	public static volatile SingularAttribute<DotVcD2369, String> duplicateWtDish;
	public static volatile SingularAttribute<DotVcD2369, String> biditemNo;
	public static volatile SingularAttribute<DotVcD2369, String> wbsNo;
	public static volatile SingularAttribute<DotVcD2369, String> pName;
	public static volatile SingularAttribute<DotVcD2369, String> duplicatePctSolids;
	public static volatile SingularAttribute<DotVcD2369, String> specMin;
	public static volatile SingularAttribute<DotVcD2369, String> initialWtDish;
	public static volatile SingularAttribute<DotVcD2369, BigInteger> binderGradeId;
	public static volatile SingularAttribute<DotVcD2369, String> specMax;
	public static volatile SingularAttribute<DotVcD2369, BigDecimal> qaSampleId;
	public static volatile SingularAttribute<DotVcD2369, BigDecimal> clientId;
	public static volatile SingularAttribute<DotVcD2369, BigInteger> quantity;
	public static volatile SingularAttribute<DotVcD2369, String> mixDesignNo;
	public static volatile SingularAttribute<DotVcD2369, String> equipList;
	public static volatile SingularAttribute<DotVcD2369, String> biditemDescript;
	public static volatile SingularAttribute<DotVcD2369, String> asphaltcement;
	public static volatile SingularAttribute<DotVcD2369, BigDecimal> biditemId;
	public static volatile SingularAttribute<DotVcD2369, BigInteger> wbsId;
	public static volatile SingularAttribute<DotVcD2369, String> farSummary;
	public static volatile SingularAttribute<DotVcD2369, BigDecimal> testId;
	public static volatile SingularAttribute<DotVcD2369, String> initialWtDishPlusSpec;
	public static volatile SingularAttribute<DotVcD2369, String> remarks;
	public static volatile SingularAttribute<DotVcD2369, String> techId;

	public static final String TEST_RESULTS = "testResults";
	public static final String WBS_DESCRIPT = "wbsDescript";
	public static final String SAMPLE_TCN = "sampleTcn";
	public static final String AVERAGE_PCT_SOLIDS = "averagePctSolids";
	public static final String TRACE_NO = "traceNo";
	public static final String DUPLICATE_SPECIMEN_WEIGHT = "duplicateSpecimenWeight";
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
	public static final String INITIAL_PCT_SOLIDS = "initialPctSolids";
	public static final String ACTIVE = "active";
	public static final String PASSFAIL = "passfail";
	public static final String P_NUMBER = "pNumber";
	public static final String DATEOFTEST = "dateoftest";
	public static final String ADDITIVE = "additive";
	public static final String SUBBIDITEM_DESCRIPT = "subbiditemDescript";
	public static final String DUPLICATE_WT_DISH_PLUS_SPEC = "duplicateWtDishPlusSpec";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";
	public static final String INITIAL_SPECIMEN_WEIGHT = "initialSpecimenWeight";
	public static final String SAMPLETEST_ID = "sampletestId";
	public static final String TEST_NO = "testNo";
	public static final String SAMPLE_NO = "sampleNo";
	public static final String DUPLICATE_WT_DISH = "duplicateWtDish";
	public static final String BIDITEM_NO = "biditemNo";
	public static final String WBS_NO = "wbsNo";
	public static final String P_NAME = "pName";
	public static final String DUPLICATE_PCT_SOLIDS = "duplicatePctSolids";
	public static final String SPEC_MIN = "specMin";
	public static final String INITIAL_WT_DISH = "initialWtDish";
	public static final String BINDER_GRADE_ID = "binderGradeId";
	public static final String SPEC_MAX = "specMax";
	public static final String QA_SAMPLE_ID = "qaSampleId";
	public static final String CLIENT_ID = "clientId";
	public static final String QUANTITY = "quantity";
	public static final String MIX_DESIGN_NO = "mixDesignNo";
	public static final String EQUIP_LIST = "equipList";
	public static final String BIDITEM_DESCRIPT = "biditemDescript";
	public static final String ASPHALTCEMENT = "asphaltcement";
	public static final String BIDITEM_ID = "biditemId";
	public static final String WBS_ID = "wbsId";
	public static final String FAR_SUMMARY = "farSummary";
	public static final String TEST_ID = "testId";
	public static final String INITIAL_WT_DISH_PLUS_SPEC = "initialWtDishPlusSpec";
	public static final String REMARKS = "remarks";
	public static final String TECH_ID = "techId";

}

