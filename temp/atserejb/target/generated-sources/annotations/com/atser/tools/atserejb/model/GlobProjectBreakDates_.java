package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectBreakDates.class)
public abstract class GlobProjectBreakDates_ {

	public static volatile SingularAttribute<GlobProjectBreakDates, BigInteger> listOrder;
	public static volatile SingularAttribute<GlobProjectBreakDates, String> testage;
	public static volatile SingularAttribute<GlobProjectBreakDates, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectBreakDates, String> type;
	public static volatile SingularAttribute<GlobProjectBreakDates, String> category;
	public static volatile SingularAttribute<GlobProjectBreakDates, BigInteger> projectId;

	public static final String LIST_ORDER = "listOrder";
	public static final String TESTAGE = "testage";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String CATEGORY = "category";
	public static final String PROJECT_ID = "projectId";

}

