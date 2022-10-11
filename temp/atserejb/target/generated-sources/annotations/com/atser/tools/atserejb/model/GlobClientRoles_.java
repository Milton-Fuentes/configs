package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientRoles.class)
public abstract class GlobClientRoles_ {

	public static volatile SingularAttribute<GlobClientRoles, GlobClient> clientId;
	public static volatile SingularAttribute<GlobClientRoles, String> rolesTitle;
	public static volatile SingularAttribute<GlobClientRoles, String> projectType;
	public static volatile SingularAttribute<GlobClientRoles, GlobRoles> rolesId;
	public static volatile SingularAttribute<GlobClientRoles, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientRoles, GlobModule> moduleId;

	public static final String CLIENT_ID = "clientId";
	public static final String ROLES_TITLE = "rolesTitle";
	public static final String PROJECT_TYPE = "projectType";
	public static final String ROLES_ID = "rolesId";
	public static final String ID = "id";
	public static final String MODULE_ID = "moduleId";

}

