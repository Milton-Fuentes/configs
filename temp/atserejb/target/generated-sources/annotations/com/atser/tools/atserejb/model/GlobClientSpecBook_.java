package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientSpecBook.class)
public abstract class GlobClientSpecBook_ {

	public static volatile SingularAttribute<GlobClientSpecBook, BigInteger> specBookId;
	public static volatile SingularAttribute<GlobClientSpecBook, String> createBy;
	public static volatile SingularAttribute<GlobClientSpecBook, Date> temp;
	public static volatile SingularAttribute<GlobClientSpecBook, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientSpecBook, String> lastModBy;
	public static volatile SingularAttribute<GlobClientSpecBook, String> lastModIp;
	public static volatile SingularAttribute<GlobClientSpecBook, Character> active;
	public static volatile SingularAttribute<GlobClientSpecBook, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientSpecBook, String> lastMod;
	public static volatile SingularAttribute<GlobClientSpecBook, String> version;
	public static volatile SingularAttribute<GlobClientSpecBook, String> createByIp;
	public static volatile SingularAttribute<GlobClientSpecBook, String> createDate;

	public static final String SPEC_BOOK_ID = "specBookId";
	public static final String CREATE_BY = "createBy";
	public static final String TEMP = "temp";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_DATE = "createDate";

}

