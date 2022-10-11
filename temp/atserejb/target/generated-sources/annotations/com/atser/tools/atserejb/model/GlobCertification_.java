package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobCertification.class)
public abstract class GlobCertification_ {

	public static volatile SingularAttribute<GlobCertification, String> createdByIp;
	public static volatile SingularAttribute<GlobCertification, String> lastModBy;
	public static volatile SingularAttribute<GlobCertification, String> acronym;
	public static volatile SingularAttribute<GlobCertification, Date> created;
	public static volatile SingularAttribute<GlobCertification, String> active;
	public static volatile SingularAttribute<GlobCertification, GlobCertificationAgency> agencyId;
	public static volatile SingularAttribute<GlobCertification, String> qualification;
	public static volatile SingularAttribute<GlobCertification, String> lastModIp;
	public static volatile SingularAttribute<GlobCertification, String> deleted;
	public static volatile ListAttribute<GlobCertification, GlobCertificationTest> globCertificationTestList;
	public static volatile SingularAttribute<GlobCertification, String> createdBy;
	public static volatile SingularAttribute<GlobCertification, BigDecimal> id;
	public static volatile SingularAttribute<GlobCertification, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String ACRONYM = "acronym";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String AGENCY_ID = "agencyId";
	public static final String QUALIFICATION = "qualification";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String GLOB_CERTIFICATION_TEST_LIST = "globCertificationTestList";
	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

