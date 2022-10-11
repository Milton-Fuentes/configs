package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmDailyLocation.class)
public abstract class CmDailyLocation_ {

	public static volatile SingularAttribute<CmDailyLocation, String> createBy;
	public static volatile SingularAttribute<CmDailyLocation, String> lastModBy;
	public static volatile SingularAttribute<CmDailyLocation, String> lastModIp;
	public static volatile SingularAttribute<CmDailyLocation, BigInteger> contractId;
	public static volatile SingularAttribute<CmDailyLocation, String> description;
	public static volatile SingularAttribute<CmDailyLocation, String> location;
	public static volatile SingularAttribute<CmDailyLocation, BigDecimal> id;
	public static volatile SingularAttribute<CmDailyLocation, String> lastMod;
	public static volatile SingularAttribute<CmDailyLocation, String> version;
	public static volatile SingularAttribute<CmDailyLocation, String> createByIp;

	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String CONTRACT_ID = "contractId";
	public static final String DESCRIPTION = "description";
	public static final String LOCATION = "location";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";

}

