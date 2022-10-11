package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobServicesLab.class)
public abstract class GlobServicesLab_ {

	public static volatile SingularAttribute<GlobServicesLab, String> code;
	public static volatile SingularAttribute<GlobServicesLab, BigInteger> clientId;
	public static volatile SingularAttribute<GlobServicesLab, String> description;
	public static volatile SingularAttribute<GlobServicesLab, BigInteger> labCategoryId;
	public static volatile SingularAttribute<GlobServicesLab, BigDecimal> id;

	public static final String CODE = "code";
	public static final String CLIENT_ID = "clientId";
	public static final String DESCRIPTION = "description";
	public static final String LAB_CATEGORY_ID = "labCategoryId";
	public static final String ID = "id";

}

