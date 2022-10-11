package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjSuplPers.class)
public abstract class GlobProjSuplPers_ {

	public static volatile SingularAttribute<GlobProjSuplPers, Character> deleted;
	public static volatile SingularAttribute<GlobProjSuplPers, GlobSupplierPersonnel> supplierPersonnelId;
	public static volatile SingularAttribute<GlobProjSuplPers, Character> active;
	public static volatile SingularAttribute<GlobProjSuplPers, Date> lastModDate;
	public static volatile SingularAttribute<GlobProjSuplPers, Character> main;
	public static volatile SingularAttribute<GlobProjSuplPers, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjSuplPers, BigInteger> version;
	public static volatile SingularAttribute<GlobProjSuplPers, GlobProjSupplAddr> projSupplAddrId;
	public static volatile SingularAttribute<GlobProjSuplPers, Date> createDate;

	public static final String DELETED = "deleted";
	public static final String SUPPLIER_PERSONNEL_ID = "supplierPersonnelId";
	public static final String ACTIVE = "active";
	public static final String LAST_MOD_DATE = "lastModDate";
	public static final String MAIN = "main";
	public static final String ID = "id";
	public static final String VERSION = "version";
	public static final String PROJ_SUPPL_ADDR_ID = "projSupplAddrId";
	public static final String CREATE_DATE = "createDate";

}

