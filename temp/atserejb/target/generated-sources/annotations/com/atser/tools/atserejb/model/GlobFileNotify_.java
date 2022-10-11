package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFileNotify.class)
public abstract class GlobFileNotify_ {

	public static volatile SingularAttribute<GlobFileNotify, GlobUsers> senderId;
	public static volatile SingularAttribute<GlobFileNotify, GlobSiteaudit> siteauditId;
	public static volatile SingularAttribute<GlobFileNotify, BigDecimal> id;
	public static volatile SingularAttribute<GlobFileNotify, GlobUsers> recieverId;
	public static volatile SingularAttribute<GlobFileNotify, BigInteger> fileId;
	public static volatile SingularAttribute<GlobFileNotify, Date> dateNotify;

	public static final String SENDER_ID = "senderId";
	public static final String SITEAUDIT_ID = "siteauditId";
	public static final String ID = "id";
	public static final String RECIEVER_ID = "recieverId";
	public static final String FILE_ID = "fileId";
	public static final String DATE_NOTIFY = "dateNotify";

}

