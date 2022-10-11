package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmDocs.class)
public abstract class CmDocs_ {

	public static volatile SingularAttribute<CmDocs, String> extension;
	public static volatile SingularAttribute<CmDocs, String> fName;
	public static volatile SingularAttribute<CmDocs, BigInteger> docId;
	public static volatile SingularAttribute<CmDocs, BigDecimal> id;
	public static volatile SingularAttribute<CmDocs, String> fTitle;
	public static volatile SingularAttribute<CmDocs, String> note1;
	public static volatile SingularAttribute<CmDocs, String> cmTypeName;
	public static volatile SingularAttribute<CmDocs, String> sourcePath;

	public static final String EXTENSION = "extension";
	public static final String F_NAME = "fName";
	public static final String DOC_ID = "docId";
	public static final String ID = "id";
	public static final String F_TITLE = "fTitle";
	public static final String NOTE1 = "note1";
	public static final String CM_TYPE_NAME = "cmTypeName";
	public static final String SOURCE_PATH = "sourcePath";

}

