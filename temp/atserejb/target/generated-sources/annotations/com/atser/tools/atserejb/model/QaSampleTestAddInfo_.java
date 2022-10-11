package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaSampleTestAddInfo.class)
public abstract class QaSampleTestAddInfo_ {

	public static volatile SingularAttribute<QaSampleTestAddInfo, BigInteger> supplierId;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> lastModBy;
	public static volatile SingularAttribute<QaSampleTestAddInfo, Date> createDateTmp;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> traceNo;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> materialComments;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> dueDate;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> description;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> materialLocation;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> section;
	public static volatile SingularAttribute<QaSampleTestAddInfo, QaSampleTest> sampleTestId;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> reportType;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> structureNo;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> lastModIp;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> specProv;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> station;
	public static volatile SingularAttribute<QaSampleTestAddInfo, BigDecimal> id;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> materialSource;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> direction;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> createDate;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> grading;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> offset;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> sampleType2;
	public static volatile SingularAttribute<QaSampleTestAddInfo, Character> active;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> version;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> createByIp;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> materialDescription;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> createBy;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> depth;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> roadway;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> location;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> reportStampType;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> lastMod;
	public static volatile SingularAttribute<QaSampleTestAddInfo, String> engDecision;

	public static final String SUPPLIER_ID = "supplierId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATE_DATE_TMP = "createDateTmp";
	public static final String TRACE_NO = "traceNo";
	public static final String MATERIAL_COMMENTS = "materialComments";
	public static final String DUE_DATE = "dueDate";
	public static final String DESCRIPTION = "description";
	public static final String MATERIAL_LOCATION = "materialLocation";
	public static final String SECTION = "section";
	public static final String SAMPLE_TEST_ID = "sampleTestId";
	public static final String REPORT_TYPE = "reportType";
	public static final String STRUCTURE_NO = "structureNo";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String SPEC_PROV = "specProv";
	public static final String STATION = "station";
	public static final String ID = "id";
	public static final String MATERIAL_SOURCE = "materialSource";
	public static final String DIRECTION = "direction";
	public static final String CREATE_DATE = "createDate";
	public static final String GRADING = "grading";
	public static final String OFFSET = "offset";
	public static final String SAMPLE_TYPE2 = "sampleType2";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String MATERIAL_DESCRIPTION = "materialDescription";
	public static final String CREATE_BY = "createBy";
	public static final String DEPTH = "depth";
	public static final String ROADWAY = "roadway";
	public static final String LOCATION = "location";
	public static final String REPORT_STAMP_TYPE = "reportStampType";
	public static final String LAST_MOD = "lastMod";
	public static final String ENG_DECISION = "engDecision";

}

