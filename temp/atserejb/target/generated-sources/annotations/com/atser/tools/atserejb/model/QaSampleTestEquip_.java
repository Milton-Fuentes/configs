package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaSampleTestEquip.class)
public abstract class QaSampleTestEquip_ {

	public static volatile SingularAttribute<QaSampleTestEquip, BigInteger> equipId;
	public static volatile SingularAttribute<QaSampleTestEquip, BigDecimal> id;
	public static volatile SingularAttribute<QaSampleTestEquip, BigInteger> sampleTestId;
	public static volatile SingularAttribute<QaSampleTestEquip, String> remarks;

	public static final String EQUIP_ID = "equipId";
	public static final String ID = "id";
	public static final String SAMPLE_TEST_ID = "sampleTestId";
	public static final String REMARKS = "remarks";

}

