package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSpecBookProj.class)
public abstract class GlobSpecBookProj_ {

	public static volatile SingularAttribute<GlobSpecBookProj, BigInteger> specBookId;
	public static volatile SingularAttribute<GlobSpecBookProj, String> field1;
	public static volatile SingularAttribute<GlobSpecBookProj, BigDecimal> id;
	public static volatile SingularAttribute<GlobSpecBookProj, BigInteger> field3;
	public static volatile SingularAttribute<GlobSpecBookProj, BigInteger> projectId;
	public static volatile SingularAttribute<GlobSpecBookProj, String> field2;
	public static volatile SingularAttribute<GlobSpecBookProj, Date> field4;

	public static final String SPEC_BOOK_ID = "specBookId";
	public static final String FIELD1 = "field1";
	public static final String ID = "id";
	public static final String FIELD3 = "field3";
	public static final String PROJECT_ID = "projectId";
	public static final String FIELD2 = "field2";
	public static final String FIELD4 = "field4";

}

