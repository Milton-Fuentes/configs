package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectInsptplanDetails.class)
public abstract class GlobProjectInsptplanDetails_ {

	public static volatile SingularAttribute<GlobProjectInsptplanDetails, Double> planQty;
	public static volatile SingularAttribute<GlobProjectInsptplanDetails, Double> placeQty;
	public static volatile SingularAttribute<GlobProjectInsptplanDetails, String> lastModBy;
	public static volatile SingularAttribute<GlobProjectInsptplanDetails, Date> toDate;
	public static volatile SingularAttribute<GlobProjectInsptplanDetails, String> version;
	public static volatile SingularAttribute<GlobProjectInsptplanDetails, String> createByIp;
	public static volatile SingularAttribute<GlobProjectInsptplanDetails, Date> fromDate;
	public static volatile SingularAttribute<GlobProjectInsptplanDetails, BigInteger> itemId;
	public static volatile SingularAttribute<GlobProjectInsptplanDetails, String> createBy;
	public static volatile SingularAttribute<GlobProjectInsptplanDetails, String> lastModIp;
	public static volatile SingularAttribute<GlobProjectInsptplanDetails, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectInsptplanDetails, Double> appvQty;
	public static volatile SingularAttribute<GlobProjectInsptplanDetails, String> lastMod;

	public static final String PLAN_QTY = "planQty";
	public static final String PLACE_QTY = "placeQty";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String TO_DATE = "toDate";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String FROM_DATE = "fromDate";
	public static final String ITEM_ID = "itemId";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ID = "id";
	public static final String APPV_QTY = "appvQty";
	public static final String LAST_MOD = "lastMod";

}

