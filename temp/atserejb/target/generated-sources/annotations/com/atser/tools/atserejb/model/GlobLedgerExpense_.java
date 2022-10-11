package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobLedgerExpense.class)
public abstract class GlobLedgerExpense_ {

	public static volatile SingularAttribute<GlobLedgerExpense, BigDecimal> amount;
	public static volatile SingularAttribute<GlobLedgerExpense, String> createdByIp;
	public static volatile SingularAttribute<GlobLedgerExpense, String> lastModBy;
	public static volatile SingularAttribute<GlobLedgerExpense, Date> created;
	public static volatile SingularAttribute<GlobLedgerExpense, String> description;
	public static volatile SingularAttribute<GlobLedgerExpense, Character> active;
	public static volatile SingularAttribute<GlobLedgerExpense, BigDecimal> expense;
	public static volatile SingularAttribute<GlobLedgerExpense, Integer> version;
	public static volatile SingularAttribute<GlobLedgerExpense, BigDecimal> miles;
	public static volatile SingularAttribute<GlobLedgerExpense, String> lastModIp;
	public static volatile SingularAttribute<GlobLedgerExpense, Character> deleted;
	public static volatile SingularAttribute<GlobLedgerExpense, String> createdBy;
	public static volatile SingularAttribute<GlobLedgerExpense, BigDecimal> operationId;
	public static volatile SingularAttribute<GlobLedgerExpense, BigDecimal> id;
	public static volatile SingularAttribute<GlobLedgerExpense, Date> lastMod;

	public static final String AMOUNT = "amount";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String EXPENSE = "expense";
	public static final String VERSION = "version";
	public static final String MILES = "miles";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String OPERATION_ID = "operationId";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

