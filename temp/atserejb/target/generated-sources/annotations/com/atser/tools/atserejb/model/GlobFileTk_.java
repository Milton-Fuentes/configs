package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFileTk.class)
public abstract class GlobFileTk_ {

	public static volatile SingularAttribute<GlobFileTk, BigInteger> expireDays;
	public static volatile SingularAttribute<GlobFileTk, BigInteger> clientId;
	public static volatile SingularAttribute<GlobFileTk, Date> created;
	public static volatile ListAttribute<GlobFileTk, GlobFileTkMul> globFileTkMulList;
	public static volatile ListAttribute<GlobFileTk, GlobFileTkShare> globFileTkShareList;
	public static volatile SingularAttribute<GlobFileTk, BigDecimal> id;
	public static volatile SingularAttribute<GlobFileTk, BigInteger> fileId;
	public static volatile SingularAttribute<GlobFileTk, String> token;
	public static volatile SingularAttribute<GlobFileTk, BigInteger> status;
	public static volatile SingularAttribute<GlobFileTk, Date> accessTime;

	public static final String EXPIRE_DAYS = "expireDays";
	public static final String CLIENT_ID = "clientId";
	public static final String CREATED = "created";
	public static final String GLOB_FILE_TK_MUL_LIST = "globFileTkMulList";
	public static final String GLOB_FILE_TK_SHARE_LIST = "globFileTkShareList";
	public static final String ID = "id";
	public static final String FILE_ID = "fileId";
	public static final String TOKEN = "token";
	public static final String STATUS = "status";
	public static final String ACCESS_TIME = "accessTime";

}

