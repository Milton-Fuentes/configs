package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobRoles.class)
public abstract class GlobRoles_ {

	public static volatile SingularAttribute<GlobRoles, Date> temp;
	public static volatile SingularAttribute<GlobRoles, String> lastModBy;
	public static volatile SingularAttribute<GlobRoles, String> createDateTmp;
	public static volatile SingularAttribute<GlobRoles, String> tempTmp;
	public static volatile SingularAttribute<GlobRoles, String> shortdesc;
	public static volatile SingularAttribute<GlobRoles, String> description;
	public static volatile SingularAttribute<GlobRoles, Character> active;
	public static volatile SingularAttribute<GlobRoles, Character> isReq;
	public static volatile ListAttribute<GlobRoles, GlobClientRoles> globClientRolesList;
	public static volatile SingularAttribute<GlobRoles, String> createByIp;
	public static volatile SingularAttribute<GlobRoles, String> createBy;
	public static volatile SingularAttribute<GlobRoles, BigInteger> functionId;
	public static volatile SingularAttribute<GlobRoles, String> lastModIp;
	public static volatile SingularAttribute<GlobRoles, String> roleName;
	public static volatile SingularAttribute<GlobRoles, String> lastModTmp;
	public static volatile ListAttribute<GlobRoles, GlobProfiles> globProfilesList;
	public static volatile SingularAttribute<GlobRoles, BigDecimal> id;
	public static volatile SingularAttribute<GlobRoles, Date> lastMod;
	public static volatile SingularAttribute<GlobRoles, Date> createDate;

	public static final String TEMP = "temp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATE_DATE_TMP = "createDateTmp";
	public static final String TEMP_TMP = "tempTmp";
	public static final String SHORTDESC = "shortdesc";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String IS_REQ = "isReq";
	public static final String GLOB_CLIENT_ROLES_LIST = "globClientRolesList";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_BY = "createBy";
	public static final String FUNCTION_ID = "functionId";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ROLE_NAME = "roleName";
	public static final String LAST_MOD_TMP = "lastModTmp";
	public static final String GLOB_PROFILES_LIST = "globProfilesList";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";

}

