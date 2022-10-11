package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectContract.class)
public abstract class GlobProjectContract_ {

	public static volatile SingularAttribute<GlobProjectContract, BigInteger> listOrder;
	public static volatile SingularAttribute<GlobProjectContract, String> contractName;
	public static volatile SingularAttribute<GlobProjectContract, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectContract, BigInteger> projectId;

	public static final String LIST_ORDER = "listOrder";
	public static final String CONTRACT_NAME = "contractName";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";

}

