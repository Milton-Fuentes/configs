package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwTransmittal.class)
public abstract class VwTransmittal_ {

	public static volatile SingularAttribute<VwTransmittal, String> lastModBy;
	public static volatile SingularAttribute<VwTransmittal, Integer> transmittedFor;
	public static volatile SingularAttribute<VwTransmittal, String> lastModIp;
	public static volatile SingularAttribute<VwTransmittal, Integer> attachment;
	public static volatile SingularAttribute<VwTransmittal, BigDecimal> id;
	public static volatile SingularAttribute<VwTransmittal, String> transmittedBy;
	public static volatile SingularAttribute<VwTransmittal, String> transmittedByCompany;
	public static volatile SingularAttribute<VwTransmittal, String> createdByIp;
	public static volatile SingularAttribute<VwTransmittal, BigDecimal> clientId;
	public static volatile SingularAttribute<VwTransmittal, String> pname;
	public static volatile SingularAttribute<VwTransmittal, Date> created;
	public static volatile SingularAttribute<VwTransmittal, Character> active;
	public static volatile SingularAttribute<VwTransmittal, String> pnumber;
	public static volatile SingularAttribute<VwTransmittal, Integer> spno;
	public static volatile SingularAttribute<VwTransmittal, Integer> version;
	public static volatile SingularAttribute<VwTransmittal, BigDecimal> folderId;
	public static volatile SingularAttribute<VwTransmittal, String> transmittalNo;
	public static volatile SingularAttribute<VwTransmittal, Character> deleted;
	public static volatile SingularAttribute<VwTransmittal, Integer> sno;
	public static volatile SingularAttribute<VwTransmittal, String> createdBy;
	public static volatile SingularAttribute<VwTransmittal, String> name;
	public static volatile SingularAttribute<VwTransmittal, String> attention;
	public static volatile SingularAttribute<VwTransmittal, String> attentionCompany;
	public static volatile SingularAttribute<VwTransmittal, BigDecimal> projectId;
	public static volatile SingularAttribute<VwTransmittal, Date> lastMod;
	public static volatile SingularAttribute<VwTransmittal, String> status;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String TRANSMITTED_FOR = "transmittedFor";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ATTACHMENT = "attachment";
	public static final String ID = "id";
	public static final String TRANSMITTED_BY = "transmittedBy";
	public static final String TRANSMITTED_BY_COMPANY = "transmittedByCompany";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String PNAME = "pname";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String PNUMBER = "pnumber";
	public static final String SPNO = "spno";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String TRANSMITTAL_NO = "transmittalNo";
	public static final String DELETED = "deleted";
	public static final String SNO = "sno";
	public static final String CREATED_BY = "createdBy";
	public static final String NAME = "name";
	public static final String ATTENTION = "attention";
	public static final String ATTENTION_COMPANY = "attentionCompany";
	public static final String PROJECT_ID = "projectId";
	public static final String LAST_MOD = "lastMod";
	public static final String STATUS = "status";

}

