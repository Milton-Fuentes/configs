package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobCustomConfigUser.class)
public abstract class GlobCustomConfigUser_ {

	public static volatile SingularAttribute<GlobCustomConfigUser, String> createdByIp;
	public static volatile SingularAttribute<GlobCustomConfigUser, String> lastModBy;
	public static volatile SingularAttribute<GlobCustomConfigUser, Date> created;
	public static volatile SingularAttribute<GlobCustomConfigUser, Character> active;
	public static volatile SingularAttribute<GlobCustomConfigUser, BigInteger> userId;
	public static volatile SingularAttribute<GlobCustomConfigUser, Integer> version;
	public static volatile SingularAttribute<GlobCustomConfigUser, String> lastModIp;
	public static volatile SingularAttribute<GlobCustomConfigUser, Character> deleted;
	public static volatile SingularAttribute<GlobCustomConfigUser, String> createdBy;
	public static volatile SingularAttribute<GlobCustomConfigUser, GlobCustomConfig> configId;
	public static volatile SingularAttribute<GlobCustomConfigUser, BigDecimal> id;
	public static volatile SingularAttribute<GlobCustomConfigUser, String> value;
	public static volatile SingularAttribute<GlobCustomConfigUser, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String USER_ID = "userId";
	public static final String VERSION = "version";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String CONFIG_ID = "configId";
	public static final String ID = "id";
	public static final String VALUE = "value";
	public static final String LAST_MOD = "lastMod";

}

