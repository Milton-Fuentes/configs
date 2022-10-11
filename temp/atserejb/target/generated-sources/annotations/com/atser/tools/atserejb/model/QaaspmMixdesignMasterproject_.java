package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaaspmMixdesignMasterproject.class)
public abstract class QaaspmMixdesignMasterproject_ {

	public static volatile SingularAttribute<QaaspmMixdesignMasterproject, BigDecimal> id;
	public static volatile SingularAttribute<QaaspmMixdesignMasterproject, QaaspmMixdesignMaster> mixDesignId;
	public static volatile SingularAttribute<QaaspmMixdesignMasterproject, BigInteger> projectId;

	public static final String ID = "id";
	public static final String MIX_DESIGN_ID = "mixDesignId";
	public static final String PROJECT_ID = "projectId";

}

