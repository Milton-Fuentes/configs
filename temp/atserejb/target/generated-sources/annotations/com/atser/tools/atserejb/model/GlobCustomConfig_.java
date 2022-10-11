package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobCustomConfig.class)
public abstract class GlobCustomConfig_ {

	public static volatile SingularAttribute<GlobCustomConfig, String> dataurl;
	public static volatile SingularAttribute<GlobCustomConfig, String> createdByIp;
	public static volatile SingularAttribute<GlobCustomConfig, BigInteger> clientId;
	public static volatile SingularAttribute<GlobCustomConfig, String> lastModBy;
	public static volatile SingularAttribute<GlobCustomConfig, Date> created;
	public static volatile SingularAttribute<GlobCustomConfig, Character> customizable;
	public static volatile SingularAttribute<GlobCustomConfig, String> description;
	public static volatile SingularAttribute<GlobCustomConfig, Character> active;
	public static volatile SingularAttribute<GlobCustomConfig, String> functionality;
	public static volatile SingularAttribute<GlobCustomConfig, Integer> version;
	public static volatile SingularAttribute<GlobCustomConfig, Character> loadSession;
	public static volatile SingularAttribute<GlobCustomConfig, String> lastModIp;
	public static volatile SingularAttribute<GlobCustomConfig, Character> deleted;
	public static volatile SingularAttribute<GlobCustomConfig, String> datatype;
	public static volatile SingularAttribute<GlobCustomConfig, String> createdBy;
	public static volatile SingularAttribute<GlobCustomConfig, String> name;
	public static volatile SingularAttribute<GlobCustomConfig, BigDecimal> id;
	public static volatile SingularAttribute<GlobCustomConfig, String> value;
	public static volatile SingularAttribute<GlobCustomConfig, Date> lastMod;

	public static final String DATAURL = "dataurl";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String CUSTOMIZABLE = "customizable";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String FUNCTIONALITY = "functionality";
	public static final String VERSION = "version";
	public static final String LOAD_SESSION = "loadSession";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String DATATYPE = "datatype";
	public static final String CREATED_BY = "createdBy";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String VALUE = "value";
	public static final String LAST_MOD = "lastMod";

}

