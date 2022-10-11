package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaSampleDocs.class)
public abstract class QaSampleDocs_ {

	public static volatile SingularAttribute<QaSampleDocs, String> extension;
	public static volatile SingularAttribute<QaSampleDocs, String> fName;
	public static volatile SingularAttribute<QaSampleDocs, BigDecimal> sampleId;
	public static volatile SingularAttribute<QaSampleDocs, BigDecimal> id;
	public static volatile SingularAttribute<QaSampleDocs, String> fTitle;
	public static volatile SingularAttribute<QaSampleDocs, String> note1;
	public static volatile SingularAttribute<QaSampleDocs, String> sourcePath;

	public static final String EXTENSION = "extension";
	public static final String F_NAME = "fName";
	public static final String SAMPLE_ID = "sampleId";
	public static final String ID = "id";
	public static final String F_TITLE = "fTitle";
	public static final String NOTE1 = "note1";
	public static final String SOURCE_PATH = "sourcePath";

}

