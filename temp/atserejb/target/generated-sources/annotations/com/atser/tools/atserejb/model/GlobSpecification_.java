package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSpecification.class)
public abstract class GlobSpecification_ {

	public static volatile SingularAttribute<GlobSpecification, String> specVersion;
	public static volatile SingularAttribute<GlobSpecification, Date> temp;
	public static volatile SingularAttribute<GlobSpecification, String> lastModBy;
	public static volatile SingularAttribute<GlobSpecification, Character> internalSpec;
	public static volatile SingularAttribute<GlobSpecification, String> tempTmp;
	public static volatile SingularAttribute<GlobSpecification, String> createDateTmp;
	public static volatile SingularAttribute<GlobSpecification, BigInteger> testMethodId;
	public static volatile SingularAttribute<GlobSpecification, String> sName;
	public static volatile SingularAttribute<GlobSpecification, String> description;
	public static volatile SingularAttribute<GlobSpecification, Character> active;
	public static volatile SingularAttribute<GlobSpecification, String> createByIp;
	public static volatile SingularAttribute<GlobSpecification, String> createBy;
	public static volatile SingularAttribute<GlobSpecification, String> lastModIp;
	public static volatile SingularAttribute<GlobSpecification, BigInteger> defaultNoRows;
	public static volatile SingularAttribute<GlobSpecification, String> lastModTmp;
	public static volatile SingularAttribute<GlobSpecification, BigDecimal> id;
	public static volatile SingularAttribute<GlobSpecification, GlobOriginator> originatorId;
	public static volatile SingularAttribute<GlobSpecification, Date> lastMod;
	public static volatile SingularAttribute<GlobSpecification, Date> createDate;

	public static final String SPEC_VERSION = "specVersion";
	public static final String TEMP = "temp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String INTERNAL_SPEC = "internalSpec";
	public static final String TEMP_TMP = "tempTmp";
	public static final String CREATE_DATE_TMP = "createDateTmp";
	public static final String TEST_METHOD_ID = "testMethodId";
	public static final String S_NAME = "sName";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DEFAULT_NO_ROWS = "defaultNoRows";
	public static final String LAST_MOD_TMP = "lastModTmp";
	public static final String ID = "id";
	public static final String ORIGINATOR_ID = "originatorId";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";

}

