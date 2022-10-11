package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobMenu.class)
public abstract class GlobMenu_ {

	public static volatile SingularAttribute<GlobMenu, String> hyperlink;
	public static volatile SingularAttribute<GlobMenu, String> itemType;
	public static volatile SingularAttribute<GlobMenu, BigInteger> visible;
	public static volatile SingularAttribute<GlobMenu, BigInteger> clientId;
	public static volatile SingularAttribute<GlobMenu, BigInteger> phaseId;
	public static volatile SingularAttribute<GlobMenu, String> caption;
	public static volatile SingularAttribute<GlobMenu, String> subNo;
	public static volatile SingularAttribute<GlobMenu, BigInteger> parentId;
	public static volatile SingularAttribute<GlobMenu, String> target;
	public static volatile SingularAttribute<GlobMenu, String> condition;
	public static volatile SingularAttribute<GlobMenu, String> areaName;
	public static volatile SingularAttribute<GlobMenu, BigInteger> tabOrder;
	public static volatile SingularAttribute<GlobMenu, BigDecimal> id;
	public static volatile SingularAttribute<GlobMenu, String> shortName;
	public static volatile SingularAttribute<GlobMenu, BigInteger> moduleId;
	public static volatile SingularAttribute<GlobMenu, String> tabImageType;

	public static final String HYPERLINK = "hyperlink";
	public static final String ITEM_TYPE = "itemType";
	public static final String VISIBLE = "visible";
	public static final String CLIENT_ID = "clientId";
	public static final String PHASE_ID = "phaseId";
	public static final String CAPTION = "caption";
	public static final String SUB_NO = "subNo";
	public static final String PARENT_ID = "parentId";
	public static final String TARGET = "target";
	public static final String CONDITION = "condition";
	public static final String AREA_NAME = "areaName";
	public static final String TAB_ORDER = "tabOrder";
	public static final String ID = "id";
	public static final String SHORT_NAME = "shortName";
	public static final String MODULE_ID = "moduleId";
	public static final String TAB_IMAGE_TYPE = "tabImageType";

}

