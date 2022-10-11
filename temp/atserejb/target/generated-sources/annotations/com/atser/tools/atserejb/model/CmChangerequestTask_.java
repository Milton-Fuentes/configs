package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmChangerequestTask.class)
public abstract class CmChangerequestTask_ {

	public static volatile SingularAttribute<CmChangerequestTask, Date> releasedtotestDate;
	public static volatile SingularAttribute<CmChangerequestTask, BigDecimal> cost;
	public static volatile SingularAttribute<CmChangerequestTask, CmChangerequest> crid;
	public static volatile SingularAttribute<CmChangerequestTask, BigInteger> approvedBy;
	public static volatile SingularAttribute<CmChangerequestTask, String> rejectreason;
	public static volatile SingularAttribute<CmChangerequestTask, String> description;
	public static volatile SingularAttribute<CmChangerequestTask, String> priority;
	public static volatile SingularAttribute<CmChangerequestTask, Date> releasedtoprodDate;
	public static volatile SingularAttribute<CmChangerequestTask, String> approvedDate;
	public static volatile SingularAttribute<CmChangerequestTask, String> internalStatus;
	public static volatile SingularAttribute<CmChangerequestTask, BigInteger> timer;
	public static volatile SingularAttribute<CmChangerequestTask, String> name;
	public static volatile SingularAttribute<CmChangerequestTask, BigDecimal> id;
	public static volatile SingularAttribute<CmChangerequestTask, BigInteger> time;
	public static volatile SingularAttribute<CmChangerequestTask, String> status;

	public static final String RELEASEDTOTEST_DATE = "releasedtotestDate";
	public static final String COST = "cost";
	public static final String CRID = "crid";
	public static final String APPROVED_BY = "approvedBy";
	public static final String REJECTREASON = "rejectreason";
	public static final String DESCRIPTION = "description";
	public static final String PRIORITY = "priority";
	public static final String RELEASEDTOPROD_DATE = "releasedtoprodDate";
	public static final String APPROVED_DATE = "approvedDate";
	public static final String INTERNAL_STATUS = "internalStatus";
	public static final String TIMER = "timer";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String TIME = "time";
	public static final String STATUS = "status";

}

