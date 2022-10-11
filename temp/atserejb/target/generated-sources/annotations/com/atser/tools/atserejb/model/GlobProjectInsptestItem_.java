package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectInsptestItem.class)
public abstract class GlobProjectInsptestItem_ {

	public static volatile SingularAttribute<GlobProjectInsptestItem, Double> planQty;
	public static volatile SingularAttribute<GlobProjectInsptestItem, String> comments;
	public static volatile SingularAttribute<GlobProjectInsptestItem, String> lastModBy;
	public static volatile SingularAttribute<GlobProjectInsptestItem, Double> planTests;
	public static volatile SingularAttribute<GlobProjectInsptestItem, BigInteger> methodId;
	public static volatile SingularAttribute<GlobProjectInsptestItem, String> itemNo;
	public static volatile SingularAttribute<GlobProjectInsptestItem, Double> diffTests;
	public static volatile SingularAttribute<GlobProjectInsptestItem, Double> actualQty;
	public static volatile SingularAttribute<GlobProjectInsptestItem, String> version;
	public static volatile SingularAttribute<GlobProjectInsptestItem, String> createByIp;
	public static volatile SingularAttribute<GlobProjectInsptestItem, BigInteger> insptestId;
	public static volatile SingularAttribute<GlobProjectInsptestItem, String> unit;
	public static volatile SingularAttribute<GlobProjectInsptestItem, String> createBy;
	public static volatile SingularAttribute<GlobProjectInsptestItem, String> lastModIp;
	public static volatile SingularAttribute<GlobProjectInsptestItem, Double> testFreq;
	public static volatile SingularAttribute<GlobProjectInsptestItem, Double> prefTests;
	public static volatile SingularAttribute<GlobProjectInsptestItem, BigInteger> testId;
	public static volatile SingularAttribute<GlobProjectInsptestItem, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectInsptestItem, Double> reqTests;
	public static volatile SingularAttribute<GlobProjectInsptestItem, String> lastMod;

	public static final String PLAN_QTY = "planQty";
	public static final String COMMENTS = "comments";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String PLAN_TESTS = "planTests";
	public static final String METHOD_ID = "methodId";
	public static final String ITEM_NO = "itemNo";
	public static final String DIFF_TESTS = "diffTests";
	public static final String ACTUAL_QTY = "actualQty";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String INSPTEST_ID = "insptestId";
	public static final String UNIT = "unit";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String TEST_FREQ = "testFreq";
	public static final String PREF_TESTS = "prefTests";
	public static final String TEST_ID = "testId";
	public static final String ID = "id";
	public static final String REQ_TESTS = "reqTests";
	public static final String LAST_MOD = "lastMod";

}

