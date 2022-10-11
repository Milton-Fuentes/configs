package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectFreqType.class)
public abstract class GlobProjectFreqType_ {

	public static volatile SingularAttribute<GlobProjectFreqType, BigInteger> typeId;
	public static volatile SingularAttribute<GlobProjectFreqType, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectFreqType, String> category;
	public static volatile SingularAttribute<GlobProjectFreqType, BigInteger> projectId;

	public static final String TYPE_ID = "typeId";
	public static final String ID = "id";
	public static final String CATEGORY = "category";
	public static final String PROJECT_ID = "projectId";

}

