package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobBinderSupplier.class)
public abstract class GlobBinderSupplier_ {

	public static volatile SingularAttribute<GlobBinderSupplier, String> lastModBy;
	public static volatile SingularAttribute<GlobBinderSupplier, BigInteger> clientId;
	public static volatile SingularAttribute<GlobBinderSupplier, GlobSupplier> supplierId;
	public static volatile SingularAttribute<GlobBinderSupplier, Character> active;
	public static volatile SingularAttribute<GlobBinderSupplier, String> version;
	public static volatile SingularAttribute<GlobBinderSupplier, String> createByIp;
	public static volatile SingularAttribute<GlobBinderSupplier, Character> enabled;
	public static volatile SingularAttribute<GlobBinderSupplier, String> createBy;
	public static volatile SingularAttribute<GlobBinderSupplier, String> lastModIp;
	public static volatile SingularAttribute<GlobBinderSupplier, BigDecimal> id;
	public static volatile SingularAttribute<GlobBinderSupplier, String> lastMod;
	public static volatile SingularAttribute<GlobBinderSupplier, String> createDate;
	public static volatile ListAttribute<GlobBinderSupplier, GlobPrjBinderSupplier> globPrjBinderSupplierList;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CLIENT_ID = "clientId";
	public static final String SUPPLIER_ID = "supplierId";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String ENABLED = "enabled";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";
	public static final String GLOB_PRJ_BINDER_SUPPLIER_LIST = "globPrjBinderSupplierList";

}

