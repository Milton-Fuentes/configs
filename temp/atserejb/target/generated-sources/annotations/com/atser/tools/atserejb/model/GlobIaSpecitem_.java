package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobIaSpecitem.class)
public abstract class GlobIaSpecitem_ {

	public static volatile SingularAttribute<GlobIaSpecitem, BigInteger> specId;
	public static volatile SingularAttribute<GlobIaSpecitem, BigInteger> iaTypeId;
	public static volatile SingularAttribute<GlobIaSpecitem, String> lastModBy;
	public static volatile SingularAttribute<GlobIaSpecitem, String> description;
	public static volatile SingularAttribute<GlobIaSpecitem, Double> qcFreqInterval;
	public static volatile SingularAttribute<GlobIaSpecitem, Double> accMinAmount;
	public static volatile SingularAttribute<GlobIaSpecitem, Double> wQcFreqInterval;
	public static volatile SingularAttribute<GlobIaSpecitem, String> version;
	public static volatile SingularAttribute<GlobIaSpecitem, String> createByIp;
	public static volatile SingularAttribute<GlobIaSpecitem, Double> qcMinAmount;
	public static volatile SingularAttribute<GlobIaSpecitem, Double> wAccFreqInterval;
	public static volatile SingularAttribute<GlobIaSpecitem, String> createBy;
	public static volatile SingularAttribute<GlobIaSpecitem, String> lastModIp;
	public static volatile SingularAttribute<GlobIaSpecitem, Double> wQcMinAmount;
	public static volatile SingularAttribute<GlobIaSpecitem, BigInteger> listOrder;
	public static volatile SingularAttribute<GlobIaSpecitem, Double> wAccMinAmount;
	public static volatile SingularAttribute<GlobIaSpecitem, Double> accFreqInterval;
	public static volatile SingularAttribute<GlobIaSpecitem, BigDecimal> id;
	public static volatile SingularAttribute<GlobIaSpecitem, String> lastMod;

	public static final String SPEC_ID = "specId";
	public static final String IA_TYPE_ID = "iaTypeId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String DESCRIPTION = "description";
	public static final String QC_FREQ_INTERVAL = "qcFreqInterval";
	public static final String ACC_MIN_AMOUNT = "accMinAmount";
	public static final String W_QC_FREQ_INTERVAL = "wQcFreqInterval";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String QC_MIN_AMOUNT = "qcMinAmount";
	public static final String W_ACC_FREQ_INTERVAL = "wAccFreqInterval";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String W_QC_MIN_AMOUNT = "wQcMinAmount";
	public static final String LIST_ORDER = "listOrder";
	public static final String W_ACC_MIN_AMOUNT = "wAccMinAmount";
	public static final String ACC_FREQ_INTERVAL = "accFreqInterval";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

