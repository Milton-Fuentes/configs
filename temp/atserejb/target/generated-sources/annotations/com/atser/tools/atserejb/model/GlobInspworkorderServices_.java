package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobInspworkorderServices.class)
public abstract class GlobInspworkorderServices_ {

	public static volatile SingularAttribute<GlobInspworkorderServices, BigInteger> iwoId;
	public static volatile SingularAttribute<GlobInspworkorderServices, String> lastModBy;
	public static volatile SingularAttribute<GlobInspworkorderServices, String> lastModIp;
	public static volatile SingularAttribute<GlobInspworkorderServices, String> service;
	public static volatile SingularAttribute<GlobInspworkorderServices, String> serviceDescription;
	public static volatile SingularAttribute<GlobInspworkorderServices, BigDecimal> id;
	public static volatile SingularAttribute<GlobInspworkorderServices, BigInteger> serviceId;
	public static volatile SingularAttribute<GlobInspworkorderServices, String> type;
	public static volatile SingularAttribute<GlobInspworkorderServices, String> lastMod;

	public static final String IWO_ID = "iwoId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String SERVICE = "service";
	public static final String SERVICE_DESCRIPTION = "serviceDescription";
	public static final String ID = "id";
	public static final String SERVICE_ID = "serviceId";
	public static final String TYPE = "type";
	public static final String LAST_MOD = "lastMod";

}

