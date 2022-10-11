package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwClientTests.class)
public abstract class VwClientTests_ {

	public static volatile SingularAttribute<VwClientTests, BigInteger> clientId;
	public static volatile SingularAttribute<VwClientTests, String> clientName;
	public static volatile SingularAttribute<VwClientTests, String> testCustomName;
	public static volatile SingularAttribute<VwClientTests, BigInteger> testId;
	public static volatile SingularAttribute<VwClientTests, BigDecimal> id;
	public static volatile SingularAttribute<VwClientTests, String> testName;

	public static final String CLIENT_ID = "clientId";
	public static final String CLIENT_NAME = "clientName";
	public static final String TEST_CUSTOM_NAME = "testCustomName";
	public static final String TEST_ID = "testId";
	public static final String ID = "id";
	public static final String TEST_NAME = "testName";

}

