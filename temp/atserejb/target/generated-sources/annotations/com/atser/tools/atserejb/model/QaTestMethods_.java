package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaTestMethods.class)
public abstract class QaTestMethods_ {

	public static volatile SingularAttribute<QaTestMethods, BigInteger> mobile;
	public static volatile SetAttribute<QaTestMethods, GlobClientTest> globClientTest;
	public static volatile SingularAttribute<QaTestMethods, String> description;
	public static volatile SingularAttribute<QaTestMethods, Character> active;
	public static volatile SingularAttribute<QaTestMethods, String> wsPath;
	public static volatile SingularAttribute<QaTestMethods, BigInteger> catgId;
	public static volatile SingularAttribute<QaTestMethods, String> reference;
	public static volatile SingularAttribute<QaTestMethods, Character> useSampleid;
	public static volatile SingularAttribute<QaTestMethods, String> jspPage;
	public static volatile SingularAttribute<QaTestMethods, String> name;
	public static volatile SingularAttribute<QaTestMethods, String> lastModTmp;
	public static volatile SingularAttribute<QaTestMethods, String> testTable;
	public static volatile SingularAttribute<QaTestMethods, BigDecimal> id;
	public static volatile SingularAttribute<QaTestMethods, String> lastMod;

	public static final String MOBILE = "mobile";
	public static final String GLOB_CLIENT_TEST = "globClientTest";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String WS_PATH = "wsPath";
	public static final String CATG_ID = "catgId";
	public static final String REFERENCE = "reference";
	public static final String USE_SAMPLEID = "useSampleid";
	public static final String JSP_PAGE = "jspPage";
	public static final String NAME = "name";
	public static final String LAST_MOD_TMP = "lastModTmp";
	public static final String TEST_TABLE = "testTable";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

