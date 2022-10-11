package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientLabDefault.class)
public abstract class GlobClientLabDefault_ {

	public static volatile SingularAttribute<GlobClientLabDefault, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientLabDefault, String> lastModBy;
	public static volatile SingularAttribute<GlobClientLabDefault, Character> active;
	public static volatile SingularAttribute<GlobClientLabDefault, String> version;
	public static volatile SingularAttribute<GlobClientLabDefault, String> createByIp;
	public static volatile SingularAttribute<GlobClientLabDefault, BigInteger> masterLabId;
	public static volatile SingularAttribute<GlobClientLabDefault, BigInteger> functionId;
	public static volatile SingularAttribute<GlobClientLabDefault, String> createBy;
	public static volatile SingularAttribute<GlobClientLabDefault, String> lastModIp;
	public static volatile SingularAttribute<GlobClientLabDefault, BigInteger> regionId;
	public static volatile SingularAttribute<GlobClientLabDefault, String> typeProject;
	public static volatile SingularAttribute<GlobClientLabDefault, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientLabDefault, String> lastMod;
	public static volatile SingularAttribute<GlobClientLabDefault, String> createDate;

	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String MASTER_LAB_ID = "masterLabId";
	public static final String FUNCTION_ID = "functionId";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String REGION_ID = "regionId";
	public static final String TYPE_PROJECT = "typeProject";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";

}

