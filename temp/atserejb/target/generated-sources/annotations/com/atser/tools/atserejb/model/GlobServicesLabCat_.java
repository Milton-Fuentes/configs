package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobServicesLabCat.class)
public abstract class GlobServicesLabCat_ {

	public static volatile SingularAttribute<GlobServicesLabCat, BigInteger> clientId;
	public static volatile SingularAttribute<GlobServicesLabCat, BigInteger> listOrder;
	public static volatile SingularAttribute<GlobServicesLabCat, BigDecimal> id;
	public static volatile SingularAttribute<GlobServicesLabCat, String> category;

	public static final String CLIENT_ID = "clientId";
	public static final String LIST_ORDER = "listOrder";
	public static final String ID = "id";
	public static final String CATEGORY = "category";

}

