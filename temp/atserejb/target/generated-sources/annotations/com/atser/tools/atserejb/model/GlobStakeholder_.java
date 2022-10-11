package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobStakeholder.class)
public abstract class GlobStakeholder_ {

	public static volatile SingularAttribute<GlobStakeholder, String> firstname;
	public static volatile SingularAttribute<GlobStakeholder, String> lastModBy;
	public static volatile SingularAttribute<GlobStakeholder, BigInteger> clientId;
	public static volatile SingularAttribute<GlobStakeholder, String> role;
	public static volatile SingularAttribute<GlobStakeholder, String> address;
	public static volatile SingularAttribute<GlobStakeholder, BigInteger> companyType;
	public static volatile SingularAttribute<GlobStakeholder, String> companyName;
	public static volatile ListAttribute<GlobStakeholder, GlobStakeholderGroup> globStakeholderGroupList;
	public static volatile SingularAttribute<GlobStakeholder, String> middlename;
	public static volatile SingularAttribute<GlobStakeholder, Short> active;
	public static volatile SingularAttribute<GlobStakeholder, String> title;
	public static volatile SingularAttribute<GlobStakeholder, String> version;
	public static volatile SingularAttribute<GlobStakeholder, String> createByIp;
	public static volatile SingularAttribute<GlobStakeholder, String> lastname;
	public static volatile SingularAttribute<GlobStakeholder, String> createBy;
	public static volatile SingularAttribute<GlobStakeholder, String> lastModIp;
	public static volatile SingularAttribute<GlobStakeholder, String> phone;
	public static volatile SingularAttribute<GlobStakeholder, BigDecimal> id;
	public static volatile SingularAttribute<GlobStakeholder, BigInteger> projectId;
	public static volatile SingularAttribute<GlobStakeholder, String> lastMod;
	public static volatile SingularAttribute<GlobStakeholder, String> refCode;
	public static volatile SingularAttribute<GlobStakeholder, String> email;
	public static volatile SingularAttribute<GlobStakeholder, Date> createDate;

	public static final String FIRSTNAME = "firstname";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CLIENT_ID = "clientId";
	public static final String ROLE = "role";
	public static final String ADDRESS = "address";
	public static final String COMPANY_TYPE = "companyType";
	public static final String COMPANY_NAME = "companyName";
	public static final String GLOB_STAKEHOLDER_GROUP_LIST = "globStakeholderGroupList";
	public static final String MIDDLENAME = "middlename";
	public static final String ACTIVE = "active";
	public static final String TITLE = "title";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String LASTNAME = "lastname";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String PHONE = "phone";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String LAST_MOD = "lastMod";
	public static final String REF_CODE = "refCode";
	public static final String EMAIL = "email";
	public static final String CREATE_DATE = "createDate";

}

