package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwQmSummaryInvoice.class)
public abstract class VwQmSummaryInvoice_ {

	public static volatile SingularAttribute<VwQmSummaryInvoice, BigInteger> clientId;
	public static volatile SingularAttribute<VwQmSummaryInvoice, String> projectClientNo;
	public static volatile SingularAttribute<VwQmSummaryInvoice, String> projectClientName;
	public static volatile SingularAttribute<VwQmSummaryInvoice, String> projectNumber;
	public static volatile SingularAttribute<VwQmSummaryInvoice, BigDecimal> invoiceAmount;
	public static volatile SingularAttribute<VwQmSummaryInvoice, Date> invoiceDate;
	public static volatile SingularAttribute<VwQmSummaryInvoice, BigDecimal> totalToDateAmount;
	public static volatile SingularAttribute<VwQmSummaryInvoice, String> officeLocation;
	public static volatile SingularAttribute<VwQmSummaryInvoice, BigDecimal> totalBalanceAmount;
	public static volatile SingularAttribute<VwQmSummaryInvoice, BigDecimal> id;
	public static volatile SingularAttribute<VwQmSummaryInvoice, String> projectName;
	public static volatile SingularAttribute<VwQmSummaryInvoice, String> invoiceNo;
	public static volatile SingularAttribute<VwQmSummaryInvoice, BigInteger> projectId;
	public static volatile SingularAttribute<VwQmSummaryInvoice, String> status;
	public static volatile SingularAttribute<VwQmSummaryInvoice, String> createDate;

	public static final String CLIENT_ID = "clientId";
	public static final String PROJECT_CLIENT_NO = "projectClientNo";
	public static final String PROJECT_CLIENT_NAME = "projectClientName";
	public static final String PROJECT_NUMBER = "projectNumber";
	public static final String INVOICE_AMOUNT = "invoiceAmount";
	public static final String INVOICE_DATE = "invoiceDate";
	public static final String TOTAL_TO_DATE_AMOUNT = "totalToDateAmount";
	public static final String OFFICE_LOCATION = "officeLocation";
	public static final String TOTAL_BALANCE_AMOUNT = "totalBalanceAmount";
	public static final String ID = "id";
	public static final String PROJECT_NAME = "projectName";
	public static final String INVOICE_NO = "invoiceNo";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";
	public static final String CREATE_DATE = "createDate";

}

