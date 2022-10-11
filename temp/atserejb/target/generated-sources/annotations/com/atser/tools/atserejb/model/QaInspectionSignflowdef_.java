package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaInspectionSignflowdef.class)
public abstract class QaInspectionSignflowdef_ {

	public static volatile SingularAttribute<QaInspectionSignflowdef, String> createdByIp;
	public static volatile SingularAttribute<QaInspectionSignflowdef, QaInspectionSimpleCat> simplecatId;
	public static volatile SingularAttribute<QaInspectionSignflowdef, BigInteger> clientId;
	public static volatile SingularAttribute<QaInspectionSignflowdef, String> signRuleName;
	public static volatile SingularAttribute<QaInspectionSignflowdef, String> lastModBy;
	public static volatile SingularAttribute<QaInspectionSignflowdef, Date> created;
	public static volatile SingularAttribute<QaInspectionSignflowdef, Character> active;
	public static volatile SingularAttribute<QaInspectionSignflowdef, Integer> version;
	public static volatile SingularAttribute<QaInspectionSignflowdef, Integer> signOrder;
	public static volatile SingularAttribute<QaInspectionSignflowdef, String> lastModIp;
	public static volatile SingularAttribute<QaInspectionSignflowdef, Character> deleted;
	public static volatile SingularAttribute<QaInspectionSignflowdef, String> createdBy;
	public static volatile SingularAttribute<QaInspectionSignflowdef, BigDecimal> id;
	public static volatile SingularAttribute<QaInspectionSignflowdef, Date> lastMod;
	public static volatile SingularAttribute<QaInspectionSignflowdef, QaInspectionType> inspectionTypeId;
	public static volatile ListAttribute<QaInspectionSignflowdef, QaInspectionSigninfo> qaInspectionSigninfoList;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String SIMPLECAT_ID = "simplecatId";
	public static final String CLIENT_ID = "clientId";
	public static final String SIGN_RULE_NAME = "signRuleName";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String SIGN_ORDER = "signOrder";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String INSPECTION_TYPE_ID = "inspectionTypeId";
	public static final String QA_INSPECTION_SIGNINFO_LIST = "qaInspectionSigninfoList";

}

