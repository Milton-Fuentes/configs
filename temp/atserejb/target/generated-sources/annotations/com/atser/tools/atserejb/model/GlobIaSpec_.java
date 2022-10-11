package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobIaSpec.class)
public abstract class GlobIaSpec_ {

	public static volatile SingularAttribute<GlobIaSpec, String> specType;
	public static volatile SingularAttribute<GlobIaSpec, BigInteger> clientId;
	public static volatile SingularAttribute<GlobIaSpec, String> lastModBy;
	public static volatile SingularAttribute<GlobIaSpec, Date> specDate;
	public static volatile SingularAttribute<GlobIaSpec, String> specNo;
	public static volatile SingularAttribute<GlobIaSpec, BigInteger> copyfromId;
	public static volatile SingularAttribute<GlobIaSpec, String> version;
	public static volatile SingularAttribute<GlobIaSpec, String> createByIp;
	public static volatile SingularAttribute<GlobIaSpec, String> createBy;
	public static volatile SingularAttribute<GlobIaSpec, String> lastModIp;
	public static volatile SingularAttribute<GlobIaSpec, String> specName;
	public static volatile SingularAttribute<GlobIaSpec, BigDecimal> id;
	public static volatile SingularAttribute<GlobIaSpec, String> lastMod;

	public static final String SPEC_TYPE = "specType";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String SPEC_DATE = "specDate";
	public static final String SPEC_NO = "specNo";
	public static final String COPYFROM_ID = "copyfromId";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String SPEC_NAME = "specName";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

