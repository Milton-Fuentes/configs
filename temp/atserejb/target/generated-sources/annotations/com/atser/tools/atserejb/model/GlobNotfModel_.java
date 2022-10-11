package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobNotfModel.class)
public abstract class GlobNotfModel_ {

	public static volatile SingularAttribute<GlobNotfModel, BigInteger> clientId;
	public static volatile SingularAttribute<GlobNotfModel, BigDecimal> id;
	public static volatile SingularAttribute<GlobNotfModel, BigInteger> refId;
	public static volatile SingularAttribute<GlobNotfModel, String> modelType;
	public static volatile SingularAttribute<GlobNotfModel, String> content;

	public static final String CLIENT_ID = "clientId";
	public static final String ID = "id";
	public static final String REF_ID = "refId";
	public static final String MODEL_TYPE = "modelType";
	public static final String CONTENT = "content";

}

