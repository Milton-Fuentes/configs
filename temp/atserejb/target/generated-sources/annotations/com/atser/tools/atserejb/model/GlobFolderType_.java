package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFolderType.class)
public abstract class GlobFolderType_ {

	public static volatile SingularAttribute<GlobFolderType, GlobClient> clientId;
	public static volatile SingularAttribute<GlobFolderType, String> entityName;
	public static volatile SingularAttribute<GlobFolderType, String> entityType;
	public static volatile SingularAttribute<GlobFolderType, BigDecimal> id;
	public static volatile SingularAttribute<GlobFolderType, String> folderType;
	public static volatile SingularAttribute<GlobFolderType, BigInteger> defaultGroupNum;

	public static final String CLIENT_ID = "clientId";
	public static final String ENTITY_NAME = "entityName";
	public static final String ENTITY_TYPE = "entityType";
	public static final String ID = "id";
	public static final String FOLDER_TYPE = "folderType";
	public static final String DEFAULT_GROUP_NUM = "defaultGroupNum";

}

