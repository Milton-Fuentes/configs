package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaconcMixdesignMasterproject.class)
public abstract class QaconcMixdesignMasterproject_ {

	public static volatile SingularAttribute<QaconcMixdesignMasterproject, BigDecimal> id;
	public static volatile SingularAttribute<QaconcMixdesignMasterproject, QaconcMixdesignMaster> mixDesignId;
	public static volatile SingularAttribute<QaconcMixdesignMasterproject, BigInteger> projectId;

	public static final String ID = "id";
	public static final String MIX_DESIGN_ID = "mixDesignId";
	public static final String PROJECT_ID = "projectId";

}

