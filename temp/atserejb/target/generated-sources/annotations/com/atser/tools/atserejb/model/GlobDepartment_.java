package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobDepartment.class)
public abstract class GlobDepartment_ {

	public static volatile SingularAttribute<GlobDepartment, String> departmentName;
	public static volatile SingularAttribute<GlobDepartment, BigInteger> clientId;
	public static volatile SingularAttribute<GlobDepartment, String> departmentId;
	public static volatile SingularAttribute<GlobDepartment, BigDecimal> id;

	public static final String DEPARTMENT_NAME = "departmentName";
	public static final String CLIENT_ID = "clientId";
	public static final String DEPARTMENT_ID = "departmentId";
	public static final String ID = "id";

}

