package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSpecBookInfoApp.class)
public abstract class GlobSpecBookInfoApp_ {

	public static volatile SingularAttribute<GlobSpecBookInfoApp, BigInteger> specBookId;
	public static volatile SingularAttribute<GlobSpecBookInfoApp, BigDecimal> id;
	public static volatile SingularAttribute<GlobSpecBookInfoApp, BigInteger> applicationId;

	public static final String SPEC_BOOK_ID = "specBookId";
	public static final String ID = "id";
	public static final String APPLICATION_ID = "applicationId";

}

