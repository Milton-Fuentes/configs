package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobUserSignature.class)
public abstract class GlobUserSignature_ {

	public static volatile SingularAttribute<GlobUserSignature, Date> imageTimestamp;
	public static volatile SingularAttribute<GlobUserSignature, byte[]> imageData;
	public static volatile SingularAttribute<GlobUserSignature, BigDecimal> id;
	public static volatile SingularAttribute<GlobUserSignature, BigInteger> userId;

	public static final String IMAGE_TIMESTAMP = "imageTimestamp";
	public static final String IMAGE_DATA = "imageData";
	public static final String ID = "id";
	public static final String USER_ID = "userId";

}

