package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFileRight.class)
public abstract class GlobFileRight_ {

	public static volatile SingularAttribute<GlobFileRight, Character> rDnload;
	public static volatile SingularAttribute<GlobFileRight, BigInteger> trusteeId;
	public static volatile SingularAttribute<GlobFileRight, BigInteger> trusteeType;
	public static volatile SingularAttribute<GlobFileRight, Character> rOwner;
	public static volatile SingularAttribute<GlobFileRight, Character> rModify;
	public static volatile SingularAttribute<GlobFileRight, BigDecimal> id;
	public static volatile SingularAttribute<GlobFileRight, Character> rDelete;
	public static volatile SingularAttribute<GlobFileRight, Character> rUpload;
	public static volatile SingularAttribute<GlobFileRight, Character> rBrowse;
	public static volatile SingularAttribute<GlobFileRight, Character> rCreate;
	public static volatile SingularAttribute<GlobFileRight, BigInteger> fileId;

	public static final String R_DNLOAD = "rDnload";
	public static final String TRUSTEE_ID = "trusteeId";
	public static final String TRUSTEE_TYPE = "trusteeType";
	public static final String R_OWNER = "rOwner";
	public static final String R_MODIFY = "rModify";
	public static final String ID = "id";
	public static final String R_DELETE = "rDelete";
	public static final String R_UPLOAD = "rUpload";
	public static final String R_BROWSE = "rBrowse";
	public static final String R_CREATE = "rCreate";
	public static final String FILE_ID = "fileId";

}

