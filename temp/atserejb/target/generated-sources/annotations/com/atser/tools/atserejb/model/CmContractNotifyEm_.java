package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmContractNotifyEm.class)
public abstract class CmContractNotifyEm_ {

	public static volatile SingularAttribute<CmContractNotifyEm, Date> noticeSendDate;
	public static volatile SingularAttribute<CmContractNotifyEm, String> emailList;
	public static volatile SingularAttribute<CmContractNotifyEm, BigInteger> groupId;
	public static volatile SingularAttribute<CmContractNotifyEm, BigInteger> formDataId;
	public static volatile SingularAttribute<CmContractNotifyEm, BigInteger> personId;
	public static volatile SingularAttribute<CmContractNotifyEm, BigDecimal> id;
	public static volatile SingularAttribute<CmContractNotifyEm, String> emailNote;

	public static final String NOTICE_SEND_DATE = "noticeSendDate";
	public static final String EMAIL_LIST = "emailList";
	public static final String GROUP_ID = "groupId";
	public static final String FORM_DATA_ID = "formDataId";
	public static final String PERSON_ID = "personId";
	public static final String ID = "id";
	public static final String EMAIL_NOTE = "emailNote";

}

