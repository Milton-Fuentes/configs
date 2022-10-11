package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSystemFunct.class)
public abstract class GlobSystemFunct_ {

	public static volatile SingularAttribute<GlobSystemFunct, String> createdByIp;
	public static volatile SingularAttribute<GlobSystemFunct, BigInteger> clientId;
	public static volatile SingularAttribute<GlobSystemFunct, String> code;
	public static volatile SingularAttribute<GlobSystemFunct, String> lastModBy;
	public static volatile SingularAttribute<GlobSystemFunct, Date> created;
	public static volatile SingularAttribute<GlobSystemFunct, Character> active;
	public static volatile SingularAttribute<GlobSystemFunct, Integer> rowOrder;
	public static volatile SingularAttribute<GlobSystemFunct, String> pagePath;
	public static volatile SingularAttribute<GlobSystemFunct, Integer> version;
	public static volatile SingularAttribute<GlobSystemFunct, String> wsSelectPath;
	public static volatile SingularAttribute<GlobSystemFunct, String> lastModIp;
	public static volatile SingularAttribute<GlobSystemFunct, Character> deleted;
	public static volatile SingularAttribute<GlobSystemFunct, String> createdBy;
	public static volatile SingularAttribute<GlobSystemFunct, String> name;
	public static volatile SingularAttribute<GlobSystemFunct, BigDecimal> id;
	public static volatile SingularAttribute<GlobSystemFunct, String> shortName;
	public static volatile SingularAttribute<GlobSystemFunct, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String CODE = "code";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String ROW_ORDER = "rowOrder";
	public static final String PAGE_PATH = "pagePath";
	public static final String VERSION = "version";
	public static final String WS_SELECT_PATH = "wsSelectPath";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String SHORT_NAME = "shortName";
	public static final String LAST_MOD = "lastMod";

}

