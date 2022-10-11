package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSpecBookCat.class)
public abstract class GlobSpecBookCat_ {

	public static volatile SingularAttribute<GlobSpecBookCat, BigInteger> specCatOrder;
	public static volatile SingularAttribute<GlobSpecBookCat, BigDecimal> id;
	public static volatile SingularAttribute<GlobSpecBookCat, String> category;

	public static final String SPEC_CAT_ORDER = "specCatOrder";
	public static final String ID = "id";
	public static final String CATEGORY = "category";

}

