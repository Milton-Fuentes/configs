package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaInspectionNotuitem.class)
public abstract class QaInspectionNotuitem_ {

	public static volatile SingularAttribute<QaInspectionNotuitem, String> reason;
	public static volatile SingularAttribute<QaInspectionNotuitem, String> createdByIp;
	public static volatile SingularAttribute<QaInspectionNotuitem, String> lastModBy;
	public static volatile SingularAttribute<QaInspectionNotuitem, Date> created;
	public static volatile SingularAttribute<QaInspectionNotuitem, Character> active;
	public static volatile SingularAttribute<QaInspectionNotuitem, Integer> version;
	public static volatile SingularAttribute<QaInspectionNotuitem, QaInspection> inspectionId;
	public static volatile SingularAttribute<QaInspectionNotuitem, String> lastModIp;
	public static volatile SingularAttribute<QaInspectionNotuitem, Character> deleted;
	public static volatile SingularAttribute<QaInspectionNotuitem, String> createdBy;
	public static volatile SingularAttribute<QaInspectionNotuitem, VwTestPlanItem> biditemId;
	public static volatile SingularAttribute<QaInspectionNotuitem, VwTestPlanItem> wbsitemId;
	public static volatile SingularAttribute<QaInspectionNotuitem, BigDecimal> id;
	public static volatile SingularAttribute<QaInspectionNotuitem, Date> lastMod;

	public static final String REASON = "reason";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String INSPECTION_ID = "inspectionId";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String BIDITEM_ID = "biditemId";
	public static final String WBSITEM_ID = "wbsitemId";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

