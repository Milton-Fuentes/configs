package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BpmClientProcessCatg.class)
public abstract class BpmClientProcessCatg_ {

	public static volatile SingularAttribute<BpmClientProcessCatg, String> createdByIp;
	public static volatile SingularAttribute<BpmClientProcessCatg, BigInteger> clientId;
	public static volatile SingularAttribute<BpmClientProcessCatg, String> code;
	public static volatile SingularAttribute<BpmClientProcessCatg, String> lastModBy;
	public static volatile SingularAttribute<BpmClientProcessCatg, Date> created;
	public static volatile SingularAttribute<BpmClientProcessCatg, Integer> catOrder;
	public static volatile SingularAttribute<BpmClientProcessCatg, Character> active;
	public static volatile SingularAttribute<BpmClientProcessCatg, Integer> version;
	public static volatile SingularAttribute<BpmClientProcessCatg, String> lastModIp;
	public static volatile SingularAttribute<BpmClientProcessCatg, Character> deleted;
	public static volatile SingularAttribute<BpmClientProcessCatg, String> processName;
	public static volatile SingularAttribute<BpmClientProcessCatg, String> createdBy;
	public static volatile SingularAttribute<BpmClientProcessCatg, String> name;
	public static volatile SingularAttribute<BpmClientProcessCatg, BigDecimal> id;
	public static volatile SingularAttribute<BpmClientProcessCatg, String> shortName;
	public static volatile SingularAttribute<BpmClientProcessCatg, Date> lastMod;

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
	public static final String PROCESS_NAME = "processName";
	public static final String CREATED_BY = "createdBy";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String SHORT_NAME = "shortName";
	public static final String LAST_MOD = "lastMod";

}

