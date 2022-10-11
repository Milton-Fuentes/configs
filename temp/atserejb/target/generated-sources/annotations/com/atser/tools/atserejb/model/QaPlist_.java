package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaPlist.class)
public abstract class QaPlist_ {

	public static volatile SingularAttribute<QaPlist, String> lastModBy;
	public static volatile ListAttribute<QaPlist, QaPlistUpdate> qaplistUpdateList;
	public static volatile SingularAttribute<QaPlist, String> detailLocation;
	public static volatile SingularAttribute<QaPlist, String> traceNo;
	public static volatile SingularAttribute<QaPlist, String> insp3Appv;
	public static volatile SingularAttribute<QaPlist, String> itemNo;
	public static volatile SingularAttribute<QaPlist, String> checkedBy;
	public static volatile SingularAttribute<QaPlist, String> segment;
	public static volatile SingularAttribute<QaPlist, BigInteger> typerdId;
	public static volatile SingularAttribute<QaPlist, String> itemDescript;
	public static volatile SingularAttribute<QaPlist, String> typeactvNb;
	public static volatile SingularAttribute<QaPlist, BigDecimal> id;
	public static volatile SingularAttribute<QaPlist, BigInteger> psectId;
	public static volatile SingularAttribute<QaPlist, String> insp4Appv;
	public static volatile SingularAttribute<QaPlist, Date> unappvDate;
	public static volatile SingularAttribute<QaPlist, BigInteger> elementId;
	public static volatile SingularAttribute<QaPlist, String> insp5Appv;
	public static volatile SingularAttribute<QaPlist, String> offset;
	public static volatile SingularAttribute<QaPlist, String> ncrRef;
	public static volatile SingularAttribute<QaPlist, BigInteger> subtypeId;
	public static volatile SingularAttribute<QaPlist, String> partNb;
	public static volatile SingularAttribute<QaPlist, String> itemLocation;
	public static volatile SingularAttribute<QaPlist, String> version;
	public static volatile SingularAttribute<QaPlist, BigInteger> typeactvId;
	public static volatile SingularAttribute<QaPlist, BigInteger> projectId;
	public static volatile SingularAttribute<QaPlist, String> lastMod;
	public static volatile SingularAttribute<QaPlist, String> contractor;
	public static volatile SingularAttribute<QaPlist, BigInteger> psegId;
	public static volatile SingularAttribute<QaPlist, BigInteger> partId;
	public static volatile SingularAttribute<QaPlist, String> lonGps;
	public static volatile SingularAttribute<QaPlist, String> elementNb;
	public static volatile SingularAttribute<QaPlist, String> rfiRef;
	public static volatile SingularAttribute<QaPlist, Date> itemDate;
	public static volatile SingularAttribute<QaPlist, String> latGps;
	public static volatile SingularAttribute<QaPlist, String> lastModIp;
	public static volatile SingularAttribute<QaPlist, String> specPlanRef;
	public static volatile SingularAttribute<QaPlist, String> responsibility;
	public static volatile SingularAttribute<QaPlist, String> itemStatus;
	public static volatile SingularAttribute<QaPlist, String> subtypeNb;
	public static volatile SingularAttribute<QaPlist, BigInteger> orientId;
	public static volatile SingularAttribute<QaPlist, String> station;
	public static volatile SingularAttribute<QaPlist, String> itemPhoto;
	public static volatile SingularAttribute<QaPlist, String> actionReq;
	public static volatile SingularAttribute<QaPlist, QaPListType> itemTypeId;
	public static volatile SingularAttribute<QaPlist, Date> createDate;
	public static volatile SingularAttribute<QaPlist, String> elevation;
	public static volatile SingularAttribute<QaPlist, BigInteger> clientId;
	public static volatile SingularAttribute<QaPlist, BigInteger> corridorId;
	public static volatile SingularAttribute<QaPlist, String> subRef;
	public static volatile SingularAttribute<QaPlist, BigInteger> copyfromId;
	public static volatile SingularAttribute<QaPlist, String> insp1Appv;
	public static volatile SingularAttribute<QaPlist, BigInteger> ptypeId;
	public static volatile SingularAttribute<QaPlist, String> altGps;
	public static volatile SingularAttribute<QaPlist, Date> occurDate;
	public static volatile SingularAttribute<QaPlist, String> createByIp;
	public static volatile SingularAttribute<QaPlist, String> resolvedDetail;
	public static volatile SingularAttribute<QaPlist, String> toStation;
	public static volatile SingularAttribute<QaPlist, QaPlistStruct> structId;
	public static volatile SingularAttribute<QaPlist, String> createBy;
	public static volatile SingularAttribute<QaPlist, String> sccNcrRef;
	public static volatile SingularAttribute<QaPlist, Date> closedDate;
	public static volatile SingularAttribute<QaPlist, BigInteger> unappvId;
	public static volatile SingularAttribute<QaPlist, String> insp2Appv;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String QAPLIST_UPDATE_LIST = "qaplistUpdateList";
	public static final String DETAIL_LOCATION = "detailLocation";
	public static final String TRACE_NO = "traceNo";
	public static final String INSP3_APPV = "insp3Appv";
	public static final String ITEM_NO = "itemNo";
	public static final String CHECKED_BY = "checkedBy";
	public static final String SEGMENT = "segment";
	public static final String TYPERD_ID = "typerdId";
	public static final String ITEM_DESCRIPT = "itemDescript";
	public static final String TYPEACTV_NB = "typeactvNb";
	public static final String ID = "id";
	public static final String PSECT_ID = "psectId";
	public static final String INSP4_APPV = "insp4Appv";
	public static final String UNAPPV_DATE = "unappvDate";
	public static final String ELEMENT_ID = "elementId";
	public static final String INSP5_APPV = "insp5Appv";
	public static final String OFFSET = "offset";
	public static final String NCR_REF = "ncrRef";
	public static final String SUBTYPE_ID = "subtypeId";
	public static final String PART_NB = "partNb";
	public static final String ITEM_LOCATION = "itemLocation";
	public static final String VERSION = "version";
	public static final String TYPEACTV_ID = "typeactvId";
	public static final String PROJECT_ID = "projectId";
	public static final String LAST_MOD = "lastMod";
	public static final String CONTRACTOR = "contractor";
	public static final String PSEG_ID = "psegId";
	public static final String PART_ID = "partId";
	public static final String LON_GPS = "lonGps";
	public static final String ELEMENT_NB = "elementNb";
	public static final String RFI_REF = "rfiRef";
	public static final String ITEM_DATE = "itemDate";
	public static final String LAT_GPS = "latGps";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String SPEC_PLAN_REF = "specPlanRef";
	public static final String RESPONSIBILITY = "responsibility";
	public static final String ITEM_STATUS = "itemStatus";
	public static final String SUBTYPE_NB = "subtypeNb";
	public static final String ORIENT_ID = "orientId";
	public static final String STATION = "station";
	public static final String ITEM_PHOTO = "itemPhoto";
	public static final String ACTION_REQ = "actionReq";
	public static final String ITEM_TYPE_ID = "itemTypeId";
	public static final String CREATE_DATE = "createDate";
	public static final String ELEVATION = "elevation";
	public static final String CLIENT_ID = "clientId";
	public static final String CORRIDOR_ID = "corridorId";
	public static final String SUB_REF = "subRef";
	public static final String COPYFROM_ID = "copyfromId";
	public static final String INSP1_APPV = "insp1Appv";
	public static final String PTYPE_ID = "ptypeId";
	public static final String ALT_GPS = "altGps";
	public static final String OCCUR_DATE = "occurDate";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String RESOLVED_DETAIL = "resolvedDetail";
	public static final String TO_STATION = "toStation";
	public static final String STRUCT_ID = "structId";
	public static final String CREATE_BY = "createBy";
	public static final String SCC_NCR_REF = "sccNcrRef";
	public static final String CLOSED_DATE = "closedDate";
	public static final String UNAPPV_ID = "unappvId";
	public static final String INSP2_APPV = "insp2Appv";

}
