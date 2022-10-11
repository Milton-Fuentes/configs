package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSupplierAddress.class)
public abstract class GlobSupplierAddress_ {

	public static volatile SingularAttribute<GlobSupplierAddress, String> zip;
	public static volatile SingularAttribute<GlobSupplierAddress, BigInteger> supplierId;
	public static volatile SingularAttribute<GlobSupplierAddress, String> address;
	public static volatile SingularAttribute<GlobSupplierAddress, String> lastModBy;
	public static volatile SingularAttribute<GlobSupplierAddress, String> city;
	public static volatile SingularAttribute<GlobSupplierAddress, Character> active;
	public static volatile SingularAttribute<GlobSupplierAddress, Character> main;
	public static volatile SingularAttribute<GlobSupplierAddress, BigInteger> version;
	public static volatile SingularAttribute<GlobSupplierAddress, String> createByIp;
	public static volatile SingularAttribute<GlobSupplierAddress, String> enabled;
	public static volatile SingularAttribute<GlobSupplierAddress, String> createBy;
	public static volatile SingularAttribute<GlobSupplierAddress, String> lastModIp;
	public static volatile SingularAttribute<GlobSupplierAddress, String> location;
	public static volatile SingularAttribute<GlobSupplierAddress, BigDecimal> id;
	public static volatile SingularAttribute<GlobSupplierAddress, String> state;
	public static volatile SingularAttribute<GlobSupplierAddress, String> lastMod;
	public static volatile SingularAttribute<GlobSupplierAddress, String> createDate;

	public static final String ZIP = "zip";
	public static final String SUPPLIER_ID = "supplierId";
	public static final String ADDRESS = "address";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CITY = "city";
	public static final String ACTIVE = "active";
	public static final String MAIN = "main";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String ENABLED = "enabled";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String LOCATION = "location";
	public static final String ID = "id";
	public static final String STATE = "state";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";

}

