package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobLedgerIncome.class)
public abstract class GlobLedgerIncome_ {

	public static volatile SingularAttribute<GlobLedgerIncome, BigDecimal> income;
	public static volatile SingularAttribute<GlobLedgerIncome, String> createdByIp;
	public static volatile SingularAttribute<GlobLedgerIncome, String> lastModIp;
	public static volatile SingularAttribute<GlobLedgerIncome, String> lastModBy;
	public static volatile SingularAttribute<GlobLedgerIncome, Character> deleted;
	public static volatile SingularAttribute<GlobLedgerIncome, String> createdBy;
	public static volatile SingularAttribute<GlobLedgerIncome, Date> created;
	public static volatile SingularAttribute<GlobLedgerIncome, String> description;
	public static volatile SingularAttribute<GlobLedgerIncome, Character> active;
	public static volatile SingularAttribute<GlobLedgerIncome, BigDecimal> id;
	public static volatile SingularAttribute<GlobLedgerIncome, Date> lastMod;
	public static volatile SingularAttribute<GlobLedgerIncome, Integer> version;

	public static final String INCOME = "income";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED = "created";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String VERSION = "version";

}

