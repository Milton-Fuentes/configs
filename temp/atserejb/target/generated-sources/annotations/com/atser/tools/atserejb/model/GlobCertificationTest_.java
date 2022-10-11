package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobCertificationTest.class)
public abstract class GlobCertificationTest_ {

	public static volatile SingularAttribute<GlobCertificationTest, String> lastModBy;
	public static volatile SingularAttribute<GlobCertificationTest, String> lastModIp;
	public static volatile SingularAttribute<GlobCertificationTest, GlobCertification> qualificationId;
	public static volatile SingularAttribute<GlobCertificationTest, QaTestMethods> testId;
	public static volatile SingularAttribute<GlobCertificationTest, BigDecimal> id;
	public static volatile SingularAttribute<GlobCertificationTest, String> lastMod;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String QUALIFICATION_ID = "qualificationId";
	public static final String TEST_ID = "testId";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

