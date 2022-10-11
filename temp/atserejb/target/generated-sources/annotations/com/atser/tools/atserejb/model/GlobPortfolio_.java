package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobPortfolio.class)
public abstract class GlobPortfolio_ {

	public static volatile SingularAttribute<GlobPortfolio, String> createdByIp;
	public static volatile SingularAttribute<GlobPortfolio, BigInteger> clientId;
	public static volatile SingularAttribute<GlobPortfolio, String> code;
	public static volatile SingularAttribute<GlobPortfolio, String> lastModBy;
	public static volatile SingularAttribute<GlobPortfolio, Date> created;
	public static volatile SingularAttribute<GlobPortfolio, String> description;
	public static volatile SingularAttribute<GlobPortfolio, Character> active;
	public static volatile SingularAttribute<GlobPortfolio, Integer> version;
	public static volatile SingularAttribute<GlobPortfolio, BigInteger> folderId;
	public static volatile SingularAttribute<GlobPortfolio, String> lastModIp;
	public static volatile SingularAttribute<GlobPortfolio, Character> deleted;
	public static volatile SingularAttribute<GlobPortfolio, String> createdBy;
	public static volatile SingularAttribute<GlobPortfolio, String> name;
	public static volatile SingularAttribute<GlobPortfolio, BigDecimal> id;
	public static volatile SingularAttribute<GlobPortfolio, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String CODE = "code";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

