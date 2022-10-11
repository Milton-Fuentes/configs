package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmBiditItemMaster.class)
public abstract class CmBiditItemMaster_ {

	public static volatile SingularAttribute<CmBiditItemMaster, String> itemType;
	public static volatile SingularAttribute<CmBiditItemMaster, String> createdByIp;
	public static volatile SingularAttribute<CmBiditItemMaster, BigInteger> clientId;
	public static volatile SingularAttribute<CmBiditItemMaster, Boolean> isParent;
	public static volatile SingularAttribute<CmBiditItemMaster, String> lastModBy;
	public static volatile SingularAttribute<CmBiditItemMaster, Date> created;
	public static volatile SingularAttribute<CmBiditItemMaster, String> description;
	public static volatile SingularAttribute<CmBiditItemMaster, Character> active;
	public static volatile SingularAttribute<CmBiditItemMaster, String> specNo;
	public static volatile SingularAttribute<CmBiditItemMaster, String> itemNo;
	public static volatile SingularAttribute<CmBiditItemMaster, Integer> version;
	public static volatile SingularAttribute<CmBiditItemMaster, BigInteger> parentId;
	public static volatile SingularAttribute<CmBiditItemMaster, QmCvlFieldData> unit;
	public static volatile SingularAttribute<CmBiditItemMaster, String> lastModIp;
	public static volatile SingularAttribute<CmBiditItemMaster, Character> deleted;
	public static volatile SingularAttribute<CmBiditItemMaster, String> createdBy;
	public static volatile SingularAttribute<CmBiditItemMaster, BigDecimal> id;
	public static volatile SingularAttribute<CmBiditItemMaster, QmCvlFieldData> category;
	public static volatile SingularAttribute<CmBiditItemMaster, Date> lastMod;

	public static final String ITEM_TYPE = "itemType";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String IS_PARENT = "isParent";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String SPEC_NO = "specNo";
	public static final String ITEM_NO = "itemNo";
	public static final String VERSION = "version";
	public static final String PARENT_ID = "parentId";
	public static final String UNIT = "unit";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String CATEGORY = "category";
	public static final String LAST_MOD = "lastMod";

}

