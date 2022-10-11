package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFolderRight.class)
public abstract class GlobFolderRight_ {

	public static volatile SingularAttribute<GlobFolderRight, Character> rDnload;
	public static volatile SingularAttribute<GlobFolderRight, BigInteger> trusteeId;
	public static volatile SingularAttribute<GlobFolderRight, Character> system;
	public static volatile SingularAttribute<GlobFolderRight, BigInteger> trusteeType;
	public static volatile SingularAttribute<GlobFolderRight, Character> rOwner;
	public static volatile SingularAttribute<GlobFolderRight, Character> rModify;
	public static volatile SingularAttribute<GlobFolderRight, BigDecimal> id;
	public static volatile SingularAttribute<GlobFolderRight, Character> rDelete;
	public static volatile SingularAttribute<GlobFolderRight, Character> rUpload;
	public static volatile SingularAttribute<GlobFolderRight, Character> rBrowse;
	public static volatile SingularAttribute<GlobFolderRight, BigInteger> folderId;
	public static volatile SingularAttribute<GlobFolderRight, Character> rCreate;

	public static final String R_DNLOAD = "rDnload";
	public static final String TRUSTEE_ID = "trusteeId";
	public static final String SYSTEM = "system";
	public static final String TRUSTEE_TYPE = "trusteeType";
	public static final String R_OWNER = "rOwner";
	public static final String R_MODIFY = "rModify";
	public static final String ID = "id";
	public static final String R_DELETE = "rDelete";
	public static final String R_UPLOAD = "rUpload";
	public static final String R_BROWSE = "rBrowse";
	public static final String FOLDER_ID = "folderId";
	public static final String R_CREATE = "rCreate";

}

