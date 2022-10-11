package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectSpecsConcmolds.class)
public abstract class GlobProjectSpecsConcmolds_ {

	public static volatile SingularAttribute<GlobProjectSpecsConcmolds, BigInteger> listOrder;
	public static volatile SingularAttribute<GlobProjectSpecsConcmolds, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectSpecsConcmolds, String> moldType;
	public static volatile SingularAttribute<GlobProjectSpecsConcmolds, String> numSets;
	public static volatile SingularAttribute<GlobProjectSpecsConcmolds, String> category;
	public static volatile SingularAttribute<GlobProjectSpecsConcmolds, BigInteger> projectId;
	public static volatile SingularAttribute<GlobProjectSpecsConcmolds, String> every;

	public static final String LIST_ORDER = "listOrder";
	public static final String ID = "id";
	public static final String MOLD_TYPE = "moldType";
	public static final String NUM_SETS = "numSets";
	public static final String CATEGORY = "category";
	public static final String PROJECT_ID = "projectId";
	public static final String EVERY = "every";

}

