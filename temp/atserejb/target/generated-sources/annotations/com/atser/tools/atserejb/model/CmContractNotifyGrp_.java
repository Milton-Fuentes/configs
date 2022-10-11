package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmContractNotifyGrp.class)
public abstract class CmContractNotifyGrp_ {

	public static volatile SingularAttribute<CmContractNotifyGrp, String> groupName;
	public static volatile SingularAttribute<CmContractNotifyGrp, String> groupType;
	public static volatile SingularAttribute<CmContractNotifyGrp, String> emailContent;
	public static volatile SingularAttribute<CmContractNotifyGrp, BigInteger> contractId;
	public static volatile SingularAttribute<CmContractNotifyGrp, String> description;
	public static volatile SingularAttribute<CmContractNotifyGrp, BigDecimal> id;
	public static volatile SingularAttribute<CmContractNotifyGrp, String> emailSubject;

	public static final String GROUP_NAME = "groupName";
	public static final String GROUP_TYPE = "groupType";
	public static final String EMAIL_CONTENT = "emailContent";
	public static final String CONTRACT_ID = "contractId";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String EMAIL_SUBJECT = "emailSubject";

}

