package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmFormRouting.class)
public abstract class CmFormRouting_ {

	public static volatile SingularAttribute<CmFormRouting, String> respType;
	public static volatile SingularAttribute<CmFormRouting, String> cc;
	public static volatile SingularAttribute<CmFormRouting, String> rType;
	public static volatile SingularAttribute<CmFormRouting, String> comments;
	public static volatile SingularAttribute<CmFormRouting, BigInteger> receiver;
	public static volatile SingularAttribute<CmFormRouting, BigInteger> author;
	public static volatile SingularAttribute<CmFormRouting, BigInteger> ccParent;
	public static volatile SingularAttribute<CmFormRouting, String> respSubject;
	public static volatile SingularAttribute<CmFormRouting, CmForm> cmFormId;
	public static volatile SingularAttribute<CmFormRouting, Date> respBy;
	public static volatile SingularAttribute<CmFormRouting, Date> opened;
	public static volatile SingularAttribute<CmFormRouting, String> priority;
	public static volatile SingularAttribute<CmFormRouting, BigInteger> parentId;
	public static volatile SingularAttribute<CmFormRouting, BigDecimal> id;
	public static volatile SingularAttribute<CmFormRouting, Date> send;
	public static volatile SingularAttribute<CmFormRouting, Character> respRequired;
	public static volatile SingularAttribute<CmFormRouting, Date> responded;

	public static final String RESP_TYPE = "respType";
	public static final String CC = "cc";
	public static final String R_TYPE = "rType";
	public static final String COMMENTS = "comments";
	public static final String RECEIVER = "receiver";
	public static final String AUTHOR = "author";
	public static final String CC_PARENT = "ccParent";
	public static final String RESP_SUBJECT = "respSubject";
	public static final String CM_FORM_ID = "cmFormId";
	public static final String RESP_BY = "respBy";
	public static final String OPENED = "opened";
	public static final String PRIORITY = "priority";
	public static final String PARENT_ID = "parentId";
	public static final String ID = "id";
	public static final String SEND = "send";
	public static final String RESP_REQUIRED = "respRequired";
	public static final String RESPONDED = "responded";

}

