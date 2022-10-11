package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bpmsubmittalmetadata.class)
public abstract class Bpmsubmittalmetadata_ {

	public static volatile SingularAttribute<Bpmsubmittalmetadata, String> externalUrl;
	public static volatile SingularAttribute<Bpmsubmittalmetadata, BigInteger> persistenceversion;
	public static volatile SingularAttribute<Bpmsubmittalmetadata, String> keywords;
	public static volatile SingularAttribute<Bpmsubmittalmetadata, String> documentType;
	public static volatile ListAttribute<Bpmsubmittalmetadata, Bpmsubmittalbo> bpmsubmittalboList;
	public static volatile SingularAttribute<Bpmsubmittalmetadata, BigDecimal> persistenceid;
	public static volatile SingularAttribute<Bpmsubmittalmetadata, String> discipline;
	public static volatile SingularAttribute<Bpmsubmittalmetadata, String> contentType;
	public static volatile SingularAttribute<Bpmsubmittalmetadata, String> revision;

	public static final String EXTERNAL_URL = "externalUrl";
	public static final String PERSISTENCEVERSION = "persistenceversion";
	public static final String KEYWORDS = "keywords";
	public static final String DOCUMENT_TYPE = "documentType";
	public static final String BPMSUBMITTALBO_LIST = "bpmsubmittalboList";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String DISCIPLINE = "discipline";
	public static final String CONTENT_TYPE = "contentType";
	public static final String REVISION = "revision";

}

