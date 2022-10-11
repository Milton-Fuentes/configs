package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSpecBookItem.class)
public abstract class GlobSpecBookItem_ {

	public static volatile SingularAttribute<GlobSpecBookItem, String> field1;
	public static volatile SingularAttribute<GlobSpecBookItem, BigDecimal> id;
	public static volatile SingularAttribute<GlobSpecBookItem, String> itemNo;
	public static volatile SingularAttribute<GlobSpecBookItem, BigInteger> field3;
	public static volatile SingularAttribute<GlobSpecBookItem, String> field2;
	public static volatile SingularAttribute<GlobSpecBookItem, Date> field4;

	public static final String FIELD1 = "field1";
	public static final String ID = "id";
	public static final String ITEM_NO = "itemNo";
	public static final String FIELD3 = "field3";
	public static final String FIELD2 = "field2";
	public static final String FIELD4 = "field4";

}

