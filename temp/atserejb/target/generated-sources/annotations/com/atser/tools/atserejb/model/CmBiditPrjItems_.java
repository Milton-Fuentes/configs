package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmBiditPrjItems.class)
public abstract class CmBiditPrjItems_ {

	public static volatile SingularAttribute<CmBiditPrjItems, String> itemType;
	public static volatile SingularAttribute<CmBiditPrjItems, BigInteger> itemAddendumRev;
	public static volatile SingularAttribute<CmBiditPrjItems, String> createdByIp;
	public static volatile SingularAttribute<CmBiditPrjItems, Boolean> isParent;
	public static volatile SingularAttribute<CmBiditPrjItems, String> lastModBy;
	public static volatile ListAttribute<CmBiditPrjItems, CmBiditPrjItemsCo> cmBiditPrjItemsCoList;
	public static volatile SingularAttribute<CmBiditPrjItems, BigDecimal> defaultQty;
	public static volatile SingularAttribute<CmBiditPrjItems, Date> created;
	public static volatile SingularAttribute<CmBiditPrjItems, String> description;
	public static volatile SingularAttribute<CmBiditPrjItems, Character> active;
	public static volatile SingularAttribute<CmBiditPrjItems, String> specNo;
	public static volatile SingularAttribute<CmBiditPrjItems, String> itemNo;
	public static volatile SingularAttribute<CmBiditPrjItems, Integer> version;
	public static volatile SingularAttribute<CmBiditPrjItems, BigInteger> parentId;
	public static volatile SingularAttribute<CmBiditPrjItems, QmCvlFieldData> unit;
	public static volatile SingularAttribute<CmBiditPrjItems, String> lastModIp;
	public static volatile SingularAttribute<CmBiditPrjItems, Character> deleted;
	public static volatile SingularAttribute<CmBiditPrjItems, Boolean> isQtyEditable;
	public static volatile SingularAttribute<CmBiditPrjItems, String> createdBy;
	public static volatile SingularAttribute<CmBiditPrjItems, BigInteger> prjCatgId;
	public static volatile SingularAttribute<CmBiditPrjItems, BigInteger> itemRefId;
	public static volatile SingularAttribute<CmBiditPrjItems, BigDecimal> id;
	public static volatile SingularAttribute<CmBiditPrjItems, QmCvlFieldData> category;
	public static volatile SingularAttribute<CmBiditPrjItems, Date> lastMod;

	public static final String ITEM_TYPE = "itemType";
	public static final String ITEM_ADDENDUM_REV = "itemAddendumRev";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String IS_PARENT = "isParent";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CM_BIDIT_PRJ_ITEMS_CO_LIST = "cmBiditPrjItemsCoList";
	public static final String DEFAULT_QTY = "defaultQty";
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
	public static final String IS_QTY_EDITABLE = "isQtyEditable";
	public static final String CREATED_BY = "createdBy";
	public static final String PRJ_CATG_ID = "prjCatgId";
	public static final String ITEM_REF_ID = "itemRefId";
	public static final String ID = "id";
	public static final String CATEGORY = "category";
	public static final String LAST_MOD = "lastMod";

}

