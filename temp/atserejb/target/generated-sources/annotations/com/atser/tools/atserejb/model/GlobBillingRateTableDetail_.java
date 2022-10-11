package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobBillingRateTableDetail.class)
public abstract class GlobBillingRateTableDetail_ {

	public static volatile SingularAttribute<GlobBillingRateTableDetail, QaSampleTestBillingItem> billingCodeId;
	public static volatile SingularAttribute<GlobBillingRateTableDetail, BigInteger> rateTableId;
	public static volatile SingularAttribute<GlobBillingRateTableDetail, BigDecimal> id;
	public static volatile SingularAttribute<GlobBillingRateTableDetail, String> unitprice;

	public static final String BILLING_CODE_ID = "billingCodeId";
	public static final String RATE_TABLE_ID = "rateTableId";
	public static final String ID = "id";
	public static final String UNITPRICE = "unitprice";

}

