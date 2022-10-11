package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwCmBiditPrjItemsCo.class)
public abstract class VwCmBiditPrjItemsCo_ {

	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, BigDecimal> unitPrice;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, String> itemType;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, BigInteger> itemAddendumRev;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, Boolean> isParent;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, BigDecimal> finalQty;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, BigDecimal> totalPrice;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, BigDecimal> defaultQty;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, String> description;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, String> specNo;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, String> itemNo;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, BigInteger> userId;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, BigInteger> parentId;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, Character> prjItemsActive;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, BigDecimal> userQty;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, String> unit;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, BigInteger> companyId;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, Boolean> isQtyEditable;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, BigInteger> profileId;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, BigInteger> prjCatgId;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, BigInteger> prjItemId;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, BigInteger> unitId;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, BigDecimal> id;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, String> category;
	public static volatile SingularAttribute<VwCmBiditPrjItemsCo, BigInteger> categoryId;

	public static final String UNIT_PRICE = "unitPrice";
	public static final String ITEM_TYPE = "itemType";
	public static final String ITEM_ADDENDUM_REV = "itemAddendumRev";
	public static final String IS_PARENT = "isParent";
	public static final String FINAL_QTY = "finalQty";
	public static final String TOTAL_PRICE = "totalPrice";
	public static final String DEFAULT_QTY = "defaultQty";
	public static final String DESCRIPTION = "description";
	public static final String SPEC_NO = "specNo";
	public static final String ITEM_NO = "itemNo";
	public static final String USER_ID = "userId";
	public static final String PARENT_ID = "parentId";
	public static final String PRJ_ITEMS_ACTIVE = "prjItemsActive";
	public static final String USER_QTY = "userQty";
	public static final String UNIT = "unit";
	public static final String COMPANY_ID = "companyId";
	public static final String IS_QTY_EDITABLE = "isQtyEditable";
	public static final String PROFILE_ID = "profileId";
	public static final String PRJ_CATG_ID = "prjCatgId";
	public static final String PRJ_ITEM_ID = "prjItemId";
	public static final String UNIT_ID = "unitId";
	public static final String ID = "id";
	public static final String CATEGORY = "category";
	public static final String CATEGORY_ID = "categoryId";

}

