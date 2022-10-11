package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bpmrfimetadata.class)
public abstract class Bpmrfimetadata_ {

	public static volatile SingularAttribute<Bpmrfimetadata, String> externalUrl;
	public static volatile SingularAttribute<Bpmrfimetadata, BigInteger> persistenceversion;
	public static volatile SingularAttribute<Bpmrfimetadata, String> keywords;
	public static volatile SingularAttribute<Bpmrfimetadata, String> documentType;
	public static volatile SingularAttribute<Bpmrfimetadata, String> revisionDate;
	public static volatile SingularAttribute<Bpmrfimetadata, BigDecimal> persistenceid;
	public static volatile SingularAttribute<Bpmrfimetadata, String> discipline;
	public static volatile SingularAttribute<Bpmrfimetadata, String> contentType;
	public static volatile ListAttribute<Bpmrfimetadata, Bpmrfibo> bpmrfiboList;
	public static volatile SingularAttribute<Bpmrfimetadata, String> revision;

	public static final String EXTERNAL_URL = "externalUrl";
	public static final String PERSISTENCEVERSION = "persistenceversion";
	public static final String KEYWORDS = "keywords";
	public static final String DOCUMENT_TYPE = "documentType";
	public static final String REVISION_DATE = "revisionDate";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String DISCIPLINE = "discipline";
	public static final String CONTENT_TYPE = "contentType";
	public static final String BPMRFIBO_LIST = "bpmrfiboList";
	public static final String REVISION = "revision";

}

