package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFileSecondary.class)
public abstract class GlobFileSecondary_ {

	public static volatile SingularAttribute<GlobFileSecondary, String> serverPath;
	public static volatile SingularAttribute<GlobFileSecondary, String> extension;
	public static volatile SingularAttribute<GlobFileSecondary, String> fName;
	public static volatile SingularAttribute<GlobFileSecondary, BigDecimal> id;
	public static volatile SingularAttribute<GlobFileSecondary, BigInteger> fileId;
	public static volatile SingularAttribute<GlobFileSecondary, String> status;

	public static final String SERVER_PATH = "serverPath";
	public static final String EXTENSION = "extension";
	public static final String F_NAME = "fName";
	public static final String ID = "id";
	public static final String FILE_ID = "fileId";
	public static final String STATUS = "status";

}

