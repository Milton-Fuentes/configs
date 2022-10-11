package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobContractorContract.class)
public abstract class GlobContractorContract_ {

	public static volatile SingularAttribute<GlobContractorContract, BigInteger> functionId;
	public static volatile SingularAttribute<GlobContractorContract, Character> contractorType;
	public static volatile SingularAttribute<GlobContractorContract, GlobContractor> contractorId;
	public static volatile SingularAttribute<GlobContractorContract, GlobLabs> labId;
	public static volatile SingularAttribute<GlobContractorContract, BigInteger> contractId;
	public static volatile SingularAttribute<GlobContractorContract, BigInteger> disciplineId;
	public static volatile ListAttribute<GlobContractorContract, InReport> inReportList;
	public static volatile SingularAttribute<GlobContractorContract, BigDecimal> id;
	public static volatile SingularAttribute<GlobContractorContract, GlobProject> projectId;

	public static final String FUNCTION_ID = "functionId";
	public static final String CONTRACTOR_TYPE = "contractorType";
	public static final String CONTRACTOR_ID = "contractorId";
	public static final String LAB_ID = "labId";
	public static final String CONTRACT_ID = "contractId";
	public static final String DISCIPLINE_ID = "disciplineId";
	public static final String IN_REPORT_LIST = "inReportList";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";

}

