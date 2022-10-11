package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFileTkMul.class)
public abstract class GlobFileTkMul_ {

	public static volatile SingularAttribute<GlobFileTkMul, GlobFileTk> fileTkId;
	public static volatile SingularAttribute<GlobFileTkMul, BigDecimal> id;
	public static volatile SingularAttribute<GlobFileTkMul, BigInteger> fileId;
	public static volatile SingularAttribute<GlobFileTkMul, BigInteger> status;

	public static final String FILE_TK_ID = "fileTkId";
	public static final String ID = "id";
	public static final String FILE_ID = "fileId";
	public static final String STATUS = "status";

}

