package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobPermsModelDoc.class)
public abstract class GlobPermsModelDoc_ {

	public static volatile SingularAttribute<GlobPermsModelDoc, String> createdByIp;
	public static volatile SingularAttribute<GlobPermsModelDoc, BigInteger> clientId;
	public static volatile SingularAttribute<GlobPermsModelDoc, String> lastModBy;
	public static volatile SingularAttribute<GlobPermsModelDoc, Date> created;
	public static volatile SingularAttribute<GlobPermsModelDoc, String> description;
	public static volatile SingularAttribute<GlobPermsModelDoc, Character> active;
	public static volatile SingularAttribute<GlobPermsModelDoc, Character> main;
	public static volatile SingularAttribute<GlobPermsModelDoc, Integer> version;
	public static volatile SingularAttribute<GlobPermsModelDoc, BigInteger> folderId;
	public static volatile SingularAttribute<GlobPermsModelDoc, String> lastModIp;
	public static volatile SingularAttribute<GlobPermsModelDoc, Character> deleted;
	public static volatile SingularAttribute<GlobPermsModelDoc, String> authorizedBy;
	public static volatile SingularAttribute<GlobPermsModelDoc, BigInteger> sno;
	public static volatile SingularAttribute<GlobPermsModelDoc, String> createdBy;
	public static volatile SingularAttribute<GlobPermsModelDoc, String> versionNo;
	public static volatile SingularAttribute<GlobPermsModelDoc, Date> authorizedDate;
	public static volatile SingularAttribute<GlobPermsModelDoc, BigDecimal> id;
	public static volatile SingularAttribute<GlobPermsModelDoc, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String MAIN = "main";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String AUTHORIZED_BY = "authorizedBy";
	public static final String SNO = "sno";
	public static final String CREATED_BY = "createdBy";
	public static final String VERSION_NO = "versionNo";
	public static final String AUTHORIZED_DATE = "authorizedDate";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

