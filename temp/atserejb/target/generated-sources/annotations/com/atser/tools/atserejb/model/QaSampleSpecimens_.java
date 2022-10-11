package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaSampleSpecimens.class)
public abstract class QaSampleSpecimens_ {

	public static volatile SingularAttribute<QaSampleSpecimens, String> specimenNo;
	public static volatile SingularAttribute<QaSampleSpecimens, String> lastModBy;
	public static volatile SingularAttribute<QaSampleSpecimens, BigInteger> sampleId;
	public static volatile SingularAttribute<QaSampleSpecimens, String> lonGps;
	public static volatile SingularAttribute<QaSampleSpecimens, Character> active;
	public static volatile SingularAttribute<QaSampleSpecimens, String> altGps;
	public static volatile SingularAttribute<QaSampleSpecimens, String> version;
	public static volatile SingularAttribute<QaSampleSpecimens, String> createByIp;
	public static volatile SingularAttribute<QaSampleSpecimens, String> serialNo;
	public static volatile SingularAttribute<QaSampleSpecimens, String> createBy;
	public static volatile SingularAttribute<QaSampleSpecimens, String> lastModIp;
	public static volatile SingularAttribute<QaSampleSpecimens, String> latGps;
	public static volatile SingularAttribute<QaSampleSpecimens, BigDecimal> id;
	public static volatile SingularAttribute<QaSampleSpecimens, String> lastMod;
	public static volatile SingularAttribute<QaSampleSpecimens, String> createDate;

	public static final String SPECIMEN_NO = "specimenNo";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String SAMPLE_ID = "sampleId";
	public static final String LON_GPS = "lonGps";
	public static final String ACTIVE = "active";
	public static final String ALT_GPS = "altGps";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String SERIAL_NO = "serialNo";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String LAT_GPS = "latGps";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";

}

