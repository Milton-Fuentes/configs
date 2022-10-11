package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectApproval.class)
public abstract class GlobProjectApproval_ {

	public static volatile SingularAttribute<GlobProjectApproval, String> approvalType;
	public static volatile SingularAttribute<GlobProjectApproval, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectApproval, BigInteger> projectId;
	public static volatile SingularAttribute<GlobProjectApproval, BigInteger> userId;

	public static final String APPROVAL_TYPE = "approvalType";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String USER_ID = "userId";

}

