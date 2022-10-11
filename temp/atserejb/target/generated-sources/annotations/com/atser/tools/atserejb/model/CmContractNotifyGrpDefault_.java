package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmContractNotifyGrpDefault.class)
public abstract class CmContractNotifyGrpDefault_ {

	public static volatile SingularAttribute<CmContractNotifyGrpDefault, String> groupName;
	public static volatile SingularAttribute<CmContractNotifyGrpDefault, String> groupType;
	public static volatile SingularAttribute<CmContractNotifyGrpDefault, String> emailContent;
	public static volatile SingularAttribute<CmContractNotifyGrpDefault, String> description;
	public static volatile SingularAttribute<CmContractNotifyGrpDefault, BigDecimal> id;
	public static volatile SingularAttribute<CmContractNotifyGrpDefault, String> emailSubject;

	public static final String GROUP_NAME = "groupName";
	public static final String GROUP_TYPE = "groupType";
	public static final String EMAIL_CONTENT = "emailContent";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String EMAIL_SUBJECT = "emailSubject";

}

