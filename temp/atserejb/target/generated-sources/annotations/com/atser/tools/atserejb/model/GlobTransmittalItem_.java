package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobTransmittalItem.class)
public abstract class GlobTransmittalItem_ {

	public static volatile SingularAttribute<GlobTransmittalItem, String> docRevision;
	public static volatile SingularAttribute<GlobTransmittalItem, String> createdByIp;
	public static volatile SingularAttribute<GlobTransmittalItem, String> lastModBy;
	public static volatile SingularAttribute<GlobTransmittalItem, Date> created;
	public static volatile SingularAttribute<GlobTransmittalItem, Character> active;
	public static volatile SingularAttribute<GlobTransmittalItem, String> itemNo;
	public static volatile SingularAttribute<GlobTransmittalItem, String> docNo;
	public static volatile SingularAttribute<GlobTransmittalItem, Integer> version;
	public static volatile SingularAttribute<GlobTransmittalItem, GlobTransmittal> itemTransmittal;
	public static volatile SingularAttribute<GlobTransmittalItem, String> lastModIp;
	public static volatile SingularAttribute<GlobTransmittalItem, Character> deleted;
	public static volatile SingularAttribute<GlobTransmittalItem, String> createdBy;
	public static volatile SingularAttribute<GlobTransmittalItem, BigDecimal> id;
	public static volatile SingularAttribute<GlobTransmittalItem, Date> lastMod;
	public static volatile SingularAttribute<GlobTransmittalItem, String> docVersion;
	public static volatile SingularAttribute<GlobTransmittalItem, BigDecimal> fileId;
	public static volatile SingularAttribute<GlobTransmittalItem, Character> status;

	public static final String DOC_REVISION = "docRevision";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String ITEM_NO = "itemNo";
	public static final String DOC_NO = "docNo";
	public static final String VERSION = "version";
	public static final String ITEM_TRANSMITTAL = "itemTransmittal";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String DOC_VERSION = "docVersion";
	public static final String FILE_ID = "fileId";
	public static final String STATUS = "status";

}

