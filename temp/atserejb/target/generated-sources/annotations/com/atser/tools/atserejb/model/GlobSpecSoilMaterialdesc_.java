package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSpecSoilMaterialdesc.class)
public abstract class GlobSpecSoilMaterialdesc_ {

	public static volatile SingularAttribute<GlobSpecSoilMaterialdesc, BigInteger> specificationId;
	public static volatile SingularAttribute<GlobSpecSoilMaterialdesc, String> createBy;
	public static volatile SingularAttribute<GlobSpecSoilMaterialdesc, String> lastModBy;
	public static volatile SingularAttribute<GlobSpecSoilMaterialdesc, String> lastModIp;
	public static volatile SingularAttribute<GlobSpecSoilMaterialdesc, String> materialdesc;
	public static volatile SingularAttribute<GlobSpecSoilMaterialdesc, String> chartType;
	public static volatile SingularAttribute<GlobSpecSoilMaterialdesc, Character> active;
	public static volatile SingularAttribute<GlobSpecSoilMaterialdesc, BigDecimal> id;
	public static volatile SingularAttribute<GlobSpecSoilMaterialdesc, String> lastMod;
	public static volatile SingularAttribute<GlobSpecSoilMaterialdesc, String> version;
	public static volatile SingularAttribute<GlobSpecSoilMaterialdesc, String> createByIp;
	public static volatile SingularAttribute<GlobSpecSoilMaterialdesc, Date> createDate;

	public static final String SPECIFICATION_ID = "specificationId";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String MATERIALDESC = "materialdesc";
	public static final String CHART_TYPE = "chartType";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_DATE = "createDate";

}

