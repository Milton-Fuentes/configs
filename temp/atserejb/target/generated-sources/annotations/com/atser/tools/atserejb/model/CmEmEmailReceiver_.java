package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmEmEmailReceiver.class)
public abstract class CmEmEmailReceiver_ {

	public static volatile SingularAttribute<CmEmEmailReceiver, BigInteger> toGroupid;
	public static volatile SingularAttribute<CmEmEmailReceiver, BigInteger> emailId;
	public static volatile SingularAttribute<CmEmEmailReceiver, BigDecimal> id;
	public static volatile SingularAttribute<CmEmEmailReceiver, BigInteger> ccUserid;
	public static volatile SingularAttribute<CmEmEmailReceiver, BigInteger> ccGroupid;
	public static volatile SingularAttribute<CmEmEmailReceiver, BigInteger> toUserid;

	public static final String TO_GROUPID = "toGroupid";
	public static final String EMAIL_ID = "emailId";
	public static final String ID = "id";
	public static final String CC_USERID = "ccUserid";
	public static final String CC_GROUPID = "ccGroupid";
	public static final String TO_USERID = "toUserid";

}

