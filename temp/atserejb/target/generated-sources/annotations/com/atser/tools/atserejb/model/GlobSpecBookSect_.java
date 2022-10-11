package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSpecBookSect.class)
public abstract class GlobSpecBookSect_ {

	public static volatile SingularAttribute<GlobSpecBookSect, String> sectionName;
	public static volatile SingularAttribute<GlobSpecBookSect, BigInteger> specBookId;
	public static volatile SingularAttribute<GlobSpecBookSect, String> field1;
	public static volatile SingularAttribute<GlobSpecBookSect, BigDecimal> id;
	public static volatile SingularAttribute<GlobSpecBookSect, BigInteger> field3;
	public static volatile SingularAttribute<GlobSpecBookSect, String> field2;
	public static volatile SingularAttribute<GlobSpecBookSect, Date> field4;

	public static final String SECTION_NAME = "sectionName";
	public static final String SPEC_BOOK_ID = "specBookId";
	public static final String FIELD1 = "field1";
	public static final String ID = "id";
	public static final String FIELD3 = "field3";
	public static final String FIELD2 = "field2";
	public static final String FIELD4 = "field4";

}

