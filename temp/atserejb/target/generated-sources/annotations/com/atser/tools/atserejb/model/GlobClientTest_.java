package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientTest.class)
public abstract class GlobClientTest_ {

	public static volatile SingularAttribute<GlobClientTest, GlobClient> clientId;
	public static volatile SingularAttribute<GlobClientTest, String> testRefAbbr;
	public static volatile SingularAttribute<GlobClientTest, String> reportTitle;
	public static volatile SingularAttribute<GlobClientTest, BigInteger> testId;
	public static volatile SingularAttribute<GlobClientTest, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientTest, BigInteger> clientMobile;

	public static final String CLIENT_ID = "clientId";
	public static final String TEST_REF_ABBR = "testRefAbbr";
	public static final String REPORT_TITLE = "reportTitle";
	public static final String TEST_ID = "testId";
	public static final String ID = "id";
	public static final String CLIENT_MOBILE = "clientMobile";

}

