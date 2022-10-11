package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmFormSpecs.class)
public abstract class CmFormSpecs_ {

	public static volatile SingularAttribute<CmFormSpecs, String> specName;
	public static volatile SingularAttribute<CmFormSpecs, String> specNo;
	public static volatile SingularAttribute<CmFormSpecs, BigDecimal> id;
	public static volatile SingularAttribute<CmFormSpecs, BigInteger> projectId;

	public static final String SPEC_NAME = "specName";
	public static final String SPEC_NO = "specNo";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";

}

