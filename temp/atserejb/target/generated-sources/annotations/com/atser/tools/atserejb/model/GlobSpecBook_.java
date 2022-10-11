package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSpecBook.class)
public abstract class GlobSpecBook_ {

	public static volatile SingularAttribute<GlobSpecBook, String> specName;
	public static volatile SingularAttribute<GlobSpecBook, BigInteger> specOrder;
	public static volatile SingularAttribute<GlobSpecBook, BigInteger> specBookCatId;
	public static volatile SingularAttribute<GlobSpecBook, BigDecimal> id;

	public static final String SPEC_NAME = "specName";
	public static final String SPEC_ORDER = "specOrder";
	public static final String SPEC_BOOK_CAT_ID = "specBookCatId";
	public static final String ID = "id";

}

