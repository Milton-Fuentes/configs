package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSequence.class)
public abstract class GlobSequence_ {

	public static volatile SingularAttribute<GlobSequence, BigInteger> idApplying;
	public static volatile SingularAttribute<GlobSequence, String> levelApplying;
	public static volatile SingularAttribute<GlobSequence, BigInteger> nextVal;
	public static volatile SingularAttribute<GlobSequence, BigDecimal> id;
	public static volatile SingularAttribute<GlobSequence, String> category;

	public static final String ID_APPLYING = "idApplying";
	public static final String LEVEL_APPLYING = "levelApplying";
	public static final String NEXT_VAL = "nextVal";
	public static final String ID = "id";
	public static final String CATEGORY = "category";

}

