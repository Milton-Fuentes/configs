package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaInspectionSigninfo.class)
public abstract class QaInspectionSigninfo_ {

	public static volatile SingularAttribute<QaInspectionSigninfo, QaInspection> inspectionId;
	public static volatile SingularAttribute<QaInspectionSigninfo, BigInteger> clientId;
	public static volatile SingularAttribute<QaInspectionSigninfo, BigInteger> signedBy;
	public static volatile SingularAttribute<QaInspectionSigninfo, String> signedByJobtitle;
	public static volatile SingularAttribute<QaInspectionSigninfo, Character> signed;
	public static volatile SingularAttribute<QaInspectionSigninfo, Date> signedDate;
	public static volatile SingularAttribute<QaInspectionSigninfo, BigDecimal> id;
	public static volatile SingularAttribute<QaInspectionSigninfo, String> signedByName;
	public static volatile SingularAttribute<QaInspectionSigninfo, QaInspectionSignflowdef> signflowId;
	public static volatile SingularAttribute<QaInspectionSigninfo, Integer> version;
	public static volatile SingularAttribute<QaInspectionSigninfo, String> signedFromIp;
	public static volatile SingularAttribute<QaInspectionSigninfo, Integer> signOrder;

	public static final String INSPECTION_ID = "inspectionId";
	public static final String CLIENT_ID = "clientId";
	public static final String SIGNED_BY = "signedBy";
	public static final String SIGNED_BY_JOBTITLE = "signedByJobtitle";
	public static final String SIGNED = "signed";
	public static final String SIGNED_DATE = "signedDate";
	public static final String ID = "id";
	public static final String SIGNED_BY_NAME = "signedByName";
	public static final String SIGNFLOW_ID = "signflowId";
	public static final String VERSION = "version";
	public static final String SIGNED_FROM_IP = "signedFromIp";
	public static final String SIGN_ORDER = "signOrder";

}

