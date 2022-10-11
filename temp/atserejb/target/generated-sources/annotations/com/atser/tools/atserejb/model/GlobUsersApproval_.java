package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobUsersApproval.class)
public abstract class GlobUsersApproval_ {

	public static volatile SingularAttribute<GlobUsersApproval, String> lastName;
	public static volatile SingularAttribute<GlobUsersApproval, String> createdByIp;
	public static volatile SingularAttribute<GlobUsersApproval, String> lastModBy;
	public static volatile SingularAttribute<GlobUsersApproval, String> clientName;
	public static volatile SingularAttribute<GlobUsersApproval, Date> created;
	public static volatile SingularAttribute<GlobUsersApproval, String> companyName;
	public static volatile SingularAttribute<GlobUsersApproval, String> moduleName;
	public static volatile SingularAttribute<GlobUsersApproval, BigInteger> requestedClientId;
	public static volatile SingularAttribute<GlobUsersApproval, String> approvedBy;
	public static volatile SingularAttribute<GlobUsersApproval, Character> active;
	public static volatile SingularAttribute<GlobUsersApproval, Integer> version;
	public static volatile SingularAttribute<GlobUsersApproval, Date> approvedDate;
	public static volatile SingularAttribute<GlobUsersApproval, String> firstName;
	public static volatile SingularAttribute<GlobUsersApproval, Character> approved;
	public static volatile SingularAttribute<GlobUsersApproval, String> lastModIp;
	public static volatile SingularAttribute<GlobUsersApproval, Character> deleted;
	public static volatile SingularAttribute<GlobUsersApproval, BigInteger> approvedByClientId;
	public static volatile SingularAttribute<GlobUsersApproval, String> createdBy;
	public static volatile SingularAttribute<GlobUsersApproval, String> uniqueToken;
	public static volatile SingularAttribute<GlobUsersApproval, BigDecimal> id;
	public static volatile SingularAttribute<GlobUsersApproval, Date> lastMod;
	public static volatile SingularAttribute<GlobUsersApproval, String> email;
	public static volatile SingularAttribute<GlobUsersApproval, String> username;

	public static final String LAST_NAME = "lastName";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CLIENT_NAME = "clientName";
	public static final String CREATED = "created";
	public static final String COMPANY_NAME = "companyName";
	public static final String MODULE_NAME = "moduleName";
	public static final String REQUESTED_CLIENT_ID = "requestedClientId";
	public static final String APPROVED_BY = "approvedBy";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String APPROVED_DATE = "approvedDate";
	public static final String FIRST_NAME = "firstName";
	public static final String APPROVED = "approved";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String APPROVED_BY_CLIENT_ID = "approvedByClientId";
	public static final String CREATED_BY = "createdBy";
	public static final String UNIQUE_TOKEN = "uniqueToken";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String EMAIL = "email";
	public static final String USERNAME = "username";

}

