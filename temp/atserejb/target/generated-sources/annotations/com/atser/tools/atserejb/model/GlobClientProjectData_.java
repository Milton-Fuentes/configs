package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientProjectData.class)
public abstract class GlobClientProjectData_ {

	public static volatile SingularAttribute<GlobClientProjectData, String> phase;
	public static volatile SingularAttribute<GlobClientProjectData, BigInteger> projectCount;
	public static volatile SingularAttribute<GlobClientProjectData, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientProjectData, String> description;
	public static volatile SingularAttribute<GlobClientProjectData, Double> currentAmount;
	public static volatile SingularAttribute<GlobClientProjectData, BigDecimal> id;

	public static final String PHASE = "phase";
	public static final String PROJECT_COUNT = "projectCount";
	public static final String CLIENT_ID = "clientId";
	public static final String DESCRIPTION = "description";
	public static final String CURRENT_AMOUNT = "currentAmount";
	public static final String ID = "id";

}

