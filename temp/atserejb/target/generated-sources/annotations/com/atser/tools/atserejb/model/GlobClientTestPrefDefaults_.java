package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientTestPrefDefaults.class)
public abstract class GlobClientTestPrefDefaults_ {

	public static volatile SingularAttribute<GlobClientTestPrefDefaults, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientTestPrefDefaults, BigInteger> testPrefId;
	public static volatile SingularAttribute<GlobClientTestPrefDefaults, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientTestPrefDefaults, Character> usesPreference;

	public static final String CLIENT_ID = "clientId";
	public static final String TEST_PREF_ID = "testPrefId";
	public static final String ID = "id";
	public static final String USES_PREFERENCE = "usesPreference";

}

