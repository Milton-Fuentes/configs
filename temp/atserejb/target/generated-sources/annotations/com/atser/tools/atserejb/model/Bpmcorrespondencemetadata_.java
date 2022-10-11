package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bpmcorrespondencemetadata.class)
public abstract class Bpmcorrespondencemetadata_ {

	public static volatile SingularAttribute<Bpmcorrespondencemetadata, String> personSentTo;
	public static volatile SingularAttribute<Bpmcorrespondencemetadata, BigInteger> persistenceversion;
	public static volatile ListAttribute<Bpmcorrespondencemetadata, Bpmcorrespondencebo> bpmcorrespondenceboList;
	public static volatile SingularAttribute<Bpmcorrespondencemetadata, String> keywords;
	public static volatile SingularAttribute<Bpmcorrespondencemetadata, String> deliveryMethod;
	public static volatile SingularAttribute<Bpmcorrespondencemetadata, String> sentReceived;
	public static volatile SingularAttribute<Bpmcorrespondencemetadata, String> subject;
	public static volatile SingularAttribute<Bpmcorrespondencemetadata, String> sentReceivedDate;
	public static volatile SingularAttribute<Bpmcorrespondencemetadata, BigDecimal> persistenceid;
	public static volatile SingularAttribute<Bpmcorrespondencemetadata, String> companySentTo;
	public static volatile SingularAttribute<Bpmcorrespondencemetadata, String> trackingNumber;
	public static volatile SingularAttribute<Bpmcorrespondencemetadata, String> revision;

	public static final String PERSON_SENT_TO = "personSentTo";
	public static final String PERSISTENCEVERSION = "persistenceversion";
	public static final String BPMCORRESPONDENCEBO_LIST = "bpmcorrespondenceboList";
	public static final String KEYWORDS = "keywords";
	public static final String DELIVERY_METHOD = "deliveryMethod";
	public static final String SENT_RECEIVED = "sentReceived";
	public static final String SUBJECT = "subject";
	public static final String SENT_RECEIVED_DATE = "sentReceivedDate";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String COMPANY_SENT_TO = "companySentTo";
	public static final String TRACKING_NUMBER = "trackingNumber";
	public static final String REVISION = "revision";

}

