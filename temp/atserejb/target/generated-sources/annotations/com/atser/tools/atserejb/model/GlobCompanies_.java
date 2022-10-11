package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobCompanies.class)
public abstract class GlobCompanies_ {

	public static volatile SingularAttribute<GlobCompanies, String> companyCode;
	public static volatile SingularAttribute<GlobCompanies, String> shortdesc;
	public static volatile SingularAttribute<GlobCompanies, String> lastModTmp;
	public static volatile SingularAttribute<GlobCompanies, String> description;
	public static volatile SingularAttribute<GlobCompanies, Character> active;
	public static volatile SingularAttribute<GlobCompanies, BigDecimal> id;
	public static volatile ListAttribute<GlobCompanies, GlobClient> globClientList;
	public static volatile ListAttribute<GlobCompanies, GlobProjectClient> globProjectClientList;
	public static volatile SingularAttribute<GlobCompanies, Date> lastMod;

	public static final String COMPANY_CODE = "companyCode";
	public static final String SHORTDESC = "shortdesc";
	public static final String LAST_MOD_TMP = "lastModTmp";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String GLOB_CLIENT_LIST = "globClientList";
	public static final String GLOB_PROJECT_CLIENT_LIST = "globProjectClientList";
	public static final String LAST_MOD = "lastMod";

}

