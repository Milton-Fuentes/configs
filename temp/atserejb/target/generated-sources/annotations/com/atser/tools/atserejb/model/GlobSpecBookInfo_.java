package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSpecBookInfo.class)
public abstract class GlobSpecBookInfo_ {

	public static volatile SingularAttribute<GlobSpecBookInfo, Date> bookDate;
	public static volatile SingularAttribute<GlobSpecBookInfo, String> field1;
	public static volatile SingularAttribute<GlobSpecBookInfo, Character> active;
	public static volatile SingularAttribute<GlobSpecBookInfo, BigDecimal> id;
	public static volatile SingularAttribute<GlobSpecBookInfo, BigInteger> originatorId;
	public static volatile SingularAttribute<GlobSpecBookInfo, BigInteger> field3;
	public static volatile SingularAttribute<GlobSpecBookInfo, String> bookName;
	public static volatile SingularAttribute<GlobSpecBookInfo, String> field2;
	public static volatile SingularAttribute<GlobSpecBookInfo, Date> field4;

	public static final String BOOK_DATE = "bookDate";
	public static final String FIELD1 = "field1";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String ORIGINATOR_ID = "originatorId";
	public static final String FIELD3 = "field3";
	public static final String BOOK_NAME = "bookName";
	public static final String FIELD2 = "field2";
	public static final String FIELD4 = "field4";

}

