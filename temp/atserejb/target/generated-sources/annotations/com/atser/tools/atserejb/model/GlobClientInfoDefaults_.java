package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientInfoDefaults.class)
public abstract class GlobClientInfoDefaults_ {

	public static volatile SingularAttribute<GlobClientInfoDefaults, BigInteger> functionId;
	public static volatile SingularAttribute<GlobClientInfoDefaults, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientInfoDefaults, BigInteger> contractorId;
	public static volatile SingularAttribute<GlobClientInfoDefaults, BigInteger> labId;
	public static volatile SingularAttribute<GlobClientInfoDefaults, BigInteger> contractId;
	public static volatile SingularAttribute<GlobClientInfoDefaults, BigInteger> disciplineId;
	public static volatile SingularAttribute<GlobClientInfoDefaults, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientInfoDefaults, BigInteger> projectId;

	public static final String FUNCTION_ID = "functionId";
	public static final String CLIENT_ID = "clientId";
	public static final String CONTRACTOR_ID = "contractorId";
	public static final String LAB_ID = "labId";
	public static final String CONTRACT_ID = "contractId";
	public static final String DISCIPLINE_ID = "disciplineId";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";

}

