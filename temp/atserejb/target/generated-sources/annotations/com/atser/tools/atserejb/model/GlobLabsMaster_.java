package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobLabsMaster.class)
public abstract class GlobLabsMaster_ {

	public static volatile SingularAttribute<GlobLabsMaster, String> lastModBy;
	public static volatile SingularAttribute<GlobLabsMaster, String> city;
	public static volatile SingularAttribute<GlobLabsMaster, String> labName;
	public static volatile SingularAttribute<GlobLabsMaster, String> cell;
	public static volatile SingularAttribute<GlobLabsMaster, String> labType;
	public static volatile SingularAttribute<GlobLabsMaster, String> lastModIp;
	public static volatile ListAttribute<GlobLabsMaster, GlobLabs> globLabsList;
	public static volatile SingularAttribute<GlobLabsMaster, String> contact;
	public static volatile SingularAttribute<GlobLabsMaster, BigDecimal> id;
	public static volatile SingularAttribute<GlobLabsMaster, String> state;
	public static volatile SingularAttribute<GlobLabsMaster, String> fax;
	public static volatile SingularAttribute<GlobLabsMaster, String> email;
	public static volatile SingularAttribute<GlobLabsMaster, String> zip;
	public static volatile SingularAttribute<GlobLabsMaster, String> createdByIp;
	public static volatile SingularAttribute<GlobLabsMaster, BigInteger> clientId;
	public static volatile SingularAttribute<GlobLabsMaster, String> address;
	public static volatile SingularAttribute<GlobLabsMaster, Date> created;
	public static volatile SingularAttribute<GlobLabsMaster, String> active;
	public static volatile SingularAttribute<GlobLabsMaster, String> tbpeRegistrationNo;
	public static volatile SingularAttribute<GlobLabsMaster, Long> version;
	public static volatile SingularAttribute<GlobLabsMaster, BigInteger> folderId;
	public static volatile SingularAttribute<GlobLabsMaster, String> deleted;
	public static volatile SingularAttribute<GlobLabsMaster, String> phone;
	public static volatile SingularAttribute<GlobLabsMaster, String> createdBy;
	public static volatile SingularAttribute<GlobLabsMaster, String> name;
	public static volatile SingularAttribute<GlobLabsMaster, String> location;
	public static volatile SingularAttribute<GlobLabsMaster, Date> lastMod;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CITY = "city";
	public static final String LAB_NAME = "labName";
	public static final String CELL = "cell";
	public static final String LAB_TYPE = "labType";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String GLOB_LABS_LIST = "globLabsList";
	public static final String CONTACT = "contact";
	public static final String ID = "id";
	public static final String STATE = "state";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";
	public static final String ZIP = "zip";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String ADDRESS = "address";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String TBPE_REGISTRATION_NO = "tbpeRegistrationNo";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String DELETED = "deleted";
	public static final String PHONE = "phone";
	public static final String CREATED_BY = "createdBy";
	public static final String NAME = "name";
	public static final String LOCATION = "location";
	public static final String LAST_MOD = "lastMod";

}

