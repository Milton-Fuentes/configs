package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientFunctions.class)
public abstract class GlobClientFunctions_ {

	public static volatile SingularAttribute<GlobClientFunctions, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientFunctions, String> lastModBy;
	public static volatile SingularAttribute<GlobClientFunctions, String> functionName;
	public static volatile SingularAttribute<GlobClientFunctions, Character> active;
	public static volatile SingularAttribute<GlobClientFunctions, String> version;
	public static volatile SingularAttribute<GlobClientFunctions, String> createByIp;
	public static volatile SingularAttribute<GlobClientFunctions, String> createBy;
	public static volatile SingularAttribute<GlobClientFunctions, BigInteger> functionOrder;
	public static volatile SingularAttribute<GlobClientFunctions, String> lastModIp;
	public static volatile SingularAttribute<GlobClientFunctions, String> typeProject;
	public static volatile SingularAttribute<GlobClientFunctions, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientFunctions, String> lastMod;
	public static volatile SingularAttribute<GlobClientFunctions, String> createDate;

	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String FUNCTION_NAME = "functionName";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_BY = "createBy";
	public static final String FUNCTION_ORDER = "functionOrder";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String TYPE_PROJECT = "typeProject";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";

}

