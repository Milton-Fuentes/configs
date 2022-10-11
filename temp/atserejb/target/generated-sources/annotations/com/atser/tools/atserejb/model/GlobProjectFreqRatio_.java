package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectFreqRatio.class)
public abstract class GlobProjectFreqRatio_ {

	public static volatile SingularAttribute<GlobProjectFreqRatio, BigInteger> ratioOrder;
	public static volatile SingularAttribute<GlobProjectFreqRatio, String> ratioName;
	public static volatile SingularAttribute<GlobProjectFreqRatio, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectFreqRatio, BigInteger> projectId;
	public static volatile SingularAttribute<GlobProjectFreqRatio, String> ratioEquation;

	public static final String RATIO_ORDER = "ratioOrder";
	public static final String RATIO_NAME = "ratioName";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String RATIO_EQUATION = "ratioEquation";

}

