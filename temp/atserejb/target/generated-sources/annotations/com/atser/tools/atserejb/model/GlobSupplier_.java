package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSupplier.class)
public abstract class GlobSupplier_ {

	public static volatile SingularAttribute<GlobSupplier, String> lastModBy;
	public static volatile SingularAttribute<GlobSupplier, String> city;
	public static volatile SingularAttribute<GlobSupplier, Date> dueDate;
	public static volatile SingularAttribute<GlobSupplier, String> impVendorId;
	public static volatile SingularAttribute<GlobSupplier, String> cell;
	public static volatile ListAttribute<GlobSupplier, GlobBinderSupplier> globBinderSupplierList;
	public static volatile SingularAttribute<GlobSupplier, Character> enabled;
	public static volatile SingularAttribute<GlobSupplier, String> contactTitle;
	public static volatile SingularAttribute<GlobSupplier, String> lastModIp;
	public static volatile ListAttribute<GlobSupplier, GlobProjectSupplier> globProjectSupplierList;
	public static volatile SingularAttribute<GlobSupplier, String> supplier;
	public static volatile SingularAttribute<GlobSupplier, BigDecimal> id;
	public static volatile SingularAttribute<GlobSupplier, String> state;
	public static volatile SingularAttribute<GlobSupplier, String> fax;
	public static volatile SingularAttribute<GlobSupplier, String> email;
	public static volatile SingularAttribute<GlobSupplier, Date> createDate;
	public static volatile SingularAttribute<GlobSupplier, String> zip;
	public static volatile SingularAttribute<GlobSupplier, String> impCode;
	public static volatile SingularAttribute<GlobSupplier, BigInteger> clientId;
	public static volatile SingularAttribute<GlobSupplier, String> address;
	public static volatile SingularAttribute<GlobSupplier, String> contactName;
	public static volatile SingularAttribute<GlobSupplier, Character> active;
	public static volatile ListAttribute<GlobSupplier, GlobSupplierPersonnel> globSupplierPersonnelList;
	public static volatile SingularAttribute<GlobSupplier, String> version;
	public static volatile SingularAttribute<GlobSupplier, String> createByIp;
	public static volatile SingularAttribute<GlobSupplier, BigInteger> folderId;
	public static volatile SingularAttribute<GlobSupplier, String> createBy;
	public static volatile SingularAttribute<GlobSupplier, String> phone;
	public static volatile SingularAttribute<GlobSupplier, String> service;
	public static volatile SingularAttribute<GlobSupplier, String> location;
	public static volatile SingularAttribute<GlobSupplier, String> lastMod;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CITY = "city";
	public static final String DUE_DATE = "dueDate";
	public static final String IMP_VENDOR_ID = "impVendorId";
	public static final String CELL = "cell";
	public static final String GLOB_BINDER_SUPPLIER_LIST = "globBinderSupplierList";
	public static final String ENABLED = "enabled";
	public static final String CONTACT_TITLE = "contactTitle";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String GLOB_PROJECT_SUPPLIER_LIST = "globProjectSupplierList";
	public static final String SUPPLIER = "supplier";
	public static final String ID = "id";
	public static final String STATE = "state";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";
	public static final String CREATE_DATE = "createDate";
	public static final String ZIP = "zip";
	public static final String IMP_CODE = "impCode";
	public static final String CLIENT_ID = "clientId";
	public static final String ADDRESS = "address";
	public static final String CONTACT_NAME = "contactName";
	public static final String ACTIVE = "active";
	public static final String GLOB_SUPPLIER_PERSONNEL_LIST = "globSupplierPersonnelList";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String FOLDER_ID = "folderId";
	public static final String CREATE_BY = "createBy";
	public static final String PHONE = "phone";
	public static final String SERVICE = "service";
	public static final String LOCATION = "location";
	public static final String LAST_MOD = "lastMod";

}

