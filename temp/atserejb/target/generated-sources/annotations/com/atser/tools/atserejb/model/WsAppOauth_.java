package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(WsAppOauth.class)
public abstract class WsAppOauth_ {

	public static volatile SingularAttribute<WsAppOauth, Date> expiryDate;
	public static volatile SingularAttribute<WsAppOauth, BigInteger> clientId;
	public static volatile SingularAttribute<WsAppOauth, Date> created;
	public static volatile SingularAttribute<WsAppOauth, String> webServerRedirect;
	public static volatile SingularAttribute<WsAppOauth, Character> active;
	public static volatile SingularAttribute<WsAppOauth, BigDecimal> id;
	public static volatile SingularAttribute<WsAppOauth, String> accessToken;
	public static volatile SingularAttribute<WsAppOauth, GlobUsers> userid;
	public static volatile SingularAttribute<WsAppOauth, String> refreshToken;

	public static final String EXPIRY_DATE = "expiryDate";
	public static final String CLIENT_ID = "clientId";
	public static final String CREATED = "created";
	public static final String WEB_SERVER_REDIRECT = "webServerRedirect";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String ACCESS_TOKEN = "accessToken";
	public static final String USERID = "userid";
	public static final String REFRESH_TOKEN = "refreshToken";

}

