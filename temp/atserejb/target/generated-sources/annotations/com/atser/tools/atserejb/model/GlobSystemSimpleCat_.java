package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSystemSimpleCat.class)
public abstract class GlobSystemSimpleCat_ {

	public static volatile SingularAttribute<GlobSystemSimpleCat, String> createdByIp;
	public static volatile SingularAttribute<GlobSystemSimpleCat, BigInteger> clientId;
	public static volatile SingularAttribute<GlobSystemSimpleCat, String> code;
	public static volatile SingularAttribute<GlobSystemSimpleCat, String> lastModBy;
	public static volatile SingularAttribute<GlobSystemSimpleCat, Date> created;
	public static volatile SingularAttribute<GlobSystemSimpleCat, BigInteger> catOrder;
	public static volatile SingularAttribute<GlobSystemSimpleCat, Character> active;
	public static volatile SingularAttribute<GlobSystemSimpleCat, Integer> version;
	public static volatile SingularAttribute<GlobSystemSimpleCat, String> lastModIp;
	public static volatile SingularAttribute<GlobSystemSimpleCat, Character> deleted;
	public static volatile SingularAttribute<GlobSystemSimpleCat, String> createdBy;
	public static volatile SingularAttribute<GlobSystemSimpleCat, String> name;
	public static volatile SingularAttribute<GlobSystemSimpleCat, BigDecimal> id;
	public static volatile SingularAttribute<GlobSystemSimpleCat, String> shortName;
	public static volatile SingularAttribute<GlobSystemSimpleCat, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String CODE = "code";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String CAT_ORDER = "catOrder";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String SHORT_NAME = "shortName";
	public static final String LAST_MOD = "lastMod";

}

