package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobLabs.class)
public abstract class GlobLabs_ {

	public static volatile SingularAttribute<GlobLabs, String> city;
	public static volatile SingularAttribute<GlobLabs, String> labName;
	public static volatile SingularAttribute<GlobLabs, String> cell;
	public static volatile SingularAttribute<GlobLabs, Character> uploadI2ms;
	public static volatile SingularAttribute<GlobLabs, GlobLabsMaster> masterlabId;
	public static volatile SingularAttribute<GlobLabs, GlobFunctions> functionId;
	public static volatile SingularAttribute<GlobLabs, String> labType;
	public static volatile SingularAttribute<GlobLabs, String> contact;
	public static volatile SingularAttribute<GlobLabs, String> state;
	public static volatile SingularAttribute<GlobLabs, BigDecimal> id;
	public static volatile SingularAttribute<GlobLabs, String> fax;
	public static volatile SingularAttribute<GlobLabs, BigInteger> contractorContractId;
	public static volatile SingularAttribute<GlobLabs, String> email;
	public static volatile SingularAttribute<GlobLabs, String> zip;
	public static volatile SingularAttribute<GlobLabs, String> address;
	public static volatile SingularAttribute<GlobLabs, BigInteger> clientId;
	public static volatile SingularAttribute<GlobLabs, Character> active;
	public static volatile SingularAttribute<GlobLabs, String> tbpeRegistrationNo;
	public static volatile SingularAttribute<GlobLabs, BigInteger> companyId;
	public static volatile SingularAttribute<GlobLabs, String> phone;
	public static volatile SingularAttribute<GlobLabs, String> sampleCatgId;
	public static volatile SingularAttribute<GlobLabs, String> name;
	public static volatile SingularAttribute<GlobLabs, String> lastModTmp;
	public static volatile SingularAttribute<GlobLabs, String> location;
	public static volatile SingularAttribute<GlobLabs, String> clientsLabid;
	public static volatile SingularAttribute<GlobLabs, Date> lastMod;
	public static volatile SingularAttribute<GlobLabs, String> physicalLabName;

	public static final String CITY = "city";
	public static final String LAB_NAME = "labName";
	public static final String CELL = "cell";
	public static final String UPLOAD_I2MS = "uploadI2ms";
	public static final String MASTERLAB_ID = "masterlabId";
	public static final String FUNCTION_ID = "functionId";
	public static final String LAB_TYPE = "labType";
	public static final String CONTACT = "contact";
	public static final String STATE = "state";
	public static final String ID = "id";
	public static final String FAX = "fax";
	public static final String CONTRACTOR_CONTRACT_ID = "contractorContractId";
	public static final String EMAIL = "email";
	public static final String ZIP = "zip";
	public static final String ADDRESS = "address";
	public static final String CLIENT_ID = "clientId";
	public static final String ACTIVE = "active";
	public static final String TBPE_REGISTRATION_NO = "tbpeRegistrationNo";
	public static final String COMPANY_ID = "companyId";
	public static final String PHONE = "phone";
	public static final String SAMPLE_CATG_ID = "sampleCatgId";
	public static final String NAME = "name";
	public static final String LAST_MOD_TMP = "lastModTmp";
	public static final String LOCATION = "location";
	public static final String CLIENTS_LABID = "clientsLabid";
	public static final String LAST_MOD = "lastMod";
	public static final String PHYSICAL_LAB_NAME = "physicalLabName";

}

