package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjSupplAddr.class)
public abstract class GlobProjSupplAddr_ {

	public static volatile SingularAttribute<GlobProjSupplAddr, String> lastModBy;
	public static volatile SingularAttribute<GlobProjSupplAddr, GlobSupplierAddress> supplierAddressId;
	public static volatile ListAttribute<GlobProjSupplAddr, GlobProjSuplPers> globProjSuplPersList;
	public static volatile SingularAttribute<GlobProjSupplAddr, Character> active;
	public static volatile SingularAttribute<GlobProjSupplAddr, Character> main;
	public static volatile SingularAttribute<GlobProjSupplAddr, BigInteger> version;
	public static volatile SingularAttribute<GlobProjSupplAddr, String> createByIp;
	public static volatile SingularAttribute<GlobProjSupplAddr, String> enabled;
	public static volatile SingularAttribute<GlobProjSupplAddr, String> createBy;
	public static volatile SingularAttribute<GlobProjSupplAddr, String> lastModIp;
	public static volatile SingularAttribute<GlobProjSupplAddr, BigInteger> projectSupplierId;
	public static volatile SingularAttribute<GlobProjSupplAddr, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjSupplAddr, String> lastMod;
	public static volatile SingularAttribute<GlobProjSupplAddr, String> createDate;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String SUPPLIER_ADDRESS_ID = "supplierAddressId";
	public static final String GLOB_PROJ_SUPL_PERS_LIST = "globProjSuplPersList";
	public static final String ACTIVE = "active";
	public static final String MAIN = "main";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String ENABLED = "enabled";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String PROJECT_SUPPLIER_ID = "projectSupplierId";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";

}

