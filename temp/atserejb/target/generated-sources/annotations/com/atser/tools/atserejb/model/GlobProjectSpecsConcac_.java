package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectSpecsConcac.class)
public abstract class GlobProjectSpecsConcac_ {

	public static volatile SingularAttribute<GlobProjectSpecsConcac, BigInteger> listOrder;
	public static volatile SingularAttribute<GlobProjectSpecsConcac, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectSpecsConcac, String> category;
	public static volatile SingularAttribute<GlobProjectSpecsConcac, BigInteger> projectId;
	public static volatile SingularAttribute<GlobProjectSpecsConcac, String> aircontent;

	public static final String LIST_ORDER = "listOrder";
	public static final String ID = "id";
	public static final String CATEGORY = "category";
	public static final String PROJECT_ID = "projectId";
	public static final String AIRCONTENT = "aircontent";

}

