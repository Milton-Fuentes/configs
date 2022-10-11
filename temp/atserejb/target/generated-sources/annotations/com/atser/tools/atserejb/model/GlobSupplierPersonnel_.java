package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSupplierPersonnel.class)
public abstract class GlobSupplierPersonnel_ {

	public static volatile SingularAttribute<GlobSupplierPersonnel, String> zip;
	public static volatile SingularAttribute<GlobSupplierPersonnel, String> address;
	public static volatile SingularAttribute<GlobSupplierPersonnel, GlobSupplier> supplierId;
	public static volatile SingularAttribute<GlobSupplierPersonnel, String> city;
	public static volatile SingularAttribute<GlobSupplierPersonnel, String> contactName;
	public static volatile ListAttribute<GlobSupplierPersonnel, GlobProjSuplPers> globProjSuplPersList;
	public static volatile SingularAttribute<GlobSupplierPersonnel, Character> active;
	public static volatile SingularAttribute<GlobSupplierPersonnel, Character> main;
	public static volatile SingularAttribute<GlobSupplierPersonnel, String> cell;
	public static volatile SingularAttribute<GlobSupplierPersonnel, BigInteger> version;
	public static volatile SingularAttribute<GlobSupplierPersonnel, Character> enabled;
	public static volatile SingularAttribute<GlobSupplierPersonnel, String> contactTitle;
	public static volatile SingularAttribute<GlobSupplierPersonnel, String> phone;
	public static volatile SingularAttribute<GlobSupplierPersonnel, Date> lastModDate;
	public static volatile SingularAttribute<GlobSupplierPersonnel, BigDecimal> id;
	public static volatile SingularAttribute<GlobSupplierPersonnel, String> state;
	public static volatile SingularAttribute<GlobSupplierPersonnel, String> fax;
	public static volatile SingularAttribute<GlobSupplierPersonnel, String> email;
	public static volatile SingularAttribute<GlobSupplierPersonnel, Date> createDate;

	public static final String ZIP = "zip";
	public static final String ADDRESS = "address";
	public static final String SUPPLIER_ID = "supplierId";
	public static final String CITY = "city";
	public static final String CONTACT_NAME = "contactName";
	public static final String GLOB_PROJ_SUPL_PERS_LIST = "globProjSuplPersList";
	public static final String ACTIVE = "active";
	public static final String MAIN = "main";
	public static final String CELL = "cell";
	public static final String VERSION = "version";
	public static final String ENABLED = "enabled";
	public static final String CONTACT_TITLE = "contactTitle";
	public static final String PHONE = "phone";
	public static final String LAST_MOD_DATE = "lastModDate";
	public static final String ID = "id";
	public static final String STATE = "state";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";
	public static final String CREATE_DATE = "createDate";

}

