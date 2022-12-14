package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaSampleTest.class)
public abstract class QaSampleTest_ {

	public static volatile SingularAttribute<QaSampleTest, String> pendingapprovedBy;
	public static volatile SingularAttribute<QaSampleTest, String> reason;
	public static volatile SingularAttribute<QaSampleTest, String> lastModBy;
	public static volatile SingularAttribute<QaSampleTest, BigInteger> infoId;
	public static volatile SingularAttribute<QaSampleTest, String> createDateTmp;
	public static volatile SingularAttribute<QaSampleTest, BigInteger> activityId;
	public static volatile SingularAttribute<QaSampleTest, BigInteger> workorderId;
	public static volatile SingularAttribute<QaSampleTest, Date> acknowledgedDate;
	public static volatile SingularAttribute<QaSampleTest, String> labId;
	public static volatile SingularAttribute<QaSampleTest, String> completedTimestamp;
	public static volatile SingularAttribute<QaSampleTest, String> approveDateTmp;
	public static volatile SingularAttribute<QaSampleTest, Character> reviewed;
	public static volatile SingularAttribute<QaSampleTest, BigDecimal> id;
	public static volatile SingularAttribute<QaSampleTest, String> unapprovedBy;
	public static volatile SingularAttribute<QaSampleTest, String> reportNo;
	public static volatile SingularAttribute<QaSampleTest, String> element;
	public static volatile SingularAttribute<QaSampleTest, Character> peReview;
	public static volatile SingularAttribute<QaSampleTest, String> item;
	public static volatile SingularAttribute<QaSampleTest, BigInteger> sampleId;
	public static volatile SingularAttribute<QaSampleTest, Character> testClosed;
	public static volatile SingularAttribute<QaSampleTest, String> approvedby;
	public static volatile SingularAttribute<QaSampleTest, Character> active;
	public static volatile SingularAttribute<QaSampleTest, BigInteger> disciplineId;
	public static volatile SingularAttribute<QaSampleTest, String> dateCompletedTmp;
	public static volatile SingularAttribute<QaSampleTest, String> acknowledgedby;
	public static volatile SingularAttribute<QaSampleTest, String> classification;
	public static volatile SingularAttribute<QaSampleTest, String> reviewedBy;
	public static volatile SingularAttribute<QaSampleTest, String> version;
	public static volatile SingularAttribute<QaSampleTest, Character> passfail;
	public static volatile SingularAttribute<QaSampleTest, String> rejectedBy;
	public static volatile SingularAttribute<QaSampleTest, String> testDateTmp;
	public static volatile SingularAttribute<QaSampleTest, Character> alerted;
	public static volatile SingularAttribute<QaSampleTest, String> lastMod;
	public static volatile SingularAttribute<QaSampleTest, String> testBy;
	public static volatile SingularAttribute<QaSampleTest, String> status;
	public static volatile SingularAttribute<QaSampleTest, String> tempTmp;
	public static volatile SingularAttribute<QaSampleTest, String> testNo;
	public static volatile SingularAttribute<QaSampleTest, Date> approveDate;
	public static volatile SingularAttribute<QaSampleTest, Character> rejected;
	public static volatile SingularAttribute<QaSampleTest, String> description;
	public static volatile SingularAttribute<QaSampleTest, Character> unapproved;
	public static volatile SingularAttribute<QaSampleTest, String> lastModIp;
	public static volatile SingularAttribute<QaSampleTest, Date> dateCompleted;
	public static volatile SingularAttribute<QaSampleTest, String> approvedTimestamp;
	public static volatile SingularAttribute<QaSampleTest, Date> reviewedDate;
	public static volatile SingularAttribute<QaSampleTest, String> createDate;
	public static volatile SingularAttribute<QaSampleTest, Date> temp;
	public static volatile SingularAttribute<QaSampleTest, String> reviewedTimestamp;
	public static volatile SingularAttribute<QaSampleTest, String> testFunc;
	public static volatile SingularAttribute<QaSampleTest, String> testPrefs;
	public static volatile SingularAttribute<QaSampleTest, String> createByIp;
	public static volatile SingularAttribute<QaSampleTest, String> alertedBy;
	public static volatile SingularAttribute<QaSampleTest, String> createBy;
	public static volatile SingularAttribute<QaSampleTest, Character> pendingapproved;
	public static volatile SingularAttribute<QaSampleTest, String> lastModTmp;
	public static volatile SingularAttribute<QaSampleTest, Character> fromMobile;
	public static volatile SingularAttribute<QaSampleTest, String> testId;
	public static volatile SingularAttribute<QaSampleTest, String> reportKey;
	public static volatile SingularAttribute<QaSampleTest, Date> testDate;
	public static volatile SingularAttribute<QaSampleTest, String> completedBy;

