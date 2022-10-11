package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientSampleCatg.class)
public abstract class GlobClientSampleCatg_ {

	public static volatile SingularAttribute<GlobClientSampleCatg, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientSampleCatg, BigInteger> sampleCatgId;
	public static volatile SingularAttribute<GlobClientSampleCatg, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientSampleCatg, String> sampleCatgTitle;

	public static final String CLIENT_ID = "clientId";
	public static final String SAMPLE_CATG_ID = "sampleCatgId";
	public static final String ID = "id";
	public static final String SAMPLE_CATG_TITLE = "sampleCatgTitle";

}

