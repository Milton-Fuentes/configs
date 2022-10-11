package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmBiditSigninfo.class)
public abstract class CmBiditSigninfo_ {

	public static volatile SingularAttribute<CmBiditSigninfo, BigInteger> clientId;
	public static volatile SingularAttribute<CmBiditSigninfo, BigInteger> signedBy;
	public static volatile SingularAttribute<CmBiditSigninfo, Character> signed;
	public static volatile SingularAttribute<CmBiditSigninfo, CmBiditSignflowdef> signflowId;
	public static volatile SingularAttribute<CmBiditSigninfo, Integer> version;
	public static volatile SingularAttribute<CmBiditSigninfo, BigInteger> signOrder;
	public static volatile SingularAttribute<CmBiditSigninfo, String> signedFromIp;
	public static volatile SingularAttribute<CmBiditSigninfo, String> signedByJobtitle;
	public static volatile SingularAttribute<CmBiditSigninfo, Date> signedDate;
	public static volatile SingularAttribute<CmBiditSigninfo, GlobSystemSimpleCat> typeId;
	public static volatile SingularAttribute<CmBiditSigninfo, BigDecimal> id;
	public static volatile SingularAttribute<CmBiditSigninfo, BigInteger> refId;
	public static volatile SingularAttribute<CmBiditSigninfo, String> signedByName;

	public static final String CLIENT_ID = "clientId";
	public static final String SIGNED_BY = "signedBy";
	public static final String SIGNED = "signed";
	public static final String SIGNFLOW_ID = "signflowId";
	public static final String VERSION = "version";
	public static final String SIGN_ORDER = "signOrder";
	public static final String SIGNED_FROM_IP = "signedFromIp";
	public static final String SIGNED_BY_JOBTITLE = "signedByJobtitle";
	public static final String SIGNED_DATE = "signedDate";
	public static final String TYPE_ID = "typeId";
	public static final String ID = "id";
	public static final String REF_ID = "refId";
	public static final String SIGNED_BY_NAME = "signedByName";

}

