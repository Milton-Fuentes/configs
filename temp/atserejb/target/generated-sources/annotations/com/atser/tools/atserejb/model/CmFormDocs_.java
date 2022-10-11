package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmFormDocs.class)
public abstract class CmFormDocs_ {

	public static volatile SingularAttribute<CmFormDocs, String> extension;
	public static volatile SingularAttribute<CmFormDocs, String> fName;
	public static volatile SingularAttribute<CmFormDocs, BigInteger> cmFormId;
	public static volatile SingularAttribute<CmFormDocs, BigDecimal> id;
	public static volatile SingularAttribute<CmFormDocs, String> fTitle;
	public static volatile SingularAttribute<CmFormDocs, String> note1;
	public static volatile SingularAttribute<CmFormDocs, String> sourcePath;

	public static final String EXTENSION = "extension";
	public static final String F_NAME = "fName";
	public static final String CM_FORM_ID = "cmFormId";
	public static final String ID = "id";
	public static final String F_TITLE = "fTitle";
	public static final String NOTE1 = "note1";
	public static final String SOURCE_PATH = "sourcePath";

}

