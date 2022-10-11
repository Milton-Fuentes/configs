package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmFormSubmSignatures.class)
public abstract class CmFormSubmSignatures_ {

	public static volatile SingularAttribute<CmFormSubmSignatures, Date> imageTimestamp;
	public static volatile SingularAttribute<CmFormSubmSignatures, Date> contractorSigDate;
	public static volatile SingularAttribute<CmFormSubmSignatures, BigInteger> submId;
	public static volatile SingularAttribute<CmFormSubmSignatures, BigInteger> resengConsultSigId;
	public static volatile SingularAttribute<CmFormSubmSignatures, BigInteger> engSigId;
	public static volatile SingularAttribute<CmFormSubmSignatures, Date> engSigDate;
	public static volatile SingularAttribute<CmFormSubmSignatures, BigDecimal> id;
	public static volatile SingularAttribute<CmFormSubmSignatures, BigInteger> contractorSigId;
	public static volatile SingularAttribute<CmFormSubmSignatures, Date> resengConsultSigDate;

	public static final String IMAGE_TIMESTAMP = "imageTimestamp";
	public static final String CONTRACTOR_SIG_DATE = "contractorSigDate";
	public static final String SUBM_ID = "submId";
	public static final String RESENG_CONSULT_SIG_ID = "resengConsultSigId";
	public static final String ENG_SIG_ID = "engSigId";
	public static final String ENG_SIG_DATE = "engSigDate";
	public static final String ID = "id";
	public static final String CONTRACTOR_SIG_ID = "contractorSigId";
	public static final String RESENG_CONSULT_SIG_DATE = "resengConsultSigDate";

}

