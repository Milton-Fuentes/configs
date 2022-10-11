package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaSampleAssets.class)
public abstract class QaSampleAssets_ {

	public static volatile SingularAttribute<QaSampleAssets, String> lastModBy;
	public static volatile SingularAttribute<QaSampleAssets, BigInteger> sampleId;
	public static volatile SingularAttribute<QaSampleAssets, String> lonGps;
	public static volatile SingularAttribute<QaSampleAssets, Character> active;
	public static volatile SingularAttribute<QaSampleAssets, String> assetNo;
	public static volatile SingularAttribute<QaSampleAssets, String> altGps;
	public static volatile SingularAttribute<QaSampleAssets, String> version;
	public static volatile SingularAttribute<QaSampleAssets, String> createByIp;
	public static volatile SingularAttribute<QaSampleAssets, String> createBy;
	public static volatile SingularAttribute<QaSampleAssets, String> lastModIp;
	public static volatile SingularAttribute<QaSampleAssets, String> latGps;
	public static volatile SingularAttribute<QaSampleAssets, BigDecimal> id;
	public static volatile SingularAttribute<QaSampleAssets, String> lastMod;
	public static volatile SingularAttribute<QaSampleAssets, String> createDate;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String SAMPLE_ID = "sampleId";
	public static final String LON_GPS = "lonGps";
	public static final String ACTIVE = "active";
	public static final String ASSET_NO = "assetNo";
	public static final String ALT_GPS = "altGps";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String LAT_GPS = "latGps";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";

}

