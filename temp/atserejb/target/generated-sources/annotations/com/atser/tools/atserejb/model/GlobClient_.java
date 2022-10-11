package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClient.class)
public abstract class GlobClient_ {

	public static volatile SingularAttribute<GlobClient, Character> showBidit;
	public static volatile SingularAttribute<GlobClient, String> city;
	public static volatile SingularAttribute<GlobClient, String> companyName;
	public static volatile SetAttribute<GlobClient, GlobClientTest> globClientTest;
	public static volatile SingularAttribute<GlobClient, String> description;
	public static volatile SingularAttribute<GlobClient, BigInteger> flagId;
	public static volatile SingularAttribute<GlobClient, String> cell;
	public static volatile SingularAttribute<GlobClient, String> keyBase;
	public static volatile SingularAttribute<GlobClient, Character> hasFlags;
	public static volatile ListAttribute<GlobClient, GlobFolderType> globFolderTypeList;
	public static volatile ListAttribute<GlobClient, GlobPhaseType> globPhaseTypeList;
	public static volatile SingularAttribute<GlobClient, String> useGlobalDCN;
	public static volatile SingularAttribute<GlobClient, String> defaultLanguage;
	public static volatile ListAttribute<GlobClient, GlobFileArchive> globFileArchiveList;
	public static volatile SingularAttribute<GlobClient, String> systemName;
	public static volatile SingularAttribute<GlobClient, String> managedBy;
	public static volatile ListAttribute<GlobClient, GlobCorrespd> globCorrespdList;
	public static volatile SingularAttribute<GlobClient, String> contact;
	public static volatile ListAttribute<GlobClient, GlobProfiles> globProfilesList;
	public static volatile SingularAttribute<GlobClient, BigDecimal> id;
	public static volatile SingularAttribute<GlobClient, String> state;
	public static volatile SingularAttribute<GlobClient, String> fax;
	public static volatile SingularAttribute<GlobClient, String> email;
	public static volatile SingularAttribute<GlobClient, String> zip;
	public static volatile SingularAttribute<GlobClient, Character> hasBpm;
	public static volatile SingularAttribute<GlobClient, String> address;
	public static volatile SingularAttribute<GlobClient, Character> active;
	public static volatile SingularAttribute<GlobClient, String> clientConfig;
	public static volatile ListAttribute<GlobClient, CmChangerequest> cmChangerequestList;
	public static volatile ListAttribute<GlobClient, GlobMenu> globMenuList;
	public static volatile ListAttribute<GlobClient, GlobClientRoles> globClientRolesList;
	public static volatile ListAttribute<GlobClient, GlobClientModules> globClientModulesList;
	public static volatile SingularAttribute<GlobClient, GlobCompanies> companyId;
	public static volatile SingularAttribute<GlobClient, String> phone;
	public static volatile ListAttribute<GlobClient, GlobProject> globProjectList;
	public static volatile SingularAttribute<GlobClient, String> name;
	public static volatile SingularAttribute<GlobClient, String> lastModTmp;
	public static volatile SingularAttribute<GlobClient, String> emailFrom;
	public static volatile ListAttribute<GlobClient, GlobProjectClient> globProjectClientList;
	public static volatile SingularAttribute<GlobClient, Date> lastMod;

	public static final String SHOW_BIDIT = "showBidit";
	public static final String CITY = "city";
	public static final String COMPANY_NAME = "companyName";
	public static final String GLOB_CLIENT_TEST = "globClientTest";
	public static final String DESCRIPTION = "description";
	public static final String FLAG_ID = "flagId";
	public static final String CELL = "cell";
	public static final String KEY_BASE = "keyBase";
	public static final String HAS_FLAGS = "hasFlags";
	public static final String GLOB_FOLDER_TYPE_LIST = "globFolderTypeList";
	public static final String GLOB_PHASE_TYPE_LIST = "globPhaseTypeList";
	public static final String USE_GLOBAL_DC_N = "useGlobalDCN";
	public static final String DEFAULT_LANGUAGE = "defaultLanguage";
	public static final String GLOB_FILE_ARCHIVE_LIST = "globFileArchiveList";
	public static final String SYSTEM_NAME = "systemName";
	public static final String MANAGED_BY = "managedBy";
	public static final String GLOB_CORRESPD_LIST = "globCorrespdList";
	public static final String CONTACT = "contact";
	public static final String GLOB_PROFILES_LIST = "globProfilesList";
	public static final String ID = "id";
	public static final String STATE = "state";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";
	public static final String ZIP = "zip";
	public static final String HAS_BPM = "hasBpm";
	public static final String ADDRESS = "address";
	public static final String ACTIVE = "active";
	public static final String CLIENT_CONFIG = "clientConfig";
	public static final String CM_CHANGEREQUEST_LIST = "cmChangerequestList";
	public static final String GLOB_MENU_LIST = "globMenuList";
	public static final String GLOB_CLIENT_ROLES_LIST = "globClientRolesList";
	public static final String GLOB_CLIENT_MODULES_LIST = "globClientModulesList";
	public static final String COMPANY_ID = "companyId";
	public static final String PHONE = "phone";
	public static final String GLOB_PROJECT_LIST = "globProjectList";
	public static final String NAME = "name";
	public static final String LAST_MOD_TMP = "lastModTmp";
	public static final String EMAIL_FROM = "emailFrom";
	public static final String GLOB_PROJECT_CLIENT_LIST = "globProjectClientList";
	public static final String LAST_MOD = "lastMod";

}

