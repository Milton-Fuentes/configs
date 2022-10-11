package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmBiditCompany.class)
public abstract class CmBiditCompany_ {

	public static volatile SingularAttribute<CmBiditCompany, String> companyCity;
	public static volatile SingularAttribute<CmBiditCompany, String> createdByIp;
	public static volatile SingularAttribute<CmBiditCompany, BigInteger> clientId;
	public static volatile SingularAttribute<CmBiditCompany, String> lastModBy;
	public static volatile SingularAttribute<CmBiditCompany, String> companyTin;
	public static volatile SingularAttribute<CmBiditCompany, Date> created;
	public static volatile SingularAttribute<CmBiditCompany, String> companyName;
	public static volatile SingularAttribute<CmBiditCompany, String> companyAddr;
	public static volatile SingularAttribute<CmBiditCompany, String> companyState;
	public static volatile SingularAttribute<CmBiditCompany, String> companyDescription;
	public static volatile SingularAttribute<CmBiditCompany, Character> active;
	public static volatile SingularAttribute<CmBiditCompany, Character> engineerEstimate;
	public static volatile SingularAttribute<CmBiditCompany, BigInteger> userId;
	public static volatile SingularAttribute<CmBiditCompany, Integer> version;
	public static volatile SingularAttribute<CmBiditCompany, String> lastModIp;
	public static volatile SingularAttribute<CmBiditCompany, Character> deleted;
	public static volatile SingularAttribute<CmBiditCompany, String> createdBy;
	public static volatile SingularAttribute<CmBiditCompany, BigDecimal> id;
	public static volatile SingularAttribute<CmBiditCompany, QmCvlFieldData> companyTypeId;
	public static volatile SingularAttribute<CmBiditCompany, String> companyAddrDetail;
	public static volatile SingularAttribute<CmBiditCompany, String> companyWebsite;
	public static volatile SingularAttribute<CmBiditCompany, String> companyZip;
	public static volatile SingularAttribute<CmBiditCompany, Date> lastMod;

	public static final String COMPANY_CITY = "companyCity";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String COMPANY_TIN = "companyTin";
	public static final String CREATED = "created";
	public static final String COMPANY_NAME = "companyName";
	public static final String COMPANY_ADDR = "companyAddr";
	public static final String COMPANY_STATE = "companyState";
	public static final String COMPANY_DESCRIPTION = "companyDescription";
	public static final String ACTIVE = "active";
	public static final String ENGINEER_ESTIMATE = "engineerEstimate";
	public static final String USER_ID = "userId";
	public static final String VERSION = "version";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String COMPANY_TYPE_ID = "companyTypeId";
	public static final String COMPANY_ADDR_DETAIL = "companyAddrDetail";
	public static final String COMPANY_WEBSITE = "companyWebsite";
	public static final String COMPANY_ZIP = "companyZip";
	public static final String LAST_MOD = "lastMod";

}

