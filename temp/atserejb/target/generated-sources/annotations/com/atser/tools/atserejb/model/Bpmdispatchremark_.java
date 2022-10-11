package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bpmdispatchremark.class)
public abstract class Bpmdispatchremark_ {

	public static volatile SingularAttribute<Bpmdispatchremark, BigInteger> persistenceversion;
	public static volatile SingularAttribute<Bpmdispatchremark, String> reviewerName;
	public static volatile SingularAttribute<Bpmdispatchremark, String> reviewerId;
	public static volatile SingularAttribute<Bpmdispatchremark, String> created;
	public static volatile SingularAttribute<Bpmdispatchremark, Bpmdispatchbo> bpmdispatchboPid;
	public static volatile SingularAttribute<Bpmdispatchremark, BigDecimal> persistenceid;
	public static volatile SingularAttribute<Bpmdispatchremark, String> remark;
	public static volatile SingularAttribute<Bpmdispatchremark, Long> remarksOrder;
	public static volatile SingularAttribute<Bpmdispatchremark, String> reviewerRole;

	public static final String PERSISTENCEVERSION = "persistenceversion";
	public static final String REVIEWER_NAME = "reviewerName";
	public static final String REVIEWER_ID = "reviewerId";
	public static final String CREATED = "created";
	public static final String BPMDISPATCHBO_PID = "bpmdispatchboPid";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String REMARK = "remark";
	public static final String REMARKS_ORDER = "remarksOrder";
	public static final String REVIEWER_ROLE = "reviewerRole";

}

