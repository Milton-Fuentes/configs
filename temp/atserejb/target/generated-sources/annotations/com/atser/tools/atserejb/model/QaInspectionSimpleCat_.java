package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaInspectionSimpleCat.class)
public abstract class QaInspectionSimpleCat_ {

	public static volatile SingularAttribute<QaInspectionSimpleCat, String> createdByIp;
	public static volatile SingularAttribute<QaInspectionSimpleCat, BigInteger> clientId;
	public static volatile SingularAttribute<QaInspectionSimpleCat, String> code;
	public static volatile SingularAttribute<QaInspectionSimpleCat, String> lastModBy;
	public static volatile SingularAttribute<QaInspectionSimpleCat, Date> created;
	public static volatile SingularAttribute<QaInspectionSimpleCat, Integer> catOrder;
	public static volatile SingularAttribute<QaInspectionSimpleCat, Character> active;
	public static volatile SingularAttribute<QaInspectionSimpleCat, Integer> version;
	public static volatile ListAttribute<QaInspectionSimpleCat, QaInspection> qaInspectionList;
	public static volatile SingularAttribute<QaInspectionSimpleCat, String> lastModIp;
	public static volatile SingularAttribute<QaInspectionSimpleCat, Character> deleted;
	public static volatile SingularAttribute<QaInspectionSimpleCat, String> createdBy;
	public static volatile SingularAttribute<QaInspectionSimpleCat, String> name;
	public static volatile ListAttribute<QaInspectionSimpleCat, QaInspectionSignflowdef> qaInspectionSignflowdefList;
	public static volatile SingularAttribute<QaInspectionSimpleCat, BigDecimal> id;
	public static volatile SingularAttribute<QaInspectionSimpleCat, String> shortName;
	public static volatile SingularAttribute<QaInspectionSimpleCat, Date> lastMod;
	public static volatile SingularAttribute<QaInspectionSimpleCat, QaInspectionType> inspectionTypeId;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String CODE = "code";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String CAT_ORDER = "catOrder";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String QA_INSPECTION_LIST = "qaInspectionList";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String NAME = "name";
	public static final String QA_INSPECTION_SIGNFLOWDEF_LIST = "qaInspectionSignflowdefList";
	public static final String ID = "id";
	public static final String SHORT_NAME = "shortName";
	public static final String LAST_MOD = "lastMod";
	public static final String INSPECTION_TYPE_ID = "inspectionTypeId";

}

