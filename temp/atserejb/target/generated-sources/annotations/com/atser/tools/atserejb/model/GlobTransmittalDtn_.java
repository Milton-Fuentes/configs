package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobTransmittalDtn.class)
public abstract class GlobTransmittalDtn_ {

	public static volatile SingularAttribute<GlobTransmittalDtn, String> createdByIp;
	public static volatile SingularAttribute<GlobTransmittalDtn, String> lastModBy;
	public static volatile SingularAttribute<GlobTransmittalDtn, Date> created;
	public static volatile SingularAttribute<GlobTransmittalDtn, String> trtoken;
	public static volatile SingularAttribute<GlobTransmittalDtn, Character> active;
	public static volatile SingularAttribute<GlobTransmittalDtn, Integer> version;
	public static volatile SingularAttribute<GlobTransmittalDtn, Character> emailStatus;
	public static volatile SingularAttribute<GlobTransmittalDtn, String> lastModIp;
	public static volatile SingularAttribute<GlobTransmittalDtn, Character> deleted;
	public static volatile SingularAttribute<GlobTransmittalDtn, Character> aknowledged;
	public static volatile SingularAttribute<GlobTransmittalDtn, String> createdBy;
	public static volatile SingularAttribute<GlobTransmittalDtn, BigDecimal> idStk;
	public static volatile SingularAttribute<GlobTransmittalDtn, GlobTransmittal> dtTransmittal;
	public static volatile SingularAttribute<GlobTransmittalDtn, BigDecimal> id;
	public static volatile SingularAttribute<GlobTransmittalDtn, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String TRTOKEN = "trtoken";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String EMAIL_STATUS = "emailStatus";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String AKNOWLEDGED = "aknowledged";
	public static final String CREATED_BY = "createdBy";
	public static final String ID_STK = "idStk";
	public static final String DT_TRANSMITTAL = "dtTransmittal";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

