package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaInspectionAsset.class)
public abstract class QaInspectionAsset_ {

	public static volatile SingularAttribute<QaInspectionAsset, String> gpsLongitude;
	public static volatile SingularAttribute<QaInspectionAsset, String> createdByIp;
	public static volatile SingularAttribute<QaInspectionAsset, String> lastModBy;
	public static volatile SingularAttribute<QaInspectionAsset, Date> created;
	public static volatile SingularAttribute<QaInspectionAsset, Character> active;
	public static volatile SingularAttribute<QaInspectionAsset, String> assetNo;
	public static volatile SingularAttribute<QaInspectionAsset, String> gpsAltitude;
	public static volatile SingularAttribute<QaInspectionAsset, Integer> version;
	public static volatile SingularAttribute<QaInspectionAsset, QaInspection> inspectionId;
	public static volatile SingularAttribute<QaInspectionAsset, String> lastModIp;
	public static volatile SingularAttribute<QaInspectionAsset, Character> deleted;
	public static volatile SingularAttribute<QaInspectionAsset, String> createdBy;
	public static volatile SingularAttribute<QaInspectionAsset, BigDecimal> id;
	public static volatile SingularAttribute<QaInspectionAsset, Date> lastMod;
	public static volatile SingularAttribute<QaInspectionAsset, String> gpsLatitude;

	public static final String GPS_LONGITUDE = "gpsLongitude";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String ASSET_NO = "assetNo";
	public static final String GPS_ALTITUDE = "gpsAltitude";
	public static final String VERSION = "version";
	public static final String INSPECTION_ID = "inspectionId";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String GPS_LATITUDE = "gpsLatitude";

}

