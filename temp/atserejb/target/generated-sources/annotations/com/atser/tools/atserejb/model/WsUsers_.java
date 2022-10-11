package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(WsUsers.class)
public abstract class WsUsers_ {

	public static volatile SingularAttribute<WsUsers, String> lastName;
	public static volatile SingularAttribute<WsUsers, String> lastModBy;
	public static volatile SingularAttribute<WsUsers, Integer> cookie_xtime;
	public static volatile SingularAttribute<WsUsers, String> phonenumber;
	public static volatile SingularAttribute<WsUsers, Date> lastLoginDate;
	public static volatile SingularAttribute<WsUsers, Date> lockedTime;
	public static volatile SingularAttribute<WsUsers, String> password;
	public static volatile SingularAttribute<WsUsers, String> lastModIp;
	public static volatile SingularAttribute<WsUsers, BigDecimal> id;
	public static volatile SingularAttribute<WsUsers, Character> locked;
	public static volatile SingularAttribute<WsUsers, String> email;
	public static volatile ListAttribute<WsUsers, WsOauth> wsOauthList;
	public static volatile SingularAttribute<WsUsers, String> createdByIp;
	public static volatile SingularAttribute<WsUsers, BigInteger> clientId;
	public static volatile SingularAttribute<WsUsers, String> salt;
	public static volatile SingularAttribute<WsUsers, Date> created;
	public static volatile SingularAttribute<WsUsers, Character> active;
	public static volatile SingularAttribute<WsUsers, BigInteger> badAuthAttempts;
	public static volatile SingularAttribute<WsUsers, Integer> version;
	public static volatile ListAttribute<WsUsers, WsRigths> wsRigthsList;
	public static volatile SingularAttribute<WsUsers, Character> deleted;
	public static volatile SingularAttribute<WsUsers, String> createdBy;
	public static volatile SingularAttribute<WsUsers, String> name;
	public static volatile SingularAttribute<WsUsers, String> category;
	public static volatile SingularAttribute<WsUsers, Date> lastMod;
	public static volatile SingularAttribute<WsUsers, String> username;

	public static final String LAST_NAME = "lastName";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String COOKIE_XTIME = "cookie_xtime";
	public static final String PHONENUMBER = "phonenumber";
	public static final String LAST_LOGIN_DATE = "lastLoginDate";
	public static final String LOCKED_TIME = "lockedTime";
	public static final String PASSWORD = "password";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ID = "id";
	public static final String LOCKED = "locked";
	public static final String EMAIL = "email";
	public static final String WS_OAUTH_LIST = "wsOauthList";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String SALT = "salt";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String BAD_AUTH_ATTEMPTS = "badAuthAttempts";
	public static final String VERSION = "version";
	public static final String WS_RIGTHS_LIST = "wsRigthsList";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String NAME = "name";
	public static final String CATEGORY = "category";
	public static final String LAST_MOD = "lastMod";
	public static final String USERNAME = "username";

}

