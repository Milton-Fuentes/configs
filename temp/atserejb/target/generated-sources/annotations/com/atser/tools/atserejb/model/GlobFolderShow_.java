package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFolderShow.class)
public abstract class GlobFolderShow_ {

	public static volatile SingularAttribute<GlobFolderShow, BigInteger> trusteeId;
	public static volatile SingularAttribute<GlobFolderShow, BigInteger> trusteeType;
	public static volatile SingularAttribute<GlobFolderShow, BigDecimal> id;
	public static volatile SingularAttribute<GlobFolderShow, BigInteger> sCount;
	public static volatile SingularAttribute<GlobFolderShow, BigInteger> folderId;

	public static final String TRUSTEE_ID = "trusteeId";
	public static final String TRUSTEE_TYPE = "trusteeType";
	public static final String ID = "id";
	public static final String S_COUNT = "sCount";
	public static final String FOLDER_ID = "folderId";

}

