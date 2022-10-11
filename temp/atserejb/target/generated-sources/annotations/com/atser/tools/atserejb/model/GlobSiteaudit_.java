package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSiteaudit.class)
public abstract class GlobSiteaudit_ {

	public static volatile SingularAttribute<GlobSiteaudit, String> actedOnType;
	public static volatile SingularAttribute<GlobSiteaudit, String> field1;
	public static volatile SingularAttribute<GlobSiteaudit, Date> actionTime;
	public static volatile SingularAttribute<GlobSiteaudit, String> actedOnName;
	public static volatile SingularAttribute<GlobSiteaudit, Character> notified;
	public static volatile SingularAttribute<GlobSiteaudit, BigInteger> contractId;
	public static volatile SingularAttribute<GlobSiteaudit, String> action;
	public static volatile SingularAttribute<GlobSiteaudit, BigDecimal> id;
	public static volatile SingularAttribute<GlobSiteaudit, GlobUsers> userId;
	public static volatile SingularAttribute<GlobSiteaudit, BigInteger> projectId;
	public static volatile SingularAttribute<GlobSiteaudit, BigInteger> actedOnId;
	public static volatile SingularAttribute<GlobSiteaudit, BigInteger> parentId;

	public static final String ACTED_ON_TYPE = "actedOnType";
	public static final String FIELD1 = "field1";
	public static final String ACTION_TIME = "actionTime";
	public static final String ACTED_ON_NAME = "actedOnName";
	public static final String NOTIFIED = "notified";
	public static final String CONTRACT_ID = "contractId";
	public static final String ACTION = "action";
	public static final String ID = "id";
	public static final String USER_ID = "userId";
	public static final String PROJECT_ID = "projectId";
	public static final String ACTED_ON_ID = "actedOnId";
	public static final String PARENT_ID = "parentId";

}

