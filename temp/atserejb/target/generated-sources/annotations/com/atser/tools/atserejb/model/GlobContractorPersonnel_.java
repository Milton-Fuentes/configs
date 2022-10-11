package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobContractorPersonnel.class)
public abstract class GlobContractorPersonnel_ {

	public static volatile SingularAttribute<GlobContractorPersonnel, String> contractor;
	public static volatile SingularAttribute<GlobContractorPersonnel, String> zip;
	public static volatile SingularAttribute<GlobContractorPersonnel, String> firstname;
	public static volatile SingularAttribute<GlobContractorPersonnel, BigInteger> clientId;
	public static volatile SingularAttribute<GlobContractorPersonnel, String> address;
	public static volatile SingularAttribute<GlobContractorPersonnel, String> city;
	public static volatile ListAttribute<GlobContractorPersonnel, GlobProjContrPersonnel> globProjContrPersonnelList;
	public static volatile SingularAttribute<GlobContractorPersonnel, String> contractorCode;
	public static volatile SingularAttribute<GlobContractorPersonnel, Character> active;
	public static volatile SingularAttribute<GlobContractorPersonnel, String> title;
	public static volatile SingularAttribute<GlobContractorPersonnel, String> cell;
	public static volatile SingularAttribute<GlobContractorPersonnel, String> enabled;
	public static volatile SingularAttribute<GlobContractorPersonnel, String> lastname;
	public static volatile ListAttribute<GlobContractorPersonnel, QmPersonnel> qmPersonnelList;
	public static volatile SingularAttribute<GlobContractorPersonnel, String> phone;
	public static volatile SingularAttribute<GlobContractorPersonnel, BigDecimal> id;
	public static volatile SingularAttribute<GlobContractorPersonnel, String> state;
	public static volatile SingularAttribute<GlobContractorPersonnel, String> dataProvider;
	public static volatile SingularAttribute<GlobContractorPersonnel, String> fax;
	public static volatile SingularAttribute<GlobContractorPersonnel, String> email;

	public static final String CONTRACTOR = "contractor";
	public static final String ZIP = "zip";
	public static final String FIRSTNAME = "firstname";
	public static final String CLIENT_ID = "clientId";
	public static final String ADDRESS = "address";
	public static final String CITY = "city";
	public static final String GLOB_PROJ_CONTR_PERSONNEL_LIST = "globProjContrPersonnelList";
	public static final String CONTRACTOR_CODE = "contractorCode";
	public static final String ACTIVE = "active";
	public static final String TITLE = "title";
	public static final String CELL = "cell";
	public static final String ENABLED = "enabled";
	public static final String LASTNAME = "lastname";
	public static final String QM_PERSONNEL_LIST = "qmPersonnelList";
	public static final String PHONE = "phone";
	public static final String ID = "id";
	public static final String STATE = "state";
	public static final String DATA_PROVIDER = "dataProvider";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";

}

