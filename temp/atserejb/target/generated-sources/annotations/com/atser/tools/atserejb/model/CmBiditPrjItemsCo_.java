package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmBiditPrjItemsCo.class)
public abstract class CmBiditPrjItemsCo_ {

	public static volatile SingularAttribute<CmBiditPrjItemsCo, BigDecimal> unitPrice;
	public static volatile SingularAttribute<CmBiditPrjItemsCo, String> createdByIp;
	public static volatile SingularAttribute<CmBiditPrjItemsCo, String> lastModBy;
	public static volatile SingularAttribute<CmBiditPrjItemsCo, BigDecimal> totalPrice;
	public static volatile SingularAttribute<CmBiditPrjItemsCo, Date> created;
	public static volatile SingularAttribute<CmBiditPrjItemsCo, Character> active;
	public static volatile SingularAttribute<CmBiditPrjItemsCo, Integer> version;
	public static volatile SingularAttribute<CmBiditPrjItemsCo, String> lastModIp;
	public static volatile SingularAttribute<CmBiditPrjItemsCo, Character> deleted;
	public static volatile SingularAttribute<CmBiditPrjItemsCo, String> createdBy;
	public static volatile SingularAttribute<CmBiditPrjItemsCo, BigInteger> profileId;
	public static volatile SingularAttribute<CmBiditPrjItemsCo, BigDecimal> qty;
	public static volatile SingularAttribute<CmBiditPrjItemsCo, BigInteger> prjItemId;
	public static volatile SingularAttribute<CmBiditPrjItemsCo, BigDecimal> id;
	public static volatile SingularAttribute<CmBiditPrjItemsCo, Date> lastMod;

	public static final String UNIT_PRICE = "unitPrice";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String TOTAL_PRICE = "totalPrice";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String PROFILE_ID = "profileId";
	public static final String QTY = "qty";
	public static final String PRJ_ITEM_ID = "prjItemId";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

