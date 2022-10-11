package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QmClientRoleMatrix.class)
public abstract class QmClientRoleMatrix_ {

	public static volatile SingularAttribute<QmClientRoleMatrix, Character> noRights;
	public static volatile SingularAttribute<QmClientRoleMatrix, BigInteger> clientId;
	public static volatile SingularAttribute<QmClientRoleMatrix, String> lastModBy;
	public static volatile SingularAttribute<QmClientRoleMatrix, GlobRoles> roleId;
	public static volatile SingularAttribute<QmClientRoleMatrix, Character> editRights;
	public static volatile SingularAttribute<QmClientRoleMatrix, Date> appvDate;
	public static volatile SingularAttribute<QmClientRoleMatrix, String> version;
	public static volatile SingularAttribute<QmClientRoleMatrix, String> createByIp;
	public static volatile SingularAttribute<QmClientRoleMatrix, String> itemName;
	public static volatile SingularAttribute<QmClientRoleMatrix, String> createBy;
	public static volatile SingularAttribute<QmClientRoleMatrix, String> lastModIp;
	public static volatile SingularAttribute<QmClientRoleMatrix, BigInteger> appvId;
	public static volatile SingularAttribute<QmClientRoleMatrix, Character> approveRights;
	public static volatile SingularAttribute<QmClientRoleMatrix, Character> readRights;
	public static volatile SingularAttribute<QmClientRoleMatrix, BigDecimal> id;
	public static volatile SingularAttribute<QmClientRoleMatrix, String> lastMod;
	public static volatile SingularAttribute<QmClientRoleMatrix, String> createDate;

	public static final String NO_RIGHTS = "noRights";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String ROLE_ID = "roleId";
	public static final String EDIT_RIGHTS = "editRights";
	public static final String APPV_DATE = "appvDate";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String ITEM_NAME = "itemName";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String APPV_ID = "appvId";
	public static final String APPROVE_RIGHTS = "approveRights";
	public static final String READ_RIGHTS = "readRights";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";

}

