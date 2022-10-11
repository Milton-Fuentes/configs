package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSpecBookInfoSpecs.class)
public abstract class GlobSpecBookInfoSpecs_ {

	public static volatile SingularAttribute<GlobSpecBookInfoSpecs, BigInteger> specificationId;
	public static volatile SingularAttribute<GlobSpecBookInfoSpecs, BigInteger> specBookId;
	public static volatile SingularAttribute<GlobSpecBookInfoSpecs, BigDecimal> id;

	public static final String SPECIFICATION_ID = "specificationId";
	public static final String SPEC_BOOK_ID = "specBookId";
	public static final String ID = "id";

}

