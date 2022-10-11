package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientModules.class)
public abstract class GlobClientModules_ {

	public static volatile SingularAttribute<GlobClientModules, String> moduleTitle;
	public static volatile SingularAttribute<GlobClientModules, String> moduleStartPage;
	public static volatile SingularAttribute<GlobClientModules, GlobClient> customerId;
	public static volatile SingularAttribute<GlobClientModules, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientModules, GlobModule> moduleId;

	public static final String MODULE_TITLE = "moduleTitle";
	public static final String MODULE_START_PAGE = "moduleStartPage";
	public static final String CUSTOMER_ID = "customerId";
	public static final String ID = "id";
	public static final String MODULE_ID = "moduleId";

}

