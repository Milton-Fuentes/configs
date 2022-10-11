package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmProject.class)
public abstract class CmProject_ {

	public static volatile SingularAttribute<CmProject, String> seniorInspector;
	public static volatile SingularAttribute<CmProject, String> assistantDirector;
	public static volatile SingularAttribute<CmProject, String> pName;
	public static volatile SingularAttribute<CmProject, String> fileNo;
	public static volatile SingularAttribute<CmProject, String> contact;
	public static volatile SingularAttribute<CmProject, String> pType;
	public static volatile SingularAttribute<CmProject, String> recievedContracts;
	public static volatile ListAttribute<CmProject, CmContract> cmContractList;
	public static volatile SingularAttribute<CmProject, BigDecimal> id;
	public static volatile SingularAttribute<CmProject, String> fundsSource;
	public static volatile SingularAttribute<CmProject, Date> awardOrdinanceDate;
	public static volatile SingularAttribute<CmProject, String> chiefEngineer;
	public static volatile SingularAttribute<CmProject, String> pNumber;
	public static volatile SingularAttribute<CmProject, String> pStatus;
	public static volatile SingularAttribute<CmProject, String> awardOrdinanceNum;
	public static volatile SingularAttribute<CmProject, String> fundsNo;
	public static volatile SingularAttribute<CmProject, String> field1;
	public static volatile SingularAttribute<CmProject, CmCompany> companyId;
	public static volatile SingularAttribute<CmProject, Date> pDate;
	public static volatile SingularAttribute<CmProject, Date> field7;
	public static volatile SingularAttribute<CmProject, String> field6;
	public static volatile SingularAttribute<CmProject, Date> bidDate;
	public static volatile SingularAttribute<CmProject, Date> field8;
	public static volatile SingularAttribute<CmProject, String> cuicNo;
	public static volatile SingularAttribute<CmProject, String> field3;
	public static volatile SingularAttribute<CmProject, String> field2;
	public static volatile SingularAttribute<CmProject, String> councilDist;
	public static volatile SingularAttribute<CmProject, String> field5;
	public static volatile SingularAttribute<CmProject, String> field4;

	public static final String SENIOR_INSPECTOR = "seniorInspector";
	public static final String ASSISTANT_DIRECTOR = "assistantDirector";
	public static final String P_NAME = "pName";
	public static final String FILE_NO = "fileNo";
	public static final String CONTACT = "contact";
	public static final String P_TYPE = "pType";
	public static final String RECIEVED_CONTRACTS = "recievedContracts";
	public static final String CM_CONTRACT_LIST = "cmContractList";
	public static final String ID = "id";
	public static final String FUNDS_SOURCE = "fundsSource";
	public static final String AWARD_ORDINANCE_DATE = "awardOrdinanceDate";
	public static final String CHIEF_ENGINEER = "chiefEngineer";
	public static final String P_NUMBER = "pNumber";
	public static final String P_STATUS = "pStatus";
	public static final String AWARD_ORDINANCE_NUM = "awardOrdinanceNum";
	public static final String FUNDS_NO = "fundsNo";
	public static final String FIELD1 = "field1";
	public static final String COMPANY_ID = "companyId";
	public static final String P_DATE = "pDate";
	public static final String FIELD7 = "field7";
	public static final String FIELD6 = "field6";
	public static final String BID_DATE = "bidDate";
	public static final String FIELD8 = "field8";
	public static final String CUIC_NO = "cuicNo";
	public static final String FIELD3 = "field3";
	public static final String FIELD2 = "field2";
	public static final String COUNCIL_DIST = "councilDist";
	public static final String FIELD5 = "field5";
	public static final String FIELD4 = "field4";

}

