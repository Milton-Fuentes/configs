package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QmPersonnel.class)
public abstract class QmPersonnel_ {

	public static volatile SingularAttribute<QmPersonnel, String> zip;
	public static volatile SingularAttribute<QmPersonnel, String> firstname;
	public static volatile SingularAttribute<QmPersonnel, String> address;
	public static volatile SingularAttribute<QmPersonnel, String> city;
	public static volatile SingularAttribute<QmPersonnel, String> middlename;
	public static volatile SingularAttribute<QmPersonnel, Character> active;
	public static volatile SingularAttribute<QmPersonnel, Character> main;
	public static volatile SingularAttribute<QmPersonnel, String> cell;
	public static volatile SingularAttribute<QmPersonnel, String> title;
	public static volatile SingularAttribute<QmPersonnel, BigInteger> contractorPersonnelId;
	public static volatile SingularAttribute<QmPersonnel, BigInteger> version;
	public static volatile SingularAttribute<QmPersonnel, String> lastname;
	public static volatile SingularAttribute<QmPersonnel, Date> createdDate;
	public static volatile SingularAttribute<QmPersonnel, String> deleted;
	public static volatile SingularAttribute<QmPersonnel, String> phone;
	public static volatile SingularAttribute<QmPersonnel, Date> lastModDate;
	public static volatile SingularAttribute<QmPersonnel, BigDecimal> id;
	public static volatile SingularAttribute<QmPersonnel, String> state;
	public static volatile ListAttribute<QmPersonnel, QmProjContrPers> qmProjContrPersList;
	public static volatile SingularAttribute<QmPersonnel, String> fax;
	public static volatile SingularAttribute<QmPersonnel, String> email;

	public static final String ZIP = "zip";
	public static final String FIRSTNAME = "firstname";
	public static final String ADDRESS = "address";
	public static final String CITY = "city";
	public static final String MIDDLENAME = "middlename";
	public static final String ACTIVE = "active";
	public static final String MAIN = "main";
	public static final String CELL = "cell";
	public static final String TITLE = "title";
	public static final String CONTRACTOR_PERSONNEL_ID = "contractorPersonnelId";
	public static final String VERSION = "version";
	public static final String LASTNAME = "lastname";
	public static final String CREATED_DATE = "createdDate";
	public static final String DELETED = "deleted";
	public static final String PHONE = "phone";
	public static final String LAST_MOD_DATE = "lastModDate";
	public static final String ID = "id";
	public static final String STATE = "state";
	public static final String QM_PROJ_CONTR_PERS_LIST = "qmProjContrPersList";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";

}

