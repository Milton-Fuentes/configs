package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobLogos.class)
public abstract class GlobLogos_ {

	public static volatile SingularAttribute<GlobLogos, BigInteger> functionId;
	public static volatile SingularAttribute<GlobLogos, BigInteger> clientId;
	public static volatile SingularAttribute<GlobLogos, BigInteger> contractorId;
	public static volatile SingularAttribute<GlobLogos, BigInteger> labId;
	public static volatile SingularAttribute<GlobLogos, BigInteger> contractId;
	public static volatile SingularAttribute<GlobLogos, BigInteger> disciplineId;
	public static volatile SingularAttribute<GlobLogos, byte[]> logo;
	public static volatile SingularAttribute<GlobLogos, BigDecimal> id;
	public static volatile SingularAttribute<GlobLogos, BigInteger> projectId;

	public static final String FUNCTION_ID = "functionId";
	public static final String CLIENT_ID = "clientId";
	public static final String CONTRACTOR_ID = "contractorId";
	public static final String LAB_ID = "labId";
	public static final String CONTRACT_ID = "contractId";
	public static final String DISCIPLINE_ID = "disciplineId";
	public static final String LOGO = "logo";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";

}

