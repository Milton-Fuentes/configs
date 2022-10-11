package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobCertificationAgency.class)
public abstract class GlobCertificationAgency_ {

	public static volatile SingularAttribute<GlobCertificationAgency, String> createdByIp;
	public static volatile SingularAttribute<GlobCertificationAgency, BigInteger> clientId;
	public static volatile SingularAttribute<GlobCertificationAgency, String> lastModBy;
	public static volatile SingularAttribute<GlobCertificationAgency, String> lastModIp;
	public static volatile SingularAttribute<GlobCertificationAgency, String> deleted;
	public static volatile SingularAttribute<GlobCertificationAgency, String> createdBy;
	public static volatile SingularAttribute<GlobCertificationAgency, Date> created;
	public static volatile SingularAttribute<GlobCertificationAgency, String> active;
	public static volatile ListAttribute<GlobCertificationAgency, GlobCertification> globCertificationList;
	public static volatile SingularAttribute<GlobCertificationAgency, BigDecimal> id;
	public static volatile SingularAttribute<GlobCertificationAgency, String> qualifyingAgency;
	public static volatile SingularAttribute<GlobCertificationAgency, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String GLOB_CERTIFICATION_LIST = "globCertificationList";
	public static final String ID = "id";
	public static final String QUALIFYING_AGENCY = "qualifyingAgency";
	public static final String LAST_MOD = "lastMod";

}

