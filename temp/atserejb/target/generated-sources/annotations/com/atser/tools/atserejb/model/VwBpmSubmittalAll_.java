package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwBpmSubmittalAll.class)
public abstract class VwBpmSubmittalAll_ {

	public static volatile SingularAttribute<VwBpmSubmittalAll, BigDecimal> clientId;
	public static volatile SingularAttribute<VwBpmSubmittalAll, Date> created;
	public static volatile SingularAttribute<VwBpmSubmittalAll, String> finaldisposition;
	public static volatile SingularAttribute<VwBpmSubmittalAll, String> name;
	public static volatile SingularAttribute<VwBpmSubmittalAll, BigDecimal> persistenceid;
	public static volatile SingularAttribute<VwBpmSubmittalAll, String> subnumber;
	public static volatile SingularAttribute<VwBpmSubmittalAll, String> source;
	public static volatile SingularAttribute<VwBpmSubmittalAll, BigDecimal> projectId;
	public static volatile SingularAttribute<VwBpmSubmittalAll, Date> doneDate;
	public static volatile SingularAttribute<VwBpmSubmittalAll, String> status;
	public static volatile SingularAttribute<VwBpmSubmittalAll, String> requestedDueDate;
	public static volatile SingularAttribute<VwBpmSubmittalAll, Bpmsubmittalmetadata> dcDataPid;

	public static final String CLIENT_ID = "clientId";
	public static final String CREATED = "created";
	public static final String FINALDISPOSITION = "finaldisposition";
	public static final String NAME = "name";
	public static final String PERSISTENCEID = "persistenceid";
	public static final String SUBNUMBER = "subnumber";
	public static final String SOURCE = "source";
	public static final String PROJECT_ID = "projectId";
	public static final String DONE_DATE = "doneDate";
	public static final String STATUS = "status";
	public static final String REQUESTED_DUE_DATE = "requestedDueDate";
	public static final String DC_DATA_PID = "dcDataPid";

}

