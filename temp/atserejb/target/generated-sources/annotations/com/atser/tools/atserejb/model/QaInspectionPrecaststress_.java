package com.atser.tools.atserejb.model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaInspectionPrecaststress.class)
public abstract class QaInspectionPrecaststress_ {

	public static volatile SingularAttribute<QaInspectionPrecaststress, String> gpsLongitude;
	public static volatile SingularAttribute<QaInspectionPrecaststress, BigInteger> supplierId;
	public static volatile SingularAttribute<QaInspectionPrecaststress, String> inspAddinfo;
	public static volatile MapAttribute<QaInspectionPrecaststress, String, Object> mqcaInspActivities;
	public static volatile SingularAttribute<QaInspectionPrecaststress, BigInteger> curingId;
	public static volatile SingularAttribute<QaInspectionPrecaststress, String> gpsAltitude;
	public static volatile SingularAttribute<QaInspectionPrecaststress, Date> inspectedDate;
	public static volatile SingularAttribute<QaInspectionPrecaststress, String> inspectedByJobtitle;
	public static volatile SingularAttribute<QaInspectionPrecaststress, QaInspection> id;
	public static volatile SingularAttribute<QaInspectionPrecaststress, String> entityLocation;
	public static volatile SingularAttribute<QaInspectionPrecaststress, Date> castDate;
	public static volatile SingularAttribute<QaInspectionPrecaststress, BigInteger> inspectedBy;
	public static volatile SingularAttribute<QaInspectionPrecaststress, String> inspectedLocation;
	public static volatile SingularAttribute<QaInspectionPrecaststress, String> gpsLatitude;
	public static volatile SingularAttribute<QaInspectionPrecaststress, BigInteger> inspectorSupervisorId;
	public static volatile SingularAttribute<QaInspectionPrecaststress, String> assetAddinfo;
	public static volatile SingularAttribute<QaInspectionPrecaststress, String> inspectedByName;
	public static volatile SingularAttribute<QaInspectionPrecaststress, BigInteger> mixId;
	public static volatile MapAttribute<QaInspectionPrecaststress, String, Object> defectIdent;
	public static volatile SingularAttribute<QaInspectionPrecaststress, String> citytown;
	public static volatile SingularAttribute<QaInspectionPrecaststress, Integer> version;
	public static volatile SingularAttribute<QaInspectionPrecaststress, BigInteger> supplierLocationId;
	public static volatile SingularAttribute<QaInspectionPrecaststress, Character> deleted;
	public static volatile SingularAttribute<QaInspectionPrecaststress, BigInteger> subBiditemId;
	public static volatile SingularAttribute<QaInspectionPrecaststress, String> inspectionEntity;
	public static volatile SingularAttribute<QaInspectionPrecaststress, BigInteger> biditemId;
	public static volatile SingularAttribute<QaInspectionPrecaststress, BigInteger> wbsitemId;
	public static volatile SingularAttribute<QaInspectionPrecaststress, BigInteger> categoryId;
	public static volatile SingularAttribute<QaInspectionPrecaststress, String> remarks;

	public static final String GPS_LONGITUDE = "gpsLongitude";
	public static final String SUPPLIER_ID = "supplierId";
	public static final String INSP_ADDINFO = "inspAddinfo";
	public static final String MQCA_INSP_ACTIVITIES = "mqcaInspActivities";
	public static final String CURING_ID = "curingId";
	public static final String GPS_ALTITUDE = "gpsAltitude";
	public static final String INSPECTED_DATE = "inspectedDate";
	public static final String INSPECTED_BY_JOBTITLE = "inspectedByJobtitle";
	public static final String ID = "id";
	public static final String ENTITY_LOCATION = "entityLocation";
	public static final String CAST_DATE = "castDate";
	public static final String INSPECTED_BY = "inspectedBy";
	public static final String INSPECTED_LOCATION = "inspectedLocation";
	public static final String GPS_LATITUDE = "gpsLatitude";
	public static final String INSPECTOR_SUPERVISOR_ID = "inspectorSupervisorId";
	public static final String ASSET_ADDINFO = "assetAddinfo";
	public static final String INSPECTED_BY_NAME = "inspectedByName";
	public static final String MIX_ID = "mixId";
	public static final String DEFECT_IDENT = "defectIdent";
	public static final String CITYTOWN = "citytown";
	public static final String VERSION = "version";
	public static final String SUPPLIER_LOCATION_ID = "supplierLocationId";
	public static final String DELETED = "deleted";
	public static final String SUB_BIDITEM_ID = "subBiditemId";
	public static final String INSPECTION_ENTITY = "inspectionEntity";
	public static final String BIDITEM_ID = "biditemId";
	public static final String WBSITEM_ID = "wbsitemId";
	public static final String CATEGORY_ID = "categoryId";
	public static final String REMARKS = "remarks";

}

