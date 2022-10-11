package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaReport.class)
public abstract class QaReport_ {

	public static volatile SingularAttribute<QaReport, BigInteger> subItemId;
	public static volatile SingularAttribute<QaReport, String> rmsNo;
	public static volatile SingularAttribute<QaReport, BigInteger> infoId;
	public static volatile SingularAttribute<QaReport, String> lastModBy;
	public static volatile SingularAttribute<QaReport, BigInteger> sampleId;
	public static volatile SingularAttribute<QaReport, Character> active;
	public static volatile SingularAttribute<QaReport, BigInteger> sampleTestId;
	public static volatile SingularAttribute<QaReport, String> version;
	public static volatile SingularAttribute<QaReport, String> createByIp;
	public static volatile SingularAttribute<QaReport, BigInteger> itemId;
	public static volatile SingularAttribute<QaReport, String> createBy;
	public static volatile SingularAttribute<QaReport, String> lastModIp;
	public static volatile SingularAttribute<QaReport, Date> reportDate;
	public static volatile SingularAttribute<QaReport, BigDecimal> id;
	public static volatile SingularAttribute<QaReport, String> lastMod;
	public static volatile SingularAttribute<QaReport, BigInteger> testReportId;
	public static volatile SingularAttribute<QaReport, String> reportNo;
	public static volatile SingularAttribute<QaReport, String> remarks;
	public static volatile SingularAttribute<QaReport, String> createDate;

	public static final String SUB_ITEM_ID = "subItemId";
	public static final String RMS_NO = "rmsNo";
	public static final String INFO_ID = "infoId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String SAMPLE_ID = "sampleId";
	public static final String ACTIVE = "active";
	public static final String SAMPLE_TEST_ID = "sampleTestId";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String ITEM_ID = "itemId";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String REPORT_DATE = "reportDate";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String TEST_REPORT_ID = "testReportId";
	public static final String REPORT_NO = "reportNo";
	public static final String REMARKS = "remarks";
	public static final String CREATE_DATE = "createDate";

}

