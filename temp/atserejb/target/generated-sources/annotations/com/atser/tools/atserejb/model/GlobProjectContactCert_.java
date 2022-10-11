package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectContactCert.class)
public abstract class GlobProjectContactCert_ {

	public static volatile SingularAttribute<GlobProjectContactCert, BigInteger> contactId;
	public static volatile SingularAttribute<GlobProjectContactCert, BigInteger> certificationId;
	public static volatile SingularAttribute<GlobProjectContactCert, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectContactCert, BigInteger> projectId;

	public static final String CONTACT_ID = "contactId";
	public static final String CERTIFICATION_ID = "certificationId";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";

}

