package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaPlistUpdate.class)
public abstract class QaPlistUpdate_ {

	public static volatile SingularAttribute<QaPlistUpdate, Date> updateDate;
	public static volatile SingularAttribute<QaPlistUpdate, String> lastModBy;
	public static volatile SingularAttribute<QaPlistUpdate, String> description;
	public static volatile SingularAttribute<QaPlistUpdate, String> version;
	public static volatile SingularAttribute<QaPlistUpdate, String> createByIp;
	public static volatile SingularAttribute<QaPlistUpdate, BigInteger> itemId;
	public static volatile SingularAttribute<QaPlistUpdate, String> createBy;
	public static volatile SingularAttribute<QaPlistUpdate, String> lastModIp;
	public static volatile SingularAttribute<QaPlistUpdate, String> updateBy;
	public static volatile SingularAttribute<QaPlistUpdate, String> itemPhoto;
	public static volatile SingularAttribute<QaPlistUpdate, BigDecimal> id;
	public static volatile SingularAttribute<QaPlistUpdate, String> lastMod;
	public static volatile SingularAttribute<QaPlistUpdate, String> updateNo;
	public static volatile SingularAttribute<QaPlistUpdate, Date> createDate;

	public static final String UPDATE_DATE = "updateDate";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String DESCRIPTION = "description";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String ITEM_ID = "itemId";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String UPDATE_BY = "updateBy";
	public static final String ITEM_PHOTO = "itemPhoto";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String UPDATE_NO = "updateNo";
	public static final String CREATE_DATE = "createDate";

}

