package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobWorkorderSignatures.class)
public abstract class GlobWorkorderSignatures_ {

	public static volatile SingularAttribute<GlobWorkorderSignatures, Date> imageTimestamp;
	public static volatile SingularAttribute<GlobWorkorderSignatures, BigInteger> workorderId;
	public static volatile SingularAttribute<GlobWorkorderSignatures, BigDecimal> id;

	public static final String IMAGE_TIMESTAMP = "imageTimestamp";
	public static final String WORKORDER_ID = "workorderId";
	public static final String ID = "id";

}

