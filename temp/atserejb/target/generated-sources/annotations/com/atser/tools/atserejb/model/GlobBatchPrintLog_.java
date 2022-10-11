package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobBatchPrintLog.class)
public abstract class GlobBatchPrintLog_ {

	public static volatile SingularAttribute<GlobBatchPrintLog, BigInteger> clientId;
	public static volatile SingularAttribute<GlobBatchPrintLog, String> searchCriteria;
	public static volatile SingularAttribute<GlobBatchPrintLog, BigInteger> recordCount;
	public static volatile SingularAttribute<GlobBatchPrintLog, String> trackNo;
	public static volatile SingularAttribute<GlobBatchPrintLog, BigInteger> requestedBy;
	public static volatile SingularAttribute<GlobBatchPrintLog, Date> ending;
	public static volatile SingularAttribute<GlobBatchPrintLog, String> downloadLink;
	public static volatile SingularAttribute<GlobBatchPrintLog, BigInteger> labId;
	public static volatile SingularAttribute<GlobBatchPrintLog, BigDecimal> id;
	public static volatile SingularAttribute<GlobBatchPrintLog, String> batchTitle;
	public static volatile SingularAttribute<GlobBatchPrintLog, Date> starting;
	public static volatile SingularAttribute<GlobBatchPrintLog, String> batchType;
	public static volatile SingularAttribute<GlobBatchPrintLog, String> status;

	public static final String CLIENT_ID = "clientId";
	public static final String SEARCH_CRITERIA = "searchCriteria";
	public static final String RECORD_COUNT = "recordCount";
	public static final String TRACK_NO = "trackNo";
	public static final String REQUESTED_BY = "requestedBy";
	public static final String ENDING = "ending";
	public static final String DOWNLOAD_LINK = "downloadLink";
	public static final String LAB_ID = "labId";
	public static final String ID = "id";
	public static final String BATCH_TITLE = "batchTitle";
	public static final String STARTING = "starting";
	public static final String BATCH_TYPE = "batchType";
	public static final String STATUS = "status";

}

