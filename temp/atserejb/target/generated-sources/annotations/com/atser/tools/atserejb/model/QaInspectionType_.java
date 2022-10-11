package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaInspectionType.class)
public abstract class QaInspectionType_ {

	public static volatile SingularAttribute<QaInspectionType, String> createdByIp;
	public static volatile SingularAttribute<QaInspectionType, BigInteger> clientId;
	public static volatile SingularAttribute<QaInspectionType, String> lastModBy;
	public static volatile SingularAttribute<QaInspectionType, Integer> typeOrder;
	public static volatile SingularAttribute<QaInspectionType, Date> created;
	public static volatile SingularAttribute<QaInspectionType, Character> active;
	public static volatile SingularAttribute<QaInspectionType, Integer> version;
	public static volatile ListAttribute<QaInspectionType, QaInspection> qaInspectionList;
	public static volatile SingularAttribute<QaInspectionType, String> lastModIp;
	public static volatile SingularAttribute<QaInspectionType, Character> deleted;
	public static volatile SingularAttribute<QaInspectionType, String> createdBy;
	public static volatile SingularAttribute<QaInspectionType, String> name;
	public static volatile SingularAttribute<QaInspectionType, String> typeIcon;
	public static volatile ListAttribute<QaInspectionType, QaInspectionSignflowdef> qaInspectionSignflowdefList;
	public static volatile ListAttribute<QaInspectionType, QaInspectionSimpleCat> qaInspectionSimpleCatList;
	public static volatile SingularAttribute<QaInspectionType, BigDecimal> id;
	public static volatile SingularAttribute<QaInspectionType, String> shortName;
	public static volatile SingularAttribute<QaInspectionType, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String TYPE_ORDER = "typeOrder";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String QA_INSPECTION_LIST = "qaInspectionList";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String NAME = "name";
	public static final String TYPE_ICON = "typeIcon";
	public static final String QA_INSPECTION_SIGNFLOWDEF_LIST = "qaInspectionSignflowdefList";
	public static final String QA_INSPECTION_SIMPLE_CAT_LIST = "qaInspectionSimpleCatList";
	public static final String ID = "id";
	public static final String SHORT_NAME = "shortName";
	public static final String LAST_MOD = "lastMod";

}

