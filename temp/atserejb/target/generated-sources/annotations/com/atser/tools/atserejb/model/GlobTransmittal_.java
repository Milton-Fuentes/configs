package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobTransmittal.class)
public abstract class GlobTransmittal_ {

	public static volatile SingularAttribute<GlobTransmittal, String> attentionAddress;
	public static volatile SingularAttribute<GlobTransmittal, String> lastModBy;
	public static volatile SingularAttribute<GlobTransmittal, Integer> transmittedFor;
	public static volatile SingularAttribute<GlobTransmittal, String> transmittedForOther;
	public static volatile SingularAttribute<GlobTransmittal, String> transmittedAddress;
	public static volatile SingularAttribute<GlobTransmittal, String> lastModIp;
	public static volatile SingularAttribute<GlobTransmittal, BigDecimal> id;
	public static volatile SingularAttribute<GlobTransmittal, String> transmittedBy;
	public static volatile SingularAttribute<GlobTransmittal, String> transmittedByCompany;
	public static volatile SingularAttribute<GlobTransmittal, String> createdByIp;
	public static volatile SingularAttribute<GlobTransmittal, BigDecimal> clientId;
	public static volatile SingularAttribute<GlobTransmittal, Date> created;
	public static volatile SingularAttribute<GlobTransmittal, Character> active;
	public static volatile SingularAttribute<GlobTransmittal, Integer> spno;
	public static volatile SingularAttribute<GlobTransmittal, Integer> version;
	public static volatile SingularAttribute<GlobTransmittal, BigDecimal> folderId;
	public static volatile ListAttribute<GlobTransmittal, GlobTransmittalDtn> distributions;
	public static volatile SingularAttribute<GlobTransmittal, String> transmittalNo;
	public static volatile SingularAttribute<GlobTransmittal, Character> deleted;
	public static volatile SingularAttribute<GlobTransmittal, Integer> sno;
	public static volatile SingularAttribute<GlobTransmittal, String> trackingNo;
	public static volatile SingularAttribute<GlobTransmittal, String> createdBy;
	public static volatile SingularAttribute<GlobTransmittal, BigInteger> contractId;
	public static volatile SingularAttribute<GlobTransmittal, Integer> deliveredVia;
	public static volatile SingularAttribute<GlobTransmittal, String> attention;
	public static volatile SingularAttribute<GlobTransmittal, String> attentionCompany;
	public static volatile SingularAttribute<GlobTransmittal, BigDecimal> projectId;
	public static volatile SingularAttribute<GlobTransmittal, Date> lastMod;
	public static volatile ListAttribute<GlobTransmittal, GlobTransmittalItem> items;
	public static volatile SingularAttribute<GlobTransmittal, String> status;

	public static final String ATTENTION_ADDRESS = "attentionAddress";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String TRANSMITTED_FOR = "transmittedFor";
	public static final String TRANSMITTED_FOR_OTHER = "transmittedForOther";
	public static final String TRANSMITTED_ADDRESS = "transmittedAddress";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ID = "id";
	public static final String TRANSMITTED_BY = "transmittedBy";
	public static final String TRANSMITTED_BY_COMPANY = "transmittedByCompany";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String SPNO = "spno";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String DISTRIBUTIONS = "distributions";
	public static final String TRANSMITTAL_NO = "transmittalNo";
	public static final String DELETED = "deleted";
	public static final String SNO = "sno";
	public static final String TRACKING_NO = "trackingNo";
	public static final String CREATED_BY = "createdBy";
	public static final String CONTRACT_ID = "contractId";
	public static final String DELIVERED_VIA = "deliveredVia";
	public static final String ATTENTION = "attention";
	public static final String ATTENTION_COMPANY = "attentionCompany";
	public static final String PROJECT_ID = "projectId";
	public static final String LAST_MOD = "lastMod";
	public static final String ITEMS = "items";
	public static final String STATUS = "status";

}

