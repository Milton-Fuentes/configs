package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobNotfUserModel.class)
public abstract class GlobNotfUserModel_ {

	public static volatile SingularAttribute<GlobNotfUserModel, BigInteger> clientId;
	public static volatile SingularAttribute<GlobNotfUserModel, GlobNotfModel> modelId;
	public static volatile SingularAttribute<GlobNotfUserModel, String> module;
	public static volatile SingularAttribute<GlobNotfUserModel, BigDecimal> id;
	public static volatile SingularAttribute<GlobNotfUserModel, String> functionality;
	public static volatile SingularAttribute<GlobNotfUserModel, GlobNotfUser> userId;
	public static volatile SingularAttribute<GlobNotfUserModel, String> ntfType;
	public static volatile SingularAttribute<GlobNotfUserModel, String> status;

	public static final String CLIENT_ID = "clientId";
	public static final String MODEL_ID = "modelId";
	public static final String MODULE = "module";
	public static final String ID = "id";
	public static final String FUNCTIONALITY = "functionality";
	public static final String USER_ID = "userId";
	public static final String NTF_TYPE = "ntfType";
	public static final String STATUS = "status";

}

