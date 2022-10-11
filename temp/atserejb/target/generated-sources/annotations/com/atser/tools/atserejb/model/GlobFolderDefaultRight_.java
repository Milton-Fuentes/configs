package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFolderDefaultRight.class)
public abstract class GlobFolderDefaultRight_ {

	public static volatile SingularAttribute<GlobFolderDefaultRight, Character> rDnload;
	public static volatile SingularAttribute<GlobFolderDefaultRight, BigInteger> trusteeId;
	public static volatile SingularAttribute<GlobFolderDefaultRight, BigInteger> folderDefaultId;
	public static volatile SingularAttribute<GlobFolderDefaultRight, BigInteger> trusteeType;
	public static volatile SingularAttribute<GlobFolderDefaultRight, Character> rOwner;
	public static volatile SingularAttribute<GlobFolderDefaultRight, Character> rModify;
	public static volatile SingularAttribute<GlobFolderDefaultRight, BigDecimal> id;
	public static volatile SingularAttribute<GlobFolderDefaultRight, Character> rBrowse;
	public static volatile SingularAttribute<GlobFolderDefaultRight, Character> rUpload;
	public static volatile SingularAttribute<GlobFolderDefaultRight, Character> rDelete;
	public static volatile SingularAttribute<GlobFolderDefaultRight, Character> rCreate;

	public static final String R_DNLOAD = "rDnload";
	public static final String TRUSTEE_ID = "trusteeId";
	public static final String FOLDER_DEFAULT_ID = "folderDefaultId";
	public static final String TRUSTEE_TYPE = "trusteeType";
	public static final String R_OWNER = "rOwner";
	public static final String R_MODIFY = "rModify";
	public static final String ID = "id";
	public static final String R_BROWSE = "rBrowse";
	public static final String R_UPLOAD = "rUpload";
	public static final String R_DELETE = "rDelete";
	public static final String R_CREATE = "rCreate";

}

