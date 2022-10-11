package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobContactCertDocs.class)
public abstract class GlobContactCertDocs_ {

	public static volatile SingularAttribute<GlobContactCertDocs, BigInteger> contactCertId;
	public static volatile SingularAttribute<GlobContactCertDocs, String> extension;
	public static volatile SingularAttribute<GlobContactCertDocs, String> fName;
	public static volatile SingularAttribute<GlobContactCertDocs, BigDecimal> id;
	public static volatile SingularAttribute<GlobContactCertDocs, String> fTitle;
	public static volatile SingularAttribute<GlobContactCertDocs, String> note1;
	public static volatile SingularAttribute<GlobContactCertDocs, String> sourcePath;

	public static final String CONTACT_CERT_ID = "contactCertId";
	public static final String EXTENSION = "extension";
	public static final String F_NAME = "fName";
	public static final String ID = "id";
	public static final String F_TITLE = "fTitle";
	public static final String NOTE1 = "note1";
	public static final String SOURCE_PATH = "sourcePath";

}

