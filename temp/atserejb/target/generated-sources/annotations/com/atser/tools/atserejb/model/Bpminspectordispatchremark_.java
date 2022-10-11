package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bpminspectordispatchremark.class)
public abstract class Bpminspectordispatchremark_ {

	public static volatile SingularAttribute<Bpminspectordispatchremark, BigInteger> persistenceversion;
	public static volatile SingularAttribute<Bpminspectordispatchremark, String> reviewerName;
	public static volatile SingularAttribute<Bpminspectordispatchremark, String> reviewerId;
	public static volatile SingularAttribute<Bpminspectordispatchremark, String> created;
	public static volatile SingularAttribute<Bpminspectordispatchremark, BigDecimal> persistenceid;
	public static volatile SingularAttribute<Bpminspectordispatchremark, String> remark;
	public static volatile SingularAttribute<Bpminspectordispatchremark, Long> remarksOrder;
	public static volatile SingularAttribute<Bpminspectordispatchremark, Bpminspectordispatchbo> bpminspectordispatchboPid;
	public static volatile SingularAttribute<Bpminspectordispatchremark, String> reviewerRole;

	public static final String PERSISTENCEVERSION = "persistenceversion";
	public static final String REVIEWER_NAME = "reviewerName";
	public static final String REVIEWER_ID = "reviewerId";
	public static final String CREATED = "created";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String REMARK = "remark";
	public static final String REMARKS_ORDER = "remarksOrder";
	public static final String BPMINSPECTORDISPATCHBO_PID = "bpminspectordispatchboPid";
	public static final String REVIEWER_ROLE = "reviewerRole";

}

