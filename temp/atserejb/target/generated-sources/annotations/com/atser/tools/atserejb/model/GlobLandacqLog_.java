package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobLandacqLog.class)
public abstract class GlobLandacqLog_ {

	public static volatile SingularAttribute<GlobLandacqLog, String> lastModBy;
	public static volatile SingularAttribute<GlobLandacqLog, String> acquisitionType;
	public static volatile SingularAttribute<GlobLandacqLog, BigInteger> county;
	public static volatile SingularAttribute<GlobLandacqLog, String> owners;
	public static volatile SingularAttribute<GlobLandacqLog, String> stationing;
	public static volatile SingularAttribute<GlobLandacqLog, BigInteger> propertyStatus;
	public static volatile SingularAttribute<GlobLandacqLog, String> lastModIp;
	public static volatile SingularAttribute<GlobLandacqLog, BigDecimal> id;
	public static volatile SingularAttribute<GlobLandacqLog, BigInteger> landType;
	public static volatile SingularAttribute<GlobLandacqLog, Date> rowCertificationDate;
	public static volatile SingularAttribute<GlobLandacqLog, Character> landAvailable;
	public static volatile SingularAttribute<GlobLandacqLog, String> typeOfUtilities;
	public static volatile SingularAttribute<GlobLandacqLog, String> createdByIp;
	public static volatile SingularAttribute<GlobLandacqLog, BigInteger> clientId;
	public static volatile SingularAttribute<GlobLandacqLog, String> parcelImpact;
	public static volatile SingularAttribute<GlobLandacqLog, Date> created;
	public static volatile SingularAttribute<GlobLandacqLog, BigInteger> utDrawingNo;
	public static volatile SingularAttribute<GlobLandacqLog, String> siteAddress;
	public static volatile SingularAttribute<GlobLandacqLog, Character> active;
	public static volatile SingularAttribute<GlobLandacqLog, String> landacqNo;
	public static volatile SingularAttribute<GlobLandacqLog, String> gisLocation;
	public static volatile SingularAttribute<GlobLandacqLog, Integer> version;
	public static volatile SingularAttribute<GlobLandacqLog, BigInteger> folderId;
	public static volatile SingularAttribute<GlobLandacqLog, String> rowCertificationNo;
	public static volatile SingularAttribute<GlobLandacqLog, Character> deleted;
	public static volatile SingularAttribute<GlobLandacqLog, BigInteger> statusId;
	public static volatile SingularAttribute<GlobLandacqLog, BigInteger> sno;
	public static volatile SingularAttribute<GlobLandacqLog, String> createdBy;
	public static volatile SingularAttribute<GlobLandacqLog, Date> dateAvailable;
	public static volatile SingularAttribute<GlobLandacqLog, String> accessToProperty;
	public static volatile SingularAttribute<GlobLandacqLog, String> rowacqNo;
	public static volatile SingularAttribute<GlobLandacqLog, String> contactPhoneNumber;
	public static volatile SingularAttribute<GlobLandacqLog, Character> envIssues;
	public static volatile SingularAttribute<GlobLandacqLog, BigInteger> projectId;
	public static volatile SingularAttribute<GlobLandacqLog, String> spattern;
	public static volatile SingularAttribute<GlobLandacqLog, Date> lastMod;
	public static volatile SingularAttribute<GlobLandacqLog, String> mappg;
	public static volatile SingularAttribute<GlobLandacqLog, String> typeOfContract;
	public static volatile SingularAttribute<GlobLandacqLog, Date> occupiedDate;
	public static volatile SingularAttribute<GlobLandacqLog, String> remarks;
	public static volatile SingularAttribute<GlobLandacqLog, String> llpcn;
	public static volatile SingularAttribute<GlobLandacqLog, String> improvements;
	public static volatile SingularAttribute<GlobLandacqLog, Character> requestForUtility;
	public static volatile SingularAttribute<GlobLandacqLog, String> propertyOwnerConversations;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String ACQUISITION_TYPE = "acquisitionType";
	public static final String COUNTY = "county";
	public static final String OWNERS = "owners";
	public static final String STATIONING = "stationing";
	public static final String PROPERTY_STATUS = "propertyStatus";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ID = "id";
	public static final String LAND_TYPE = "landType";
	public static final String ROW_CERTIFICATION_DATE = "rowCertificationDate";
	public static final String LAND_AVAILABLE = "landAvailable";
	public static final String TYPE_OF_UTILITIES = "typeOfUtilities";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String PARCEL_IMPACT = "parcelImpact";
	public static final String CREATED = "created";
	public static final String UT_DRAWING_NO = "utDrawingNo";
	public static final String SITE_ADDRESS = "siteAddress";
	public static final String ACTIVE = "active";
	public static final String LANDACQ_NO = "landacqNo";
	public static final String GIS_LOCATION = "gisLocation";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String ROW_CERTIFICATION_NO = "rowCertificationNo";
	public static final String DELETED = "deleted";
	public static final String STATUS_ID = "statusId";
	public static final String SNO = "sno";
	public static final String CREATED_BY = "createdBy";
	public static final String DATE_AVAILABLE = "dateAvailable";
	public static final String ACCESS_TO_PROPERTY = "accessToProperty";
	public static final String ROWACQ_NO = "rowacqNo";
	public static final String CONTACT_PHONE_NUMBER = "contactPhoneNumber";
	public static final String ENV_ISSUES = "envIssues";
	public static final String PROJECT_ID = "projectId";
	public static final String SPATTERN = "spattern";
	public static final String LAST_MOD = "lastMod";
	public static final String MAPPG = "mappg";
	public static final String TYPE_OF_CONTRACT = "typeOfContract";
	public static final String OCCUPIED_DATE = "occupiedDate";
	public static final String REMARKS = "remarks";
	public static final String LLPCN = "llpcn";
	public static final String IMPROVEMENTS = "improvements";
	public static final String REQUEST_FOR_UTILITY = "requestForUtility";
	public static final String PROPERTY_OWNER_CONVERSATIONS = "propertyOwnerConversations";

}

