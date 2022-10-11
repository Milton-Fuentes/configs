package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaspecConcSource.class)
public abstract class QaspecConcSource_ {

	public static volatile SingularAttribute<QaspecConcSource, BigInteger> clientId;
	public static volatile SingularAttribute<QaspecConcSource, BigDecimal> id;
	public static volatile SingularAttribute<QaspecConcSource, String> source;

	public static final String CLIENT_ID = "clientId";
	public static final String ID = "id";
	public static final String SOURCE = "source";

}

