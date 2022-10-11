package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BpmModelField.class)
public abstract class BpmModelField_ {

	public static volatile SingularAttribute<BpmModelField, BigDecimal> id;
	public static volatile SingularAttribute<BpmModelField, String> value;
	public static volatile SingularAttribute<BpmModelField, BigInteger> taskId;

	public static final String ID = "id";
	public static final String VALUE = "value";
	public static final String TASK_ID = "taskId";

}

