package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmEmGroup.class)
public abstract class CmEmGroup_ {

	public static volatile SingularAttribute<CmEmGroup, String> lastModBy;
	public static volatile SingularAttribute<CmEmGroup, BigInteger> clientId;
	public static volatile ListAttribute<CmEmGroup, GlobUsers> globUsersList;
	public static volatile SingularAttribute<CmEmGroup, String> description;
	public static volatile SingularAttribute<CmEmGroup, String> version;
	public static volatile SingularAttribute<CmEmGroup, String> createByIp;
	public static volatile SingularAttribute<CmEmGroup, String> createBy;
	public static volatile SingularAttribute<CmEmGroup, String> lastModIp;
	public static volatile SingularAttribute<CmEmGroup, String> name;
	public static volatile SingularAttribute<CmEmGroup, BigDecimal> id;
	public static volatile SingularAttribute<CmEmGroup, String> lastMod;
	public static volatile SingularAttribute<CmEmGroup, Date> createDate;
	public static volatile SingularAttribute<CmEmGroup, Short> status;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CLIENT_ID = "clientId";
	public static final String GLOB_USERS_LIST = "globUsersList";
	public static final String DESCRIPTION = "description";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";
	public static final String STATUS = "status";

}

