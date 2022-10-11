package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectInsptplanItem.class)
public abstract class GlobProjectInsptplanItem_ {

	public static volatile SingularAttribute<GlobProjectInsptplanItem, String> unit;
	public static volatile SingularAttribute<GlobProjectInsptplanItem, String> createBy;
	public static volatile SingularAttribute<GlobProjectInsptplanItem, String> lastModBy;
	public static volatile SingularAttribute<GlobProjectInsptplanItem, String> lastModIp;
	public static volatile SingularAttribute<GlobProjectInsptplanItem, BigInteger> insptplanId;
	public static volatile SingularAttribute<GlobProjectInsptplanItem, String> description;
	public static volatile SingularAttribute<GlobProjectInsptplanItem, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectInsptplanItem, String> itemNo;
	public static volatile SingularAttribute<GlobProjectInsptplanItem, Double> plan;
	public static volatile SingularAttribute<GlobProjectInsptplanItem, String> lastMod;
	public static volatile SingularAttribute<GlobProjectInsptplanItem, String> version;
	public static volatile SingularAttribute<GlobProjectInsptplanItem, String> createByIp;

	public static final String UNIT = "unit";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String INSPTPLAN_ID = "insptplanId";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String ITEM_NO = "itemNo";
	public static final String PLAN = "plan";
	public static final String LAST_MOD = "lastMod";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";

}

