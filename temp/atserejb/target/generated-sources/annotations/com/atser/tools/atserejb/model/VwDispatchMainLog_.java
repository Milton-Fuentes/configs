package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwDispatchMainLog.class)
public abstract class VwDispatchMainLog_ {

	public static volatile SingularAttribute<VwDispatchMainLog, BigInteger> infoId;
	public static volatile SingularAttribute<VwDispatchMainLog, String> reqLocation;
	public static volatile SingularAttribute<VwDispatchMainLog, Date> serviceDate;
	public static volatile SingularAttribute<VwDispatchMainLog, BigDecimal> invoicedAmount;
	public static volatile SingularAttribute<VwDispatchMainLog, BigDecimal> totalHours;
	public static volatile SingularAttribute<VwDispatchMainLog, String> description;
	public static volatile SingularAttribute<VwDispatchMainLog, String> cancelledWo;
	public static volatile SingularAttribute<VwDispatchMainLog, String> specInstr;
	public static volatile SingularAttribute<VwDispatchMainLog, String> cancelledCall;
	public static volatile SingularAttribute<VwDispatchMainLog, String> woNo;
	public static volatile SingularAttribute<VwDispatchMainLog, Character> creditHold;
	public static volatile SingularAttribute<VwDispatchMainLog, BigInteger> techRefId;
	public static volatile SingularAttribute<VwDispatchMainLog, String> emailReason;
	public static volatile SingularAttribute<VwDispatchMainLog, String> officeLocation;
	public static volatile SingularAttribute<VwDispatchMainLog, BigDecimal> rate;
	public static volatile SingularAttribute<VwDispatchMainLog, String> timeSite;
	public static volatile SingularAttribute<VwDispatchMainLog, String> certBillingCodeDesc;
	public static volatile SingularAttribute<VwDispatchMainLog, BigDecimal> id;
	public static volatile SingularAttribute<VwDispatchMainLog, String> requestedDate;
	public static volatile SingularAttribute<VwDispatchMainLog, BigInteger> certBillingCodeId;
	public static volatile SingularAttribute<VwDispatchMainLog, BigDecimal> unitPrice;
	public static volatile SingularAttribute<VwDispatchMainLog, BigDecimal> hours;
	public static volatile SingularAttribute<VwDispatchMainLog, BigInteger> clientId;
	public static volatile SingularAttribute<VwDispatchMainLog, BigInteger> woId;
	public static volatile SingularAttribute<VwDispatchMainLog, String> projectClientName;
	public static volatile SingularAttribute<VwDispatchMainLog, String> technician;
	public static volatile SingularAttribute<VwDispatchMainLog, String> dept;
	public static volatile SingularAttribute<VwDispatchMainLog, String> version;
	public static volatile SingularAttribute<VwDispatchMainLog, String> labFunction;
	public static volatile SingularAttribute<VwDispatchMainLog, Long> decisionFlag;
	public static volatile SingularAttribute<VwDispatchMainLog, String> assigment;
	public static volatile SingularAttribute<VwDispatchMainLog, String> requestedBy;
	public static volatile SingularAttribute<VwDispatchMainLog, String> emailStatus;
	public static volatile SingularAttribute<VwDispatchMainLog, String> servicesRequested;
	public static volatile SingularAttribute<VwDispatchMainLog, BigInteger> regionId;
	public static volatile SingularAttribute<VwDispatchMainLog, String> requestedTime;
	public static volatile SingularAttribute<VwDispatchMainLog, String> name;
	public static volatile SingularAttribute<VwDispatchMainLog, BigDecimal> contractAmount;
	public static volatile SingularAttribute<VwDispatchMainLog, BigDecimal> grossMargin;
	public static volatile SingularAttribute<VwDispatchMainLog, BigInteger> projectClientId;
	public static volatile SingularAttribute<VwDispatchMainLog, BigInteger> projectId;
	public static volatile SingularAttribute<VwDispatchMainLog, Character> paperworkReceived;

	public static final String INFO_ID = "infoId";
	public static final String REQ_LOCATION = "reqLocation";
	public static final String SERVICE_DATE = "serviceDate";
	public static final String INVOICED_AMOUNT = "invoicedAmount";
	public static final String TOTAL_HOURS = "totalHours";
	public static final String DESCRIPTION = "description";
	public static final String CANCELLED_WO = "cancelledWo";
	public static final String SPEC_INSTR = "specInstr";
	public static final String CANCELLED_CALL = "cancelledCall";
	public static final String WO_NO = "woNo";
	public static final String CREDIT_HOLD = "creditHold";
	public static final String TECH_REF_ID = "techRefId";
	public static final String EMAIL_REASON = "emailReason";
	public static final String OFFICE_LOCATION = "officeLocation";
	public static final String RATE = "rate";
	public static final String TIME_SITE = "timeSite";
	public static final String CERT_BILLING_CODE_DESC = "certBillingCodeDesc";
	public static final String ID = "id";
	public static final String REQUESTED_DATE = "requestedDate";
	public static final String CERT_BILLING_CODE_ID = "certBillingCodeId";
	public static final String UNIT_PRICE = "unitPrice";
	public static final String HOURS = "hours";
	public static final String CLIENT_ID = "clientId";
	public static final String WO_ID = "woId";
	public static final String PROJECT_CLIENT_NAME = "projectClientName";
	public static final String TECHNICIAN = "technician";
	public static final String DEPT = "dept";
	public static final String VERSION = "version";
	public static final String LAB_FUNCTION = "labFunction";
	public static final String DECISION_FLAG = "decisionFlag";
	public static final String ASSIGMENT = "assigment";
	public static final String REQUESTED_BY = "requestedBy";
	public static final String EMAIL_STATUS = "emailStatus";
	public static final String SERVICES_REQUESTED = "servicesRequested";
	public static final String REGION_ID = "regionId";
	public static final String REQUESTED_TIME = "requestedTime";
	public static final String NAME = "name";
	public static final String CONTRACT_AMOUNT = "contractAmount";
	public static final String GROSS_MARGIN = "grossMargin";
	public static final String PROJECT_CLIENT_ID = "projectClientId";
	public static final String PROJECT_ID = "projectId";
	public static final String PAPERWORK_RECEIVED = "paperworkReceived";

}

