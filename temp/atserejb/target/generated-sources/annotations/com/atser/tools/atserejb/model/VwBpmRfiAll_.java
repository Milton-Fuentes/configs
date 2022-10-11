package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwBpmRfiAll.class)
public abstract class VwBpmRfiAll_ {

	public static volatile SingularAttribute<VwBpmRfiAll, BigDecimal> clientId;
	public static volatile SingularAttribute<VwBpmRfiAll, String> rfinumber;
	public static volatile SingularAttribute<VwBpmRfiAll, Date> created;
	public static volatile SingularAttribute<VwBpmRfiAll, String> finaldisposition;
	public static volatile SingularAttribute<VwBpmRfiAll, String> prioritycode;
	public static volatile SingularAttribute<VwBpmRfiAll, Character> checkWorkImpact;
	public static volatile SingularAttribute<VwBpmRfiAll, String> source;
	public static volatile SingularAttribute<VwBpmRfiAll, String> rfiname;
	public static volatile SingularAttribute<VwBpmRfiAll, Character> checkCostImpact;
	public static volatile SingularAttribute<VwBpmRfiAll, Bpmrfimetadata> dcDataPid;
	public static volatile SingularAttribute<VwBpmRfiAll, Character> checkScheduleImpact;
	public static volatile SingularAttribute<VwBpmRfiAll, String> responseDueDate;
	public static volatile SingularAttribute<VwBpmRfiAll, BigDecimal> persistenceid;
	public static volatile SingularAttribute<VwBpmRfiAll, BigDecimal> projectId;
	public static volatile SingularAttribute<VwBpmRfiAll, Date> doneDate;
	public static volatile SingularAttribute<VwBpmRfiAll, String> status;

	public static final String CLIENT_ID = "clientId";
	public static final String RFINUMBER = "rfinumber";
	public static final String CREATED = "created";
	public static final String FINALDISPOSITION = "finaldisposition";
	public static final String PRIORITYCODE = "prioritycode";
	public static final String CHECK_WORK_IMPACT = "checkWorkImpact";
	public static final String SOURCE = "source";
	public static final String RFINAME = "rfiname";
	public static final String CHECK_COST_IMPACT = "checkCostImpact";
	public static final String DC_DATA_PID = "dcDataPid";
	public static final String CHECK_SCHEDULE_IMPACT = "checkScheduleImpact";
	public static final String RESPONSE_DUE_DATE = "responseDueDate";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String PROJECT_ID = "projectId";
	public static final String DONE_DATE = "doneDate";
	public static final String STATUS = "status";

}

