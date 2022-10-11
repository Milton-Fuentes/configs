package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobContractor.class)
public abstract class GlobContractor_ {

	public static volatile SingularAttribute<GlobContractor, String> country;
	public static volatile SingularAttribute<GlobContractor, String> lastModBy;
	public static volatile SingularAttribute<GlobContractor, String> city;
	public static volatile SingularAttribute<GlobContractor, GlobPhaseType> phaseType;
	public static volatile SingularAttribute<GlobContractor, Character> isMwbe;
	public static volatile SingularAttribute<GlobContractor, String> capability;
	public static volatile SingularAttribute<GlobContractor, String> phoneCell;
	public static volatile SingularAttribute<GlobContractor, String> contactTitle;
	public static volatile SingularAttribute<GlobContractor, String> lastModIp;
	public static volatile ListAttribute<GlobContractor, GlobContractorContract> globContractorContractList;
	public static volatile SingularAttribute<GlobContractor, String> applicantType;
	public static volatile SingularAttribute<GlobContractor, String> street;
	public static volatile SingularAttribute<GlobContractor, BigDecimal> id;
	public static volatile SingularAttribute<GlobContractor, String> state;
	public static volatile SingularAttribute<GlobContractor, String> fax;
	public static volatile SingularAttribute<GlobContractor, String> email;
	public static volatile SingularAttribute<GlobContractor, Date> createDate;
	public static volatile SingularAttribute<GlobContractor, String> zip;
	public static volatile SingularAttribute<GlobContractor, String> owner;
	public static volatile SingularAttribute<GlobContractor, BigInteger> clientId;
	public static volatile SingularAttribute<GlobContractor, String> contactName;
	public static volatile SingularAttribute<GlobContractor, String> version;
	public static volatile SingularAttribute<GlobContractor, String> url;
	public static volatile SingularAttribute<GlobContractor, String> createByIp;
	public static volatile SingularAttribute<GlobContractor, String> field1;
	public static volatile SingularAttribute<GlobContractor, BigInteger> companyId;
	public static volatile SingularAttribute<GlobContractor, String> createBy;
	public static volatile SingularAttribute<GlobContractor, String> phone;
	public static volatile SingularAttribute<GlobContractor, Date> expire;
	public static volatile SingularAttribute<GlobContractor, String> name;
	public static volatile SingularAttribute<GlobContractor, Date> field7;
	public static volatile SingularAttribute<GlobContractor, Double> field6;
	public static volatile SingularAttribute<GlobContractor, BigInteger> field9;
	public static volatile SingularAttribute<GlobContractor, BigInteger> ownerFk;
	public static volatile SingularAttribute<GlobContractor, Date> field8;
	public static volatile SingularAttribute<GlobContractor, String> category;
	public static volatile SingularAttribute<GlobContractor, String> field3;
	public static volatile SingularAttribute<GlobContractor, String> field2;
	public static volatile SingularAttribute<GlobContractor, String> lastMod;
	public static volatile SingularAttribute<GlobContractor, Double> field5;
	public static volatile SingularAttribute<GlobContractor, String> field4;

	public static final String COUNTRY = "country";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CITY = "city";
	public static final String PHASE_TYPE = "phaseType";
	public static final String IS_MWBE = "isMwbe";
	public static final String CAPABILITY = "capability";
	public static final String PHONE_CELL = "phoneCell";
	public static final String CONTACT_TITLE = "contactTitle";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String GLOB_CONTRACTOR_CONTRACT_LIST = "globContractorContractList";
	public static final String APPLICANT_TYPE = "applicantType";
	public static final String STREET = "street";
	public static final String ID = "id";
	public static final String STATE = "state";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";
	public static final String CREATE_DATE = "createDate";
	public static final String ZIP = "zip";
	public static final String OWNER = "owner";
	public static final String CLIENT_ID = "clientId";
	public static final String CONTACT_NAME = "contactName";
	public static final String VERSION = "version";
	public static final String URL = "url";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String FIELD1 = "field1";
	public static final String COMPANY_ID = "companyId";
	public static final String CREATE_BY = "createBy";
	public static final String PHONE = "phone";
	public static final String EXPIRE = "expire";
	public static final String NAME = "name";
	public static final String FIELD7 = "field7";
	public static final String FIELD6 = "field6";
	public static final String FIELD9 = "field9";
	public static final String OWNER_FK = "ownerFk";
	public static final String FIELD8 = "field8";
	public static final String CATEGORY = "category";
	public static final String FIELD3 = "field3";
	public static final String FIELD2 = "field2";
	public static final String LAST_MOD = "lastMod";
	public static final String FIELD5 = "field5";
	public static final String FIELD4 = "field4";

}

