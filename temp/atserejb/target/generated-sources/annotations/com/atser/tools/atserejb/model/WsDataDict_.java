package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(WsDataDict.class)
public abstract class WsDataDict_ {

	public static volatile SingularAttribute<WsDataDict, String> createBy;
	public static volatile SingularAttribute<WsDataDict, BigInteger> clientId;
	public static volatile SingularAttribute<WsDataDict, String> code;
	public static volatile SingularAttribute<WsDataDict, String> deleted;
	public static volatile SingularAttribute<WsDataDict, Date> created;
	public static volatile SingularAttribute<WsDataDict, String> active;
	public static volatile SingularAttribute<WsDataDict, BigDecimal> id;
	public static volatile SingularAttribute<WsDataDict, String> type;
	public static volatile SingularAttribute<WsDataDict, BigInteger> version;
	public static volatile SingularAttribute<WsDataDict, String> content;

	public static final String CREATE_BY = "createBy";
	public static final String CLIENT_ID = "clientId";
	public static final String CODE = "code";
	public static final String DELETED = "deleted";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String VERSION = "version";
	public static final String CONTENT = "content";

}

