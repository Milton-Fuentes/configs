package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobBillingCode.class)
public abstract class GlobBillingCode_ {

	public static volatile SingularAttribute<GlobBillingCode, Character> byQuotation;
	public static volatile SingularAttribute<GlobBillingCode, String> standarditem;
	public static volatile SingularAttribute<GlobBillingCode, BigInteger> billingCategoryId;
	public static volatile SingularAttribute<GlobBillingCode, String> description;
	public static volatile SingularAttribute<GlobBillingCode, Character> costPlus;
	public static volatile SingularAttribute<GlobBillingCode, BigDecimal> id;
	public static volatile SingularAttribute<GlobBillingCode, String> unitofmeasure;
	public static volatile SingularAttribute<GlobBillingCode, BigInteger> materialUseId;

	public static final String BY_QUOTATION = "byQuotation";
	public static final String STANDARDITEM = "standarditem";
	public static final String BILLING_CATEGORY_ID = "billingCategoryId";
	public static final String DESCRIPTION = "description";
	public static final String COST_PLUS = "costPlus";
	public static final String ID = "id";
	public static final String UNITOFMEASURE = "unitofmeasure";
	public static final String MATERIAL_USE_ID = "materialUseId";

}

