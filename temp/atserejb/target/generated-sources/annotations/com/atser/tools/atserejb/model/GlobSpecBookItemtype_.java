package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSpecBookItemtype.class)
public abstract class GlobSpecBookItemtype_ {

	public static volatile SingularAttribute<GlobSpecBookItemtype, BigInteger> catgId;
	public static volatile SingularAttribute<GlobSpecBookItemtype, String> itemType;
	public static volatile SingularAttribute<GlobSpecBookItemtype, String> field1;
	public static volatile SingularAttribute<GlobSpecBookItemtype, BigDecimal> id;
	public static volatile SingularAttribute<GlobSpecBookItemtype, BigInteger> field3;
	public static volatile SingularAttribute<GlobSpecBookItemtype, String> field2;
	public static volatile SingularAttribute<GlobSpecBookItemtype, Date> field4;

	public static final String CATG_ID = "catgId";
	public static final String ITEM_TYPE = "itemType";
	public static final String FIELD1 = "field1";
	public static final String ID = "id";
	public static final String FIELD3 = "field3";
	public static final String FIELD2 = "field2";
	public static final String FIELD4 = "field4";

}

