package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectFunctions.class)
public abstract class GlobProjectFunctions_ {

	public static volatile SingularAttribute<GlobProjectFunctions, BigInteger> functionId;
	public static volatile SingularAttribute<GlobProjectFunctions, BigInteger> fOrder;
	public static volatile SingularAttribute<GlobProjectFunctions, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectFunctions, BigInteger> projectId;

	public static final String FUNCTION_ID = "functionId";
	public static final String F_ORDER = "fOrder";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";

}

