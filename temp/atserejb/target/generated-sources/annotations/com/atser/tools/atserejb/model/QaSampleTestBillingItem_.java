package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaSampleTestBillingItem.class)
public abstract class QaSampleTestBillingItem_ {

	public static volatile SingularAttribute<QaSampleTestBillingItem, String> reason;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> exportedDateTmp;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> lastModBy;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> createDateTmp;
	public static volatile SingularAttribute<QaSampleTestBillingItem, Date> approveDate;
	public static volatile SingularAttribute<QaSampleTestBillingItem, Date> exportedDate;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> units;
	public static volatile SingularAttribute<QaSampleTestBillingItem, BigInteger> sampleTestId;
	public static volatile SingularAttribute<QaSampleTestBillingItem, Character> unapproved;
	public static volatile SingularAttribute<QaSampleTestBillingItem, GlobBillingCode> billingCodeId;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> lastModIp;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> approveDateTmp;
	public static volatile SingularAttribute<QaSampleTestBillingItem, BigDecimal> id;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> unapprovedBy;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> overrideUnit_price;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> createDate;
	public static volatile SingularAttribute<QaSampleTestBillingItem, Character> exported;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> overrideComments;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> approvedby;
	public static volatile SingularAttribute<QaSampleTestBillingItem, Character> active;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> version;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> createByIp;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> itemId;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> createBy;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> lastModTmp;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> overrideDescription;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> lastMod;
	public static volatile SingularAttribute<QaSampleTestBillingItem, String> status;

	public static final String REASON = "reason";
	public static final String EXPORTED_DATE_TMP = "exportedDateTmp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATE_DATE_TMP = "createDateTmp";
	public static final String APPROVE_DATE = "approveDate";
	public static final String EXPORTED_DATE = "exportedDate";
	public static final String UNITS = "units";
	public static final String SAMPLE_TEST_ID = "sampleTestId";
	public static final String UNAPPROVED = "unapproved";
	public static final String BILLING_CODE_ID = "billingCodeId";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String APPROVE_DATE_TMP = "approveDateTmp";
	public static final String ID = "id";
	public static final String UNAPPROVED_BY = "unapprovedBy";
	public static final String OVERRIDE_UNIT_PRICE = "overrideUnit_price";
	public static final String CREATE_DATE = "createDate";
	public static final String EXPORTED = "exported";
	public static final String OVERRIDE_COMMENTS = "overrideComments";
	public static final String APPROVEDBY = "approvedby";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String ITEM_ID = "itemId";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_TMP = "lastModTmp";
	public static final String OVERRIDE_DESCRIPTION = "overrideDescription";
	public static final String LAST_MOD = "lastMod";
	public static final String STATUS = "status";

}

