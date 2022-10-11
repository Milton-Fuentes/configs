package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmTiFolderMap.class)
public abstract class CmTiFolderMap_ {

	public static volatile SingularAttribute<CmTiFolderMap, BigInteger> clientId;
	public static volatile SingularAttribute<CmTiFolderMap, BigInteger> tiParentId;
	public static volatile SingularAttribute<CmTiFolderMap, BigInteger> tiDefaultGroupNum;
	public static volatile SingularAttribute<CmTiFolderMap, BigDecimal> id;
	public static volatile SingularAttribute<CmTiFolderMap, BigInteger> cmFncId;
	public static volatile SingularAttribute<CmTiFolderMap, String> cmTypeName;
	public static volatile SingularAttribute<CmTiFolderMap, BigInteger> tiDefaultId;

	public static final String CLIENT_ID = "clientId";
	public static final String TI_PARENT_ID = "tiParentId";
	public static final String TI_DEFAULT_GROUP_NUM = "tiDefaultGroupNum";
	public static final String ID = "id";
	public static final String CM_FNC_ID = "cmFncId";
	public static final String CM_TYPE_NAME = "cmTypeName";
	public static final String TI_DEFAULT_ID = "tiDefaultId";

}

