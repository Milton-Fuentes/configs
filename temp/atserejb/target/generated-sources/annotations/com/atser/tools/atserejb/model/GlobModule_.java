package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobModule.class)
public abstract class GlobModule_ {

	public static volatile SingularAttribute<GlobModule, String> startPage;
	public static volatile SingularAttribute<GlobModule, String> folder;
	public static volatile SingularAttribute<GlobModule, String> moduleName;
	public static volatile SingularAttribute<GlobModule, BigDecimal> id;
	public static volatile ListAttribute<GlobModule, GlobFlagsModule> globFlagsModuleList;
	public static volatile ListAttribute<GlobModule, GlobClientRoles> globClientRolesList;
	public static volatile ListAttribute<GlobModule, GlobClientModules> globClientModulesList;

	public static final String START_PAGE = "startPage";
	public static final String FOLDER = "folder";
	public static final String MODULE_NAME = "moduleName";
	public static final String ID = "id";
	public static final String GLOB_FLAGS_MODULE_LIST = "globFlagsModuleList";
	public static final String GLOB_CLIENT_ROLES_LIST = "globClientRolesList";
	public static final String GLOB_CLIENT_MODULES_LIST = "globClientModulesList";

}

