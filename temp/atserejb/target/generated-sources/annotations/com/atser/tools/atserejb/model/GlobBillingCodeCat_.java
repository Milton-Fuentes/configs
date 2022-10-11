package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobBillingCodeCat.class)
public abstract class GlobBillingCodeCat_ {

	public static volatile SingularAttribute<GlobBillingCodeCat, BigInteger> companyId;
	public static volatile SingularAttribute<GlobBillingCodeCat, BigInteger> clientId;
	public static volatile SingularAttribute<GlobBillingCodeCat, BigInteger> listOrder;
	public static volatile SingularAttribute<GlobBillingCodeCat, BigDecimal> id;
	public static volatile SingularAttribute<GlobBillingCodeCat, String> category;

	public static final String COMPANY_ID = "companyId";
	public static final String CLIENT_ID = "clientId";
	public static final String LIST_ORDER = "listOrder";
	public static final String ID = "id";
	public static final String CATEGORY = "category";

}

