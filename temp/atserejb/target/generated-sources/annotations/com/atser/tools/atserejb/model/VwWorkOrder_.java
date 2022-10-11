package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwWorkOrder.class)
public abstract class VwWorkOrder_ {

	public static volatile SingularAttribute<VwWorkOrder, Integer> hours;
	public static volatile SingularAttribute<VwWorkOrder, Integer> infoId;
	public static volatile SingularAttribute<VwWorkOrder, BigInteger> clientId;
	public static volatile SingularAttribute<VwWorkOrder, GlobWorkorder> woId;
	public static volatile SingularAttribute<VwWorkOrder, Date> serviceDate;
	public static volatile SingularAttribute<VwWorkOrder, String> assignment;
	public static volatile SingularAttribute<VwWorkOrder, String> techFullName;
	public static volatile SingularAttribute<VwWorkOrder, String> submreport;
	public static volatile SingularAttribute<VwWorkOrder, String> specInstr;
	public static volatile SingularAttribute<VwWorkOrder, BigInteger> regionId;
	public static volatile SingularAttribute<VwWorkOrder, Integer> techrefid;
	public static volatile SingularAttribute<VwWorkOrder, String> serviceList;
	public static volatile SingularAttribute<VwWorkOrder, String> cancelled;
	public static volatile SingularAttribute<VwWorkOrder, String> timeSite;
	public static volatile SingularAttribute<VwWorkOrder, BigDecimal> id;
	public static volatile SingularAttribute<VwWorkOrder, Integer> decisionflag;
	public static volatile SingularAttribute<VwWorkOrder, String> projectName;
	public static volatile SingularAttribute<VwWorkOrder, BigInteger> projectId;
	public static volatile SingularAttribute<VwWorkOrder, String> paperworkReceived;

	public static final String HOURS = "hours";
	public static final String INFO_ID = "infoId";
	public static final String CLIENT_ID = "clientId";
	public static final String WO_ID = "woId";
	public static final String SERVICE_DATE = "serviceDate";
	public static final String ASSIGNMENT = "assignment";
	public static final String TECH_FULL_NAME = "techFullName";
	public static final String SUBMREPORT = "submreport";
	public static final String SPEC_INSTR = "specInstr";
	public static final String REGION_ID = "regionId";
	public static final String TECHREFID = "techrefid";
	public static final String SERVICE_LIST = "serviceList";
	public static final String CANCELLED = "cancelled";
	public static final String TIME_SITE = "timeSite";
	public static final String ID = "id";
	public static final String DECISIONFLAG = "decisionflag";
	public static final String PROJECT_NAME = "projectName";
	public static final String PROJECT_ID = "projectId";
	public static final String PAPERWORK_RECEIVED = "paperworkReceived";

}

