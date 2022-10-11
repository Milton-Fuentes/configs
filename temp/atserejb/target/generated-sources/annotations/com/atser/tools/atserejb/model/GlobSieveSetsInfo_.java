package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSieveSetsInfo.class)
public abstract class GlobSieveSetsInfo_ {

	public static volatile SingularAttribute<GlobSieveSetsInfo, String> setName;
	public static volatile SingularAttribute<GlobSieveSetsInfo, BigInteger> clientId;
	public static volatile SingularAttribute<GlobSieveSetsInfo, String> createDateTmp;
	public static volatile SingularAttribute<GlobSieveSetsInfo, String> createByIp;
	public static volatile ListAttribute<GlobSieveSetsInfo, GlobSieveSets> globSieveSetsList;
	public static volatile SingularAttribute<GlobSieveSetsInfo, String> specSection;
	public static volatile SingularAttribute<GlobSieveSetsInfo, String> field1;
	public static volatile SingularAttribute<GlobSieveSetsInfo, String> createBy;
	public static volatile SingularAttribute<GlobSieveSetsInfo, BigDecimal> id;
	public static volatile SingularAttribute<GlobSieveSetsInfo, String> field2;
	public static volatile SingularAttribute<GlobSieveSetsInfo, QaSampleCatg> categoryId;
	public static volatile SingularAttribute<GlobSieveSetsInfo, String> remarks;
	public static volatile SingularAttribute<GlobSieveSetsInfo, Date> createDate;

	public static final String SET_NAME = "setName";
	public static final String CLIENT_ID = "clientId";
	public static final String CREATE_DATE_TMP = "createDateTmp";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String GLOB_SIEVE_SETS_LIST = "globSieveSetsList";
	public static final String SPEC_SECTION = "specSection";
	public static final String FIELD1 = "field1";
	public static final String CREATE_BY = "createBy";
	public static final String ID = "id";
	public static final String FIELD2 = "field2";
	public static final String CATEGORY_ID = "categoryId";
	public static final String REMARKS = "remarks";
	public static final String CREATE_DATE = "createDate";

}

