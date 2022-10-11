package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSpecItemMat.class)
public abstract class GlobSpecItemMat_ {

	public static volatile SingularAttribute<GlobSpecItemMat, BigInteger> itemId;
	public static volatile SingularAttribute<GlobSpecItemMat, BigInteger> classId;
	public static volatile SingularAttribute<GlobSpecItemMat, String> field1;
	public static volatile SingularAttribute<GlobSpecItemMat, BigInteger> matId;
	public static volatile SingularAttribute<GlobSpecItemMat, BigInteger> itemtypeId;
	public static volatile SingularAttribute<GlobSpecItemMat, BigDecimal> id;
	public static volatile SingularAttribute<GlobSpecItemMat, BigInteger> sectionId;
	public static volatile SingularAttribute<GlobSpecItemMat, BigInteger> field3;
	public static volatile SingularAttribute<GlobSpecItemMat, String> field2;
	public static volatile SingularAttribute<GlobSpecItemMat, Date> field4;

	public static final String ITEM_ID = "itemId";
	public static final String CLASS_ID = "classId";
	public static final String FIELD1 = "field1";
	public static final String MAT_ID = "matId";
	public static final String ITEMTYPE_ID = "itemtypeId";
	public static final String ID = "id";
	public static final String SECTION_ID = "sectionId";
	public static final String FIELD3 = "field3";
	public static final String FIELD2 = "field2";
	public static final String FIELD4 = "field4";

}

