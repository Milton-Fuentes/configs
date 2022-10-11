package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientApproval.class)
public abstract class GlobClientApproval_ {

	public static volatile SingularAttribute<GlobClientApproval, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientApproval, BigInteger> approvalOrder;
	public static volatile SingularAttribute<GlobClientApproval, String> approvalName;
	public static volatile SingularAttribute<GlobClientApproval, BigDecimal> id;

	public static final String CLIENT_ID = "clientId";
	public static final String APPROVAL_ORDER = "approvalOrder";
	public static final String APPROVAL_NAME = "approvalName";
	public static final String ID = "id";

}

