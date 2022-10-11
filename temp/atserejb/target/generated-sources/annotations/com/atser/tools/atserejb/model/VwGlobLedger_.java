package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwGlobLedger.class)
public abstract class VwGlobLedger_ {

	public static volatile SingularAttribute<VwGlobLedger, BigDecimal> income;
	public static volatile SingularAttribute<VwGlobLedger, Date> operationDate;
	public static volatile SingularAttribute<VwGlobLedger, String> lastModBy;
	public static volatile SingularAttribute<VwGlobLedger, String> description;
	public static volatile SingularAttribute<VwGlobLedger, BigDecimal> inspectorId;
	public static volatile SingularAttribute<VwGlobLedger, BigDecimal> miles;
	public static volatile SingularAttribute<VwGlobLedger, String> lastModIp;
	public static volatile SingularAttribute<VwGlobLedger, BigDecimal> balance;
	public static volatile SingularAttribute<VwGlobLedger, BigDecimal> mileageExpense;
	public static volatile SingularAttribute<VwGlobLedger, BigDecimal> id;
	public static volatile SingularAttribute<VwGlobLedger, String> createdByIp;
	public static volatile SingularAttribute<VwGlobLedger, BigDecimal> clientId;
	public static volatile SingularAttribute<VwGlobLedger, String> pname;
	public static volatile SingularAttribute<VwGlobLedger, Date> created;
	public static volatile SingularAttribute<VwGlobLedger, Character> active;
	public static volatile SingularAttribute<VwGlobLedger, String> pnumber;
	public static volatile SingularAttribute<VwGlobLedger, String> inspector;
	public static volatile SingularAttribute<VwGlobLedger, BigDecimal> expense;
	public static volatile SingularAttribute<VwGlobLedger, Integer> version;
	public static volatile SingularAttribute<VwGlobLedger, BigDecimal> folderId;
	public static volatile SingularAttribute<VwGlobLedger, Character> deleted;
	public static volatile SingularAttribute<VwGlobLedger, String> createdBy;
	public static volatile SingularAttribute<VwGlobLedger, String> name;
	public static volatile SingularAttribute<VwGlobLedger, BigDecimal> projectId;
	public static volatile SingularAttribute<VwGlobLedger, Date> lastMod;
	public static volatile SingularAttribute<VwGlobLedger, String> account;
	public static volatile SingularAttribute<VwGlobLedger, BigDecimal> totalExpense;

	public static final String INCOME = "income";
	public static final String OPERATION_DATE = "operationDate";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String DESCRIPTION = "description";
	public static final String INSPECTOR_ID = "inspectorId";
	public static final String MILES = "miles";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String BALANCE = "balance";
	public static final String MILEAGE_EXPENSE = "mileageExpense";
	public static final String ID = "id";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String PNAME = "pname";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String PNUMBER = "pnumber";
	public static final String INSPECTOR = "inspector";
	public static final String EXPENSE = "expense";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String NAME = "name";
	public static final String PROJECT_ID = "projectId";
	public static final String LAST_MOD = "lastMod";
	public static final String ACCOUNT = "account";
	public static final String TOTAL_EXPENSE = "totalExpense";

}

