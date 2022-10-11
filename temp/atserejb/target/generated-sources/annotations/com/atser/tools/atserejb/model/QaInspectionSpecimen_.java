package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaInspectionSpecimen.class)
public abstract class QaInspectionSpecimen_ {

	public static volatile SingularAttribute<QaInspectionSpecimen, String> gpsLongitude;
	public static volatile SingularAttribute<QaInspectionSpecimen, String> createdByIp;
	public static volatile SingularAttribute<QaInspectionSpecimen, String> lastModBy;
	public static volatile SingularAttribute<QaInspectionSpecimen, Date> created;
	public static volatile SingularAttribute<QaInspectionSpecimen, Character> active;
	public static volatile SingularAttribute<QaInspectionSpecimen, String> specNo;
	public static volatile SingularAttribute<QaInspectionSpecimen, String> gpsAltitude;
	public static volatile SingularAttribute<QaInspectionSpecimen, Integer> version;
	public static volatile SingularAttribute<QaInspectionSpecimen, QaInspection> inspectionId;
	public static volatile SingularAttribute<QaInspectionSpecimen, String> lastModIp;
	public static volatile SingularAttribute<QaInspectionSpecimen, Character> deleted;
	public static volatile SingularAttribute<QaInspectionSpecimen, String> sno;
	public static volatile SingularAttribute<QaInspectionSpecimen, String> createdBy;
	public static volatile SingularAttribute<QaInspectionSpecimen, BigDecimal> id;
	public static volatile SingularAttribute<QaInspectionSpecimen, Date> lastMod;
	public static volatile SingularAttribute<QaInspectionSpecimen, String> gpsLatitude;

	public static final String GPS_LONGITUDE = "gpsLongitude";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String SPEC_NO = "specNo";
	public static final String GPS_ALTITUDE = "gpsAltitude";
	public static final String VERSION = "version";
	public static final String INSPECTION_ID = "inspectionId";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String SNO = "sno";
	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String GPS_LATITUDE = "gpsLatitude";

}

