package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmLabInvoice.class)
public abstract class CmLabInvoice_ {

	public static volatile SingularAttribute<CmLabInvoice, String> percentInv;
	public static volatile SingularAttribute<CmLabInvoice, String> comments;
	public static volatile SingularAttribute<CmLabInvoice, String> lastModBy;
	public static volatile SingularAttribute<CmLabInvoice, String> labpoNo;
	public static volatile SingularAttribute<CmLabInvoice, String> version;
	public static volatile SingularAttribute<CmLabInvoice, String> createByIp;
	public static volatile SingularAttribute<CmLabInvoice, Date> lastinvDate;
	public static volatile SingularAttribute<CmLabInvoice, String> createBy;
	public static volatile SingularAttribute<CmLabInvoice, Double> totalinvTodate;
	public static volatile SingularAttribute<CmLabInvoice, String> lastModIp;
	public static volatile SingularAttribute<CmLabInvoice, BigInteger> contractId;
	public static volatile SingularAttribute<CmLabInvoice, BigDecimal> id;
	public static volatile SingularAttribute<CmLabInvoice, Double> labpoAmount;
	public static volatile SingularAttribute<CmLabInvoice, String> lastMod;

	public static final String PERCENT_INV = "percentInv";
	public static final String COMMENTS = "comments";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String LABPO_NO = "labpoNo";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String LASTINV_DATE = "lastinvDate";
	public static final String CREATE_BY = "createBy";
	public static final String TOTALINV_TODATE = "totalinvTodate";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String CONTRACT_ID = "contractId";
	public static final String ID = "id";
	public static final String LABPO_AMOUNT = "labpoAmount";
	public static final String LAST_MOD = "lastMod";

}

