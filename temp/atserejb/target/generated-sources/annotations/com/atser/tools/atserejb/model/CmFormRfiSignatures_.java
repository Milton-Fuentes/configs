package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmFormRfiSignatures.class)
public abstract class CmFormRfiSignatures_ {

	public static volatile SingularAttribute<CmFormRfiSignatures, Date> techSigDate;
	public static volatile SingularAttribute<CmFormRfiSignatures, Date> contractorSigDate;
	public static volatile SingularAttribute<CmFormRfiSignatures, BigInteger> costSigId;
	public static volatile SingularAttribute<CmFormRfiSignatures, BigInteger> engSigId;
	public static volatile SingularAttribute<CmFormRfiSignatures, BigInteger> rfiId;
	public static volatile SingularAttribute<CmFormRfiSignatures, BigInteger> techSigId;
	public static volatile SingularAttribute<CmFormRfiSignatures, BigInteger> contractorSigId;
	public static volatile SingularAttribute<CmFormRfiSignatures, Date> imageTimestamp;
	public static volatile SingularAttribute<CmFormRfiSignatures, BigInteger> resengConsultSigId;
	public static volatile SingularAttribute<CmFormRfiSignatures, Date> engSigDate;
	public static volatile SingularAttribute<CmFormRfiSignatures, BigDecimal> id;
	public static volatile SingularAttribute<CmFormRfiSignatures, Date> costSigDate;
	public static volatile SingularAttribute<CmFormRfiSignatures, Date> resengConsultSigDate;

	public static final String TECH_SIG_DATE = "techSigDate";
	public static final String CONTRACTOR_SIG_DATE = "contractorSigDate";
	public static final String COST_SIG_ID = "costSigId";
	public static final String ENG_SIG_ID = "engSigId";
	public static final String RFI_ID = "rfiId";
	public static final String TECH_SIG_ID = "techSigId";
	public static final String CONTRACTOR_SIG_ID = "contractorSigId";
	public static final String IMAGE_TIMESTAMP = "imageTimestamp";
	public static final String RESENG_CONSULT_SIG_ID = "resengConsultSigId";
	public static final String ENG_SIG_DATE = "engSigDate";
	public static final String ID = "id";
	public static final String COST_SIG_DATE = "costSigDate";
	public static final String RESENG_CONSULT_SIG_DATE = "resengConsultSigDate";

}

