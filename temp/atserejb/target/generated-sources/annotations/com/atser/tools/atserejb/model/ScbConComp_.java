package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScbConComp.class)
public abstract class ScbConComp_ {

	public static volatile SingularAttribute<ScbConComp, String> discard;
	public static volatile SingularAttribute<ScbConComp, BigInteger> infoId;
	public static volatile SingularAttribute<ScbConComp, String> appvd;
	public static volatile SingularAttribute<ScbConComp, String> traceNo;
	public static volatile SingularAttribute<ScbConComp, String> cmLocation;
	public static volatile SingularAttribute<ScbConComp, String> itemNo;
	public static volatile SingularAttribute<ScbConComp, String> companyid;
	public static volatile SingularAttribute<ScbConComp, String> testcontrol;
	public static volatile SingularAttribute<ScbConComp, String> projectNo;
	public static volatile SingularAttribute<ScbConComp, String> testNoLink;
	public static volatile SingularAttribute<ScbConComp, String> draft;
	public static volatile SingularAttribute<ScbConComp, BigInteger> labId;
	public static volatile SingularAttribute<ScbConComp, String> function;
	public static volatile SingularAttribute<ScbConComp, BigDecimal> testage;
	public static volatile SingularAttribute<ScbConComp, BigDecimal> id;
	public static volatile SingularAttribute<ScbConComp, BigInteger> mixDesignId;
	public static volatile SingularAttribute<ScbConComp, Character> peReview;
	public static volatile SingularAttribute<ScbConComp, Character> testClosed;
	public static volatile SingularAttribute<ScbConComp, String> cylinderNo;
	public static volatile SingularAttribute<ScbConComp, String> labname;
	public static volatile SingularAttribute<ScbConComp, Character> active;
	public static volatile SingularAttribute<ScbConComp, String> sampleno;
	public static volatile SingularAttribute<ScbConComp, String> labFunction;
	public static volatile SingularAttribute<ScbConComp, BigInteger> itemId;
	public static volatile SingularAttribute<ScbConComp, BigInteger> specifiedstrength;
	public static volatile SingularAttribute<ScbConComp, String> hasPhoto;
	public static volatile SingularAttribute<ScbConComp, String> ticketno;
	public static volatile SingularAttribute<ScbConComp, BigInteger> matId;
	public static volatile SingularAttribute<ScbConComp, BigInteger> projectId;
	public static volatile SingularAttribute<ScbConComp, String> status;
	public static volatile SingularAttribute<ScbConComp, BigInteger> sampletestId;
	public static volatile SingularAttribute<ScbConComp, String> testNo;
	public static volatile SingularAttribute<ScbConComp, Date> reportdate;
	public static volatile SingularAttribute<ScbConComp, String> mixdesignno;
	public static volatile SingularAttribute<ScbConComp, String> concreteClass;
	public static volatile SingularAttribute<ScbConComp, BigInteger> classId;
	public static volatile SingularAttribute<ScbConComp, BigInteger> sublotno;
	public static volatile SingularAttribute<ScbConComp, String> pName;
	public static volatile SingularAttribute<ScbConComp, String> sampleidno;
	public static volatile SingularAttribute<ScbConComp, Date> dateOfTest;
	public static volatile SingularAttribute<ScbConComp, String> station;
	public static volatile SingularAttribute<ScbConComp, BigInteger> avg28dayStrength;
	public static volatile SingularAttribute<ScbConComp, BigInteger> qaSampleId;
	public static volatile SingularAttribute<ScbConComp, BigInteger> compressivestrength;
	public static volatile SingularAttribute<ScbConComp, BigInteger> clientId;
	public static volatile SingularAttribute<ScbConComp, BigInteger> compstr28day;
	public static volatile SingularAttribute<ScbConComp, String> setnumber;
	public static volatile SingularAttribute<ScbConComp, Date> testdate;
	public static volatile SingularAttribute<ScbConComp, String> sampleTcnSp;
	public static volatile SingularAttribute<ScbConComp, String> itemMat;
	public static volatile SingularAttribute<ScbConComp, BigInteger> lotno;
	public static volatile SingularAttribute<ScbConComp, String> splitno;
	public static volatile SingularAttribute<ScbConComp, Character> splitsample;
	public static volatile SingularAttribute<ScbConComp, String> itemClass;
	public static volatile SingularAttribute<ScbConComp, String> labid;
	public static volatile SingularAttribute<ScbConComp, BigInteger> testId;
	public static volatile SingularAttribute<ScbConComp, String> location;
	public static volatile SingularAttribute<ScbConComp, String> batchSize;

	public static final String DISCARD = "discard";
	public static final String INFO_ID = "infoId";
	public static final String APPVD = "appvd";
	public static final String TRACE_NO = "traceNo";
	public static final String CM_LOCATION = "cmLocation";
	public static final String ITEM_NO = "itemNo";
	public static final String COMPANYID = "companyid";
	public static final String TESTCONTROL = "testcontrol";
	public static final String PROJECT_NO = "projectNo";
	public static final String TEST_NO_LINK = "testNoLink";
	public static final String DRAFT = "draft";
	public static final String LAB_ID = "labId";
	public static final String FUNCTION = "function";
	public static final String TESTAGE = "testage";
	public static final String ID = "id";
	public static final String MIX_DESIGN_ID = "mixDesignId";
	public static final String PE_REVIEW = "peReview";
	public static final String TEST_CLOSED = "testClosed";
	public static final String CYLINDER_NO = "cylinderNo";
	public static final String LABNAME = "labname";
	public static final String ACTIVE = "active";
	public static final String SAMPLENO = "sampleno";
	public static final String LAB_FUNCTION = "labFunction";
	public static final String ITEM_ID = "itemId";
	public static final String SPECIFIEDSTRENGTH = "specifiedstrength";
	public static final String HAS_PHOTO = "hasPhoto";
	public static final String TICKETNO = "ticketno";
	public static final String MAT_ID = "matId";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";
	public static final String SAMPLETEST_ID = "sampletestId";
	public static final String TEST_NO = "testNo";
	public static final String REPORTDATE = "reportdate";
	public static final String MIXDESIGNNO = "mixdesignno";
	public static final String CONCRETE_CLASS = "concreteClass";
	public static final String CLASS_ID = "classId";
	public static final String SUBLOTNO = "sublotno";
	public static final String P_NAME = "pName";
	public static final String SAMPLEIDNO = "sampleidno";
	public static final String DATE_OF_TEST = "dateOfTest";
	public static final String STATION = "station";
	public static final String AVG28DAY_STRENGTH = "avg28dayStrength";
	public static final String QA_SAMPLE_ID = "qaSampleId";
	public static final String COMPRESSIVESTRENGTH = "compressivestrength";
	public static final String CLIENT_ID = "clientId";
	public static final String COMPSTR28DAY = "compstr28day";
	public static final String SETNUMBER = "setnumber";
	public static final String TESTDATE = "testdate";
	public static final String SAMPLE_TCN_SP = "sampleTcnSp";
	public static final String ITEM_MAT = "itemMat";
	public static final String LOTNO = "lotno";
	public static final String SPLITNO = "splitno";
	public static final String SPLITSAMPLE = "splitsample";
	public static final String ITEM_CLASS = "itemClass";
	public static final String LABID = "labid";
	public static final String TEST_ID = "testId";
	public static final String LOCATION = "location";
	public static final String BATCH_SIZE = "batchSize";

}
