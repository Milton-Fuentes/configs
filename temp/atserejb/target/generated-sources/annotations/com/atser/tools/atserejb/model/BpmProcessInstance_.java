package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BpmProcessInstance.class)
public abstract class BpmProcessInstance_ {

	public static volatile SingularAttribute<BpmProcessInstance, String> createdByIp;
	public static volatile SingularAttribute<BpmProcessInstance, BigDecimal> clientId;
	public static volatile SingularAttribute<BpmProcessInstance, String> lastModBy;
	public static volatile SingularAttribute<BpmProcessInstance, Date> created;
	public static volatile SingularAttribute<BpmProcessInstance, String> active;
	public static volatile SingularAttribute<BpmProcessInstance, String> lastModByIp;
	public static volatile SingularAttribute<BpmProcessInstance, String> deleted;
	public static volatile SingularAttribute<BpmProcessInstance, BpmProcess> processId;
	public static volatile SingularAttribute<BpmProcessInstance, String> createdBy;
	public static volatile SingularAttribute<BpmProcessInstance, BigDecimal> id;
	public static volatile SingularAttribute<BpmProcessInstance, BigDecimal> refId;
	public static volatile SingularAttribute<BpmProcessInstance, String> state;
	public static volatile SingularAttribute<BpmProcessInstance, BigDecimal> projectId;
	public static volatile SingularAttribute<BpmProcessInstance, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String LAST_MOD_BY_IP = "lastModByIp";
	public static final String DELETED = "deleted";
	public static final String PROCESS_ID = "processId";
	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String REF_ID = "refId";
	public static final String STATE = "state";
	public static final String PROJECT_ID = "projectId";
	public static final String LAST_MOD = "lastMod";

}

