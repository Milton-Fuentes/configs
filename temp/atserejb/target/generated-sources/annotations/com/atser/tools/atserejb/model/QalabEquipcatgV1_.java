package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QalabEquipcatgV1.class)
public abstract class QalabEquipcatgV1_ {

	public static volatile SingularAttribute<QalabEquipcatgV1, String> field1;
	public static volatile SingularAttribute<QalabEquipcatgV1, String> sampleCatgName;
	public static volatile SingularAttribute<QalabEquipcatgV1, String> field7;
	public static volatile SingularAttribute<QalabEquipcatgV1, BigInteger> field6;
	public static volatile ListAttribute<QalabEquipcatgV1, QalabEquiptypeV1> qalabEquiptypeList;
	public static volatile SingularAttribute<QalabEquipcatgV1, BigDecimal> id;
	public static volatile SingularAttribute<QalabEquipcatgV1, String> field8;
	public static volatile SingularAttribute<QalabEquipcatgV1, String> category;
	public static volatile SingularAttribute<QalabEquipcatgV1, String> field3;
	public static volatile SingularAttribute<QalabEquipcatgV1, String> field2;
	public static volatile SingularAttribute<QalabEquipcatgV1, BigInteger> field5;
	public static volatile SingularAttribute<QalabEquipcatgV1, String> field4;

	public static final String FIELD1 = "field1";
	public static final String SAMPLE_CATG_NAME = "sampleCatgName";
	public static final String FIELD7 = "field7";
	public static final String FIELD6 = "field6";
	public static final String QALAB_EQUIPTYPE_LIST = "qalabEquiptypeList";
	public static final String ID = "id";
	public static final String FIELD8 = "field8";
	public static final String CATEGORY = "category";
	public static final String FIELD3 = "field3";
	public static final String FIELD2 = "field2";
	public static final String FIELD5 = "field5";
	public static final String FIELD4 = "field4";

}

