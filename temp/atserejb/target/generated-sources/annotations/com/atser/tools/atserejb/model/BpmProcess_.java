package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BpmProcess.class)
public abstract class BpmProcess_ {

	public static volatile SingularAttribute<BpmProcess, String> createdByIp;
	public static volatile SingularAttribute<BpmProcess, String> code;
	public static volatile SingularAttribute<BpmProcess, String> lastModBy;
	public static volatile SingularAttribute<BpmProcess, String> serviceClass;
	public static volatile SingularAttribute<BpmProcess, Date> created;
	public static volatile SingularAttribute<BpmProcess, String> description;
	public static volatile SingularAttribute<BpmProcess, String> active;
	public static volatile SingularAttribute<BpmProcess, String> lastModByIp;
	public static volatile SingularAttribute<BpmProcess, Integer> requiredRespDays;
	public static volatile SingularAttribute<BpmProcess, String> deleted;
	public static volatile SingularAttribute<BpmProcess, String> createdBy;
	public static volatile SingularAttribute<BpmProcess, String> name;
	public static volatile SingularAttribute<BpmProcess, BigDecimal> id;
	public static volatile SingularAttribute<BpmProcess, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CODE = "code";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String SERVICE_CLASS = "serviceClass";
	public static final String CREATED = "created";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String LAST_MOD_BY_IP = "lastModByIp";
	public static final String REQUIRED_RESP_DAYS = "requiredRespDays";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

