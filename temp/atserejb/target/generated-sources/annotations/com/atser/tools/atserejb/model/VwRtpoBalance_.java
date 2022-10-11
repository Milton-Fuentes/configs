package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwRtpoBalance.class)
public abstract class VwRtpoBalance_ {

	public static volatile SingularAttribute<VwRtpoBalance, String> phase;
	public static volatile SingularAttribute<VwRtpoBalance, BigInteger> clientId;
	public static volatile SingularAttribute<VwRtpoBalance, String> cstatus;
	public static volatile SingularAttribute<VwRtpoBalance, String> pstatus;
	public static volatile SingularAttribute<VwRtpoBalance, String> pname;
	public static volatile SingularAttribute<VwRtpoBalance, Date> pdate;
	public static volatile SingularAttribute<VwRtpoBalance, String> cname;
	public static volatile SingularAttribute<VwRtpoBalance, Character> active;
	public static volatile SingularAttribute<VwRtpoBalance, String> pnumber;
	public static volatile SingularAttribute<VwRtpoBalance, String> cnumber;
	public static volatile SingularAttribute<VwRtpoBalance, BigDecimal> rowId;
	public static volatile SingularAttribute<VwRtpoBalance, String> purchaseOrderNo;
	public static volatile SingularAttribute<VwRtpoBalance, String> cdescription;
	public static volatile SingularAttribute<VwRtpoBalance, BigDecimal> balance;
	public static volatile SingularAttribute<VwRtpoBalance, String> projectCode;
	public static volatile SingularAttribute<VwRtpoBalance, String> programName;
	public static volatile SingularAttribute<VwRtpoBalance, String> jobNo;
	public static volatile SingularAttribute<VwRtpoBalance, BigInteger> contractId;
	public static volatile SingularAttribute<VwRtpoBalance, Double> camount;
	public static volatile SingularAttribute<VwRtpoBalance, BigInteger> projectId;
	public static volatile SingularAttribute<VwRtpoBalance, BigInteger> programId;

	public static final String PHASE = "phase";
	public static final String CLIENT_ID = "clientId";
	public static final String CSTATUS = "cstatus";
	public static final String PSTATUS = "pstatus";
	public static final String PNAME = "pname";
	public static final String PDATE = "pdate";
	public static final String CNAME = "cname";
	public static final String ACTIVE = "active";
	public static final String PNUMBER = "pnumber";
	public static final String CNUMBER = "cnumber";
	public static final String ROW_ID = "rowId";
	public static final String PURCHASE_ORDER_NO = "purchaseOrderNo";
	public static final String CDESCRIPTION = "cdescription";
	public static final String BALANCE = "balance";
	public static final String PROJECT_CODE = "projectCode";
	public static final String PROGRAM_NAME = "programName";
	public static final String JOB_NO = "jobNo";
	public static final String CONTRACT_ID = "contractId";
	public static final String CAMOUNT = "camount";
	public static final String PROJECT_ID = "projectId";
	public static final String PROGRAM_ID = "programId";

}

