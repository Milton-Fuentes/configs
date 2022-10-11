package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaInspection.class)
public abstract class QaInspection_ {

	public static volatile SingularAttribute<QaInspection, QaInspectionVisual> qaInspectionVisual;
	public static volatile SingularAttribute<QaInspection, QaInspectionPrecaststress> qaInspectionPrecaststress;
	public static volatile SingularAttribute<QaInspection, QaInspectionSimpleCat> simplecatId;
	public static volatile SingularAttribute<QaInspection, String> lastModBy;
	public static volatile SingularAttribute<QaInspection, QaInspectionQcml> qaInspectionQcml;
	public static volatile SingularAttribute<QaInspection, QaInspectionCertofsrc> qaInspectionCertofsrc;
	public static volatile SingularAttribute<QaInspection, String> inspNo;
	public static volatile SingularAttribute<QaInspection, String> lastModIp;
	public static volatile SingularAttribute<QaInspection, String> icn;
	public static volatile SingularAttribute<QaInspection, BigInteger> labId;
	public static volatile SingularAttribute<QaInspection, BigDecimal> id;
	public static volatile SingularAttribute<QaInspection, String> loggedInBy;
	public static volatile SingularAttribute<QaInspection, String> createdByIp;
	public static volatile ListAttribute<QaInspection, QaInspectionSpecimen> qaInspectionSpecimenList;
	public static volatile SingularAttribute<QaInspection, BigInteger> clientId;
	public static volatile SingularAttribute<QaInspection, QaInspectionNotunused> qaInspectionNotunused;
	public static volatile SingularAttribute<QaInspection, Date> created;
	public static volatile SingularAttribute<QaInspection, Character> active;
	public static volatile SingularAttribute<QaInspection, Integer> version;
	public static volatile SingularAttribute<QaInspection, BigInteger> folderId;
	public static volatile SingularAttribute<QaInspection, Character> deleted;
	public static volatile ListAttribute<QaInspection, QaInspectionAsset> qaInspectionAssetList;
	public static volatile SingularAttribute<QaInspection, BigInteger> statusId;
	public static volatile SingularAttribute<QaInspection, BigInteger> sno;
	public static volatile SingularAttribute<QaInspection, String> createdBy;
	public static volatile SingularAttribute<QaInspection, BigInteger> projectId;
	public static volatile SingularAttribute<QaInspection, String> spattern;
	public static volatile SingularAttribute<QaInspection, String> loggedInJobtitle;
	public static volatile SingularAttribute<QaInspection, Date> lastMod;
	public static volatile SingularAttribute<QaInspection, QaInspectionType> inspectionTypeId;
	public static volatile SingularAttribute<QaInspection, String> remarks;
	public static volatile ListAttribute<QaInspection, QaInspectionSigninfo> qaInspectionSigninfoList;

	public static final String QA_INSPECTION_VISUAL = "qaInspectionVisual";
	public static final String QA_INSPECTION_PRECASTSTRESS = "qaInspectionPrecaststress";
	public static final String SIMPLECAT_ID = "simplecatId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String QA_INSPECTION_QCML = "qaInspectionQcml";
	public static final String QA_INSPECTION_CERTOFSRC = "qaInspectionCertofsrc";
	public static final String INSP_NO = "inspNo";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ICN = "icn";
	public static final String LAB_ID = "labId";
	public static final String ID = "id";
	public static final String LOGGED_IN_BY = "loggedInBy";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String QA_INSPECTION_SPECIMEN_LIST = "qaInspectionSpecimenList";
	public static final String CLIENT_ID = "clientId";
	public static final String QA_INSPECTION_NOTUNUSED = "qaInspectionNotunused";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String DELETED = "deleted";
	public static final String QA_INSPECTION_ASSET_LIST = "qaInspectionAssetList";
	public static final String STATUS_ID = "statusId";
	public static final String SNO = "sno";
	public static final String CREATED_BY = "createdBy";
	public static final String PROJECT_ID = "projectId";
	public static final String SPATTERN = "spattern";
	public static final String LOGGED_IN_JOBTITLE = "loggedInJobtitle";
	public static final String LAST_MOD = "lastMod";
	public static final String INSPECTION_TYPE_ID = "inspectionTypeId";
	public static final String REMARKS = "remarks";
	public static final String QA_INSPECTION_SIGNINFO_LIST = "qaInspectionSigninfoList";

}

