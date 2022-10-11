package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaTestImagestore.class)
public abstract class QaTestImagestore_ {

	public static volatile SingularAttribute<QaTestImagestore, String> serverPath;
	public static volatile SingularAttribute<QaTestImagestore, String> standard;
	public static volatile SingularAttribute<QaTestImagestore, BigInteger> sampletestId;
	public static volatile SingularAttribute<QaTestImagestore, String> extension;
	public static volatile SingularAttribute<QaTestImagestore, String> createdByIp;
	public static volatile SingularAttribute<QaTestImagestore, String> metadata;
	public static volatile SingularAttribute<QaTestImagestore, BigInteger> clientId;
	public static volatile SingularAttribute<QaTestImagestore, BigInteger> fSize;
	public static volatile SingularAttribute<QaTestImagestore, BigInteger> sampleid;
	public static volatile SingularAttribute<QaTestImagestore, Date> created;
	public static volatile SingularAttribute<QaTestImagestore, String> docType;
	public static volatile SingularAttribute<QaTestImagestore, String> active;
	public static volatile SingularAttribute<QaTestImagestore, Character> reportStatus;
	public static volatile SingularAttribute<QaTestImagestore, String> spec;
	public static volatile SingularAttribute<QaTestImagestore, String> fName;
	public static volatile SingularAttribute<QaTestImagestore, String> deleted;
	public static volatile SingularAttribute<QaTestImagestore, String> createdBy;
	public static volatile SingularAttribute<QaTestImagestore, Integer> totalPages;
	public static volatile SingularAttribute<QaTestImagestore, Integer> width;
	public static volatile SingularAttribute<QaTestImagestore, String> fNote;
	public static volatile SingularAttribute<QaTestImagestore, BigDecimal> id;
	public static volatile SingularAttribute<QaTestImagestore, BigInteger> refId;
	public static volatile SingularAttribute<QaTestImagestore, String> sourceName;
	public static volatile SingularAttribute<QaTestImagestore, Integer> height;

	public static final String SERVER_PATH = "serverPath";
	public static final String STANDARD = "standard";
	public static final String SAMPLETEST_ID = "sampletestId";
	public static final String EXTENSION = "extension";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String METADATA = "metadata";
	public static final String CLIENT_ID = "clientId";
	public static final String F_SIZE = "fSize";
	public static final String SAMPLEID = "sampleid";
	public static final String CREATED = "created";
	public static final String DOC_TYPE = "docType";
	public static final String ACTIVE = "active";
	public static final String REPORT_STATUS = "reportStatus";
	public static final String SPEC = "spec";
	public static final String F_NAME = "fName";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String TOTAL_PAGES = "totalPages";
	public static final String WIDTH = "width";
	public static final String F_NOTE = "fNote";
	public static final String ID = "id";
	public static final String REF_ID = "refId";
	public static final String SOURCE_NAME = "sourceName";
	public static final String HEIGHT = "height";

}

