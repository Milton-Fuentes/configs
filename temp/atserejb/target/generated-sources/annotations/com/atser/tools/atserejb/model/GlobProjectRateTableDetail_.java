package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectRateTableDetail.class)
public abstract class GlobProjectRateTableDetail_ {

	public static volatile SingularAttribute<GlobProjectRateTableDetail, QaSampleTestBillingItem> billingCodeId;
	public static volatile SingularAttribute<GlobProjectRateTableDetail, BigInteger> rateTableId;
	public static volatile SingularAttribute<GlobProjectRateTableDetail, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectRateTableDetail, BigInteger> projectId;

	public static final String BILLING_CODE_ID = "billingCodeId";
	public static final String RATE_TABLE_ID = "rateTableId";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";

}

