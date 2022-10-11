package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmBiditSignflowdef.class)
public abstract class CmBiditSignflowdef_ {

	public static volatile SingularAttribute<CmBiditSignflowdef, String> createdByIp;
	public static volatile SingularAttribute<CmBiditSignflowdef, GlobSystemSimpleCat> simplecatId;
	public static volatile SingularAttribute<CmBiditSignflowdef, BigInteger> clientId;
	public static volatile SingularAttribute<CmBiditSignflowdef, String> signRuleName;
	public static volatile SingularAttribute<CmBiditSignflowdef, String> lastModBy;
	public static volatile SingularAttribute<CmBiditSignflowdef, Date> created;
	public static volatile SingularAttribute<CmBiditSignflowdef, Character> active;
	public static volatile SingularAttribute<CmBiditSignflowdef, Integer> version;
	public static volatile SingularAttribute<CmBiditSignflowdef, BigInteger> signOrder;
	public static volatile SingularAttribute<CmBiditSignflowdef, String> lastModIp;
	public static volatile SingularAttribute<CmBiditSignflowdef, Character> deleted;
	public static volatile SingularAttribute<CmBiditSignflowdef, String> createdBy;
	public static volatile ListAttribute<CmBiditSignflowdef, CmBiditSigninfo> cmBiditSigninfoList;
	public static volatile SingularAttribute<CmBiditSignflowdef, GlobSystemSimpleCat> typeId;
	public static volatile SingularAttribute<CmBiditSignflowdef, BigDecimal> id;
	public static volatile SingularAttribute<CmBiditSignflowdef, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String SIMPLECAT_ID = "simplecatId";
	public static final String CLIENT_ID = "clientId";
	public static final String SIGN_RULE_NAME = "signRuleName";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String SIGN_ORDER = "signOrder";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String CM_BIDIT_SIGNINFO_LIST = "cmBiditSigninfoList";
	public static final String TYPE_ID = "typeId";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