	public static final String PENDINGAPPROVED_BY = "pendingapprovedBy";
	public static final String REASON = "reason";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String INFO_ID = "infoId";
	public static final String CREATE_DATE_TMP = "createDateTmp";
	public static final String ACTIVITY_ID = "activityId";
	public static final String WORKORDER_ID = "workorderId";
	public static final String ACKNOWLEDGED_DATE = "acknowledgedDate";
	public static final String LAB_ID = "labId";
	public static final String COMPLETED_TIMESTAMP = "completedTimestamp";
	public static final String APPROVE_DATE_TMP = "approveDateTmp";
	public static final String REVIEWED = "reviewed";
	public static final String ID = "id";
	public static final String UNAPPROVED_BY = "unapprovedBy";
	public static final String REPORT_NO = "reportNo";
	public static final String ELEMENT = "element";
	public static final String PE_REVIEW = "peReview";
	public static final String ITEM = "item";
	public static final String SAMPLE_ID = "sampleId";
	public static final String TEST_CLOSED = "testClosed";
	public static final String APPROVEDBY = "approvedby";
	public static final String ACTIVE = "active";
	public static final String DISCIPLINE_ID = "disciplineId";
	public static final String DATE_COMPLETED_TMP = "dateCompletedTmp";
	public static final String ACKNOWLEDGEDBY = "acknowledgedby";
	public static final String CLASSIFICATION = "classification";
	public static final String REVIEWED_BY = "reviewedBy";
	public static final String VERSION = "version";
	public static final String PASSFAIL = "passfail";
	public static final String REJECTED_BY = "rejectedBy";
	public static final String TEST_DATE_TMP = "testDateTmp";
	public static final String ALERTED = "alerted";
	public static final String LAST_MOD = "lastMod";
	public static final String TEST_BY = "testBy";
	public static final String STATUS = "status";
	public static final String TEMP_TMP = "tempTmp";
	public static final String TEST_NO = "testNo";
	public static final String APPROVE_DATE = "approveDate";
	public static final String REJECTED = "rejected";
	public static final String DESCRIPTION = "description";
	public static final String UNAPPROVED = "unapproved";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DATE_COMPLETED = "dateCompleted";
	public static final String APPROVED_TIMESTAMP = "approvedTimestamp";
	public static final String REVIEWED_DATE = "reviewedDate";
	public static final String CREATE_DATE = "createDate";
	public static final String TEMP = "temp";
	public static final String REVIEWED_TIMESTAMP = "reviewedTimestamp";
	public static final String TEST_FUNC = "testFunc";
	public static final String TEST_PREFS = "testPrefs";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String ALERTED_BY = "alertedBy";
	public static final String CREATE_BY = "createBy";
	public static final String PENDINGAPPROVED = "pendingapproved";
	public static final String LAST_MOD_TMP = "lastModTmp";
	public static final String FROM_MOBILE = "fromMobile";
	public static final String TEST_ID = "testId";
	public static final String REPORT_KEY = "reportKey";
	public static final String TEST_DATE = "testDate";
	public static final String COMPLETED_BY = "completedBy";

}

