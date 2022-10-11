package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobContactCert.class)
public abstract class GlobContactCert_ {

	public static volatile SingularAttribute<GlobContactCert, Character> ignoreProficiency;
	public static volatile SingularAttribute<GlobContactCert, String> comments;
	public static volatile SingularAttribute<GlobContactCert, String> lastModBy;
	public static volatile SingularAttribute<GlobContactCert, GlobCertification> qualificationId;
	public static volatile SingularAttribute<GlobContactCert, GlobContact> contactId;
	public static volatile SingularAttribute<GlobContactCert, String> active;
	public static volatile SingularAttribute<GlobContactCert, String> version;
	public static volatile SingularAttribute<GlobContactCert, String> createByIp;
	public static volatile SingularAttribute<GlobContactCert, BigInteger> folderId;
	public static volatile SingularAttribute<GlobContactCert, String> certNo;
	public static volatile SingularAttribute<GlobContactCert, String> createBy;
	public static volatile SingularAttribute<GlobContactCert, String> lastModIp;
	public static volatile SingularAttribute<GlobContactCert, String> deleted;
	public static volatile SingularAttribute<GlobContactCert, Date> authorizedDate;
	public static volatile SingularAttribute<GlobContactCert, BigDecimal> id;
	public static volatile SingularAttribute<GlobContactCert, Character> override;
	public static volatile SingularAttribute<GlobContactCert, GlobCertificationAgency> qualifyingAgencyId;
	public static volatile SingularAttribute<GlobContactCert, String> lastMod;
	public static volatile SingularAttribute<GlobContactCert, Date> expirationDate;
	public static volatile SingularAttribute<GlobContactCert, String> createDate;

	public static final String IGNORE_PROFICIENCY = "ignoreProficiency";
	public static final String COMMENTS = "comments";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String QUALIFICATION_ID = "qualificationId";
	public static final String CONTACT_ID = "contactId";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String FOLDER_ID = "folderId";
	public static final String CERT_NO = "certNo";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String AUTHORIZED_DATE = "authorizedDate";
	public static final String ID = "id";
	public static final String OVERRIDE = "override";
	public static final String QUALIFYING_AGENCY_ID = "qualifyingAgencyId";
	public static final String LAST_MOD = "lastMod";
	public static final String EXPIRATION_DATE = "expirationDate";
	public static final String CREATE_DATE = "createDate";

}

