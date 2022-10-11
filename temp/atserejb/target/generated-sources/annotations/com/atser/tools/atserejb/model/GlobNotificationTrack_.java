package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobNotificationTrack.class)
public abstract class GlobNotificationTrack_ {

	public static volatile SingularAttribute<GlobNotificationTrack, BigInteger> clientId;
	public static volatile SingularAttribute<GlobNotificationTrack, Date> created;
	public static volatile SingularAttribute<GlobNotificationTrack, String> subject;
	public static volatile SingularAttribute<GlobNotificationTrack, String> module;
	public static volatile SingularAttribute<GlobNotificationTrack, String> functionality;
	public static volatile SingularAttribute<GlobNotificationTrack, String> content;
	public static volatile SingularAttribute<GlobNotificationTrack, String> sentTo;
	public static volatile SingularAttribute<GlobNotificationTrack, String> senderInfo;
	public static volatile SingularAttribute<GlobNotificationTrack, String> answer;
	public static volatile SingularAttribute<GlobNotificationTrack, String> sentFrom;
	public static volatile SingularAttribute<GlobNotificationTrack, String> uniqueToken;
	public static volatile SingularAttribute<GlobNotificationTrack, BigDecimal> id;
	public static volatile SingularAttribute<GlobNotificationTrack, BigInteger> refid;
	public static volatile SingularAttribute<GlobNotificationTrack, BigInteger> projectId;
	public static volatile SingularAttribute<GlobNotificationTrack, String> ntfType;
	public static volatile SingularAttribute<GlobNotificationTrack, QmCvlFieldData> categoryId;
	public static volatile SingularAttribute<GlobNotificationTrack, String> status;

	public static final String CLIENT_ID = "clientId";
	public static final String CREATED = "created";
	public static final String SUBJECT = "subject";
	public static final String MODULE = "module";
	public static final String FUNCTIONALITY = "functionality";
	public static final String CONTENT = "content";
	public static final String SENT_TO = "sentTo";
	public static final String SENDER_INFO = "senderInfo";
	public static final String ANSWER = "answer";
	public static final String SENT_FROM = "sentFrom";
	public static final String UNIQUE_TOKEN = "uniqueToken";
	public static final String ID = "id";
	public static final String REFID = "refid";
	public static final String PROJECT_ID = "projectId";
	public static final String NTF_TYPE = "ntfType";
	public static final String CATEGORY_ID = "categoryId";
	public static final String STATUS = "status";

}

