package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobActivityPayitem.class)
public abstract class GlobActivityPayitem_ {

	public static volatile SingularAttribute<GlobActivityPayitem, String> payitem;
	public static volatile SingularAttribute<GlobActivityPayitem, BigInteger> itemType;
	public static volatile SingularAttribute<GlobActivityPayitem, BigInteger> clientId;
	public static volatile SingularAttribute<GlobActivityPayitem, String> lastModBy;
	public static volatile SingularAttribute<GlobActivityPayitem, String> activity;
	public static volatile SingularAttribute<GlobActivityPayitem, String> maintGroup;
	public static volatile SingularAttribute<GlobActivityPayitem, String> description;
	public static volatile SingularAttribute<GlobActivityPayitem, String> version;
	public static volatile SingularAttribute<GlobActivityPayitem, String> createByIp;
	public static volatile SingularAttribute<GlobActivityPayitem, String> unit;
	public static volatile SingularAttribute<GlobActivityPayitem, String> createBy;
	public static volatile SingularAttribute<GlobActivityPayitem, String> lastModIp;
	public static volatile SingularAttribute<GlobActivityPayitem, BigDecimal> id;
	public static volatile SingularAttribute<GlobActivityPayitem, String> lastMod;

	public static final String PAYITEM = "payitem";
	public static final String ITEM_TYPE = "itemType";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String ACTIVITY = "activity";
	public static final String MAINT_GROUP = "maintGroup";
	public static final String DESCRIPTION = "description";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String UNIT = "unit";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

