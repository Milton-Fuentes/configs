package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobNotfUser.class)
public abstract class GlobNotfUser_ {

	public static volatile SingularAttribute<GlobNotfUser, BigInteger> clientId;
	public static volatile SingularAttribute<GlobNotfUser, Date> created;
	public static volatile ListAttribute<GlobNotfUser, GlobNotfUserModel> globNotfUserModelList;
	public static volatile SingularAttribute<GlobNotfUser, BigDecimal> id;
	public static volatile SingularAttribute<GlobNotfUser, String> username;

	public static final String CLIENT_ID = "clientId";
	public static final String CREATED = "created";
	public static final String GLOB_NOTF_USER_MODEL_LIST = "globNotfUserModelList";
	public static final String ID = "id";
	public static final String USERNAME = "username";

}

