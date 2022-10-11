package com.atser.tools.atserejb.model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaInspectionVisual.class)
public abstract class QaInspectionVisual_ {

	public static volatile SingularAttribute<QaInspectionVisual, String> supplierName;
	public static volatile SingularAttribute<QaInspectionVisual, String> proposedUse;
	public static volatile SingularAttribute<QaInspectionVisual, String> assetAddinfo;
	public static volatile SingularAttribute<QaInspectionVisual, String> gpsLongitude;
	public static volatile SingularAttribute<QaInspectionVisual, BigInteger> supplierId;
	public static volatile SingularAttribute<QaInspectionVisual, String> inspectedByName;
	public static volatile SingularAttribute<QaInspectionVisual, String> supplierLocation;
	public static volatile SingularAttribute<QaInspectionVisual, String> inspAddinfo;
	public static volatile SingularAttribute<QaInspectionVisual, String> citytown;
	public static volatile SingularAttribute<QaInspectionVisual, String> gpsAltitude;
	public static volatile SingularAttribute<QaInspectionVisual, Integer> version;
	public static volatile SingularAttribute<QaInspectionVisual, BigInteger> supplierLocationId;
	public static volatile SingularAttribute<QaInspectionVisual, Date> inspectedDate;
	public static volatile SingularAttribute<QaInspectionVisual, Character> deleted;
	public static volatile SingularAttribute<QaInspectionVisual, BigInteger> subBiditemId;
	public static volatile SingularAttribute<QaInspectionVisual, String> inspectedByJobtitle;
	public static volatile SingularAttribute<QaInspectionVisual, BigInteger> biditemId;
	public static volatile SingularAttribute<QaInspectionVisual, BigInteger> wbsitemId;
	public static volatile SingularAttribute<QaInspectionVisual, QaInspection> id;
	public static volatile SingularAttribute<QaInspectionVisual, String> supplierType;
	public static volatile SingularAttribute<QaInspectionVisual, BigInteger> inspectedBy;
	public static volatile SingularAttribute<QaInspectionVisual, String> inspectedLocation;
	public static volatile SingularAttribute<QaInspectionVisual, String> remarks;
	public static volatile SingularAttribute<QaInspectionVisual, String> gpsLatitude;

	public static final String SUPPLIER_NAME = "supplierName";
	public static final String PROPOSED_USE = "proposedUse";
	public static final String ASSET_ADDINFO = "assetAddinfo";
	public static final String GPS_LONGITUDE = "gpsLongitude";
	public static final String SUPPLIER_ID = "supplierId";
	public static final String INSPECTED_BY_NAME = "inspectedByName";
	public static final String SUPPLIER_LOCATION = "supplierLocation";
	public static final String INSP_ADDINFO = "inspAddinfo";
	public static final String CITYTOWN = "citytown";
	public static final String GPS_ALTITUDE = "gpsAltitude";
	public static final String VERSION = "version";
	public static final String SUPPLIER_LOCATION_ID = "supplierLocationId";
	public static final String INSPECTED_DATE = "inspectedDate";
	public static final String DELETED = "deleted";
	public static final String SUB_BIDITEM_ID = "subBiditemId";
	public static final String INSPECTED_BY_JOBTITLE = "inspectedByJobtitle";
	public static final String BIDITEM_ID = "biditemId";
	public static final String WBSITEM_ID = "wbsitemId";
	public static final String ID = "id";
	public static final String SUPPLIER_TYPE = "supplierType";
	public static final String INSPECTED_BY = "inspectedBy";
	public static final String INSPECTED_LOCATION = "inspectedLocation";
	public static final String REMARKS = "remarks";
	public static final String GPS_LATITUDE = "gpsLatitude";

}

