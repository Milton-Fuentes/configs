package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobPrjBinderSupplier.class)
public abstract class GlobPrjBinderSupplier_ {

	public static volatile SingularAttribute<GlobPrjBinderSupplier, String> createBy;
	public static volatile SingularAttribute<GlobPrjBinderSupplier, String> lastModBy;
	public static volatile SingularAttribute<GlobPrjBinderSupplier, String> lastModIp;
	public static volatile SingularAttribute<GlobPrjBinderSupplier, GlobBinderSupplier> binderSupplierId;
	public static volatile SingularAttribute<GlobPrjBinderSupplier, Character> active;
	public static volatile SingularAttribute<GlobPrjBinderSupplier, BigDecimal> id;
	public static volatile SingularAttribute<GlobPrjBinderSupplier, BigInteger> projectId;
	public static volatile SingularAttribute<GlobPrjBinderSupplier, String> lastMod;
	public static volatile SingularAttribute<GlobPrjBinderSupplier, String> version;
	public static volatile SingularAttribute<GlobPrjBinderSupplier, String> createByIp;
	public static volatile SingularAttribute<GlobPrjBinderSupplier, Character> enabled;
	public static volatile SingularAttribute<GlobPrjBinderSupplier, String> createDate;

	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String BINDER_SUPPLIER_ID = "binderSupplierId";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String LAST_MOD = "lastMod";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String ENABLED = "enabled";
	public static final String CREATE_DATE = "createDate";

}

