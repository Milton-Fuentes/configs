package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjectFeeSchedule.class)
public abstract class GlobProjectFeeSchedule_ {

	public static volatile SingularAttribute<GlobProjectFeeSchedule, BigInteger> rateTableId;
	public static volatile SingularAttribute<GlobProjectFeeSchedule, Date> endDate;
	public static volatile SingularAttribute<GlobProjectFeeSchedule, BigDecimal> id;
	public static volatile SingularAttribute<GlobProjectFeeSchedule, BigInteger> projectId;
	public static volatile SingularAttribute<GlobProjectFeeSchedule, Date> startDate;

	public static final String RATE_TABLE_ID = "rateTableId";
	public static final String END_DATE = "endDate";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String START_DATE = "startDate";

}

