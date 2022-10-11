package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobContact.class)
public abstract class GlobContact_ {

	public static volatile SingularAttribute<GlobContact, String> country;
	public static volatile SingularAttribute<GlobContact, String> firstname;
	public static volatile SingularAttribute<GlobContact, String> printedSign;
	public static volatile SingularAttribute<GlobContact, Character> notfSmsActive;
	public static volatile SingularAttribute<GlobContact, String> city;
	public static volatile SingularAttribute<GlobContact, BigInteger> departmentId;
	public static volatile SingularAttribute<GlobContact, String> companyName;
	public static volatile ListAttribute<GlobContact, GlobUsers> globUsersList;
	public static volatile SingularAttribute<GlobContact, String> cell;
	public static volatile SingularAttribute<GlobContact, String> title;
	public static volatile SingularAttribute<GlobContact, String> suffix;
	public static volatile SingularAttribute<GlobContact, String> hrTitle;
	public static volatile SingularAttribute<GlobContact, String> pager;
	public static volatile SingularAttribute<GlobContact, String> notfMCarrier;
	public static volatile SingularAttribute<GlobContact, String> unitCode;
	public static volatile SingularAttribute<GlobContact, String> employer;
	public static volatile SingularAttribute<GlobContact, BigDecimal> id;
	public static volatile SingularAttribute<GlobContact, String> state;
	public static volatile SingularAttribute<GlobContact, String> fax;
	public static volatile SingularAttribute<GlobContact, String> technicianId;
	public static volatile SingularAttribute<GlobContact, String> email;
	public static volatile SingularAttribute<GlobContact, String> zip;
	public static volatile SingularAttribute<GlobContact, String> address;
	public static volatile SingularAttribute<GlobContact, BigInteger> clientId;
	public static volatile SingularAttribute<GlobContact, BigInteger> designLab;
	public static volatile SingularAttribute<GlobContact, String> middlename;
	public static volatile SingularAttribute<GlobContact, Character> active;
	public static volatile SingularAttribute<GlobContact, String> lastname;
	public static volatile ListAttribute<GlobContact, GlobProjectPersonnel> globProjectPersonnelList;
	public static volatile SingularAttribute<GlobContact, String> phone;
	public static volatile SingularAttribute<GlobContact, BigInteger> regionId;
	public static volatile ListAttribute<GlobContact, GlobProjectRole> globProjectRoleList;
	public static volatile SingularAttribute<GlobContact, String> unitDescription;
	public static volatile SingularAttribute<GlobContact, String> notfPhone;
	public static volatile SingularAttribute<GlobContact, String> companyLink;
	public static volatile SingularAttribute<GlobContact, BigInteger> projectId;

	public static final String COUNTRY = "country";
	public static final String FIRSTNAME = "firstname";
	public static final String PRINTED_SIGN = "printedSign";
	public static final String NOTF_SMS_ACTIVE = "notfSmsActive";
	public static final String CITY = "city";
	public static final String DEPARTMENT_ID = "departmentId";
	public static final String COMPANY_NAME = "companyName";
	public static final String GLOB_USERS_LIST = "globUsersList";
	public static final String CELL = "cell";
	public static final String TITLE = "title";
	public static final String SUFFIX = "suffix";
	public static final String HR_TITLE = "hrTitle";
	public static final String PAGER = "pager";
	public static final String NOTF_MCARRIER = "notfMCarrier";
	public static final String UNIT_CODE = "unitCode";
	public static final String EMPLOYER = "employer";
	public static final String ID = "id";
	public static final String STATE = "state";
	public static final String FAX = "fax";
	public static final String TECHNICIAN_ID = "technicianId";
	public static final String EMAIL = "email";
	public static final String ZIP = "zip";
	public static final String ADDRESS = "address";
	public static final String CLIENT_ID = "clientId";
	public static final String DESIGN_LAB = "designLab";
	public static final String MIDDLENAME = "middlename";
	public static final String ACTIVE = "active";
	public static final String LASTNAME = "lastname";
	public static final String GLOB_PROJECT_PERSONNEL_LIST = "globProjectPersonnelList";
	public static final String PHONE = "phone";
	public static final String REGION_ID = "regionId";
	public static final String GLOB_PROJECT_ROLE_LIST = "globProjectRoleList";
	public static final String UNIT_DESCRIPTION = "unitDescription";
	public static final String NOTF_PHONE = "notfPhone";
	public static final String COMPANY_LINK = "companyLink";
	public static final String PROJECT_ID = "projectId";

}

