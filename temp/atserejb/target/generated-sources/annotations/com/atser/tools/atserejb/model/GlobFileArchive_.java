package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFileArchive.class)
public abstract class GlobFileArchive_ {

	public static volatile SingularAttribute<GlobFileArchive, Date> requested;
	public static volatile SingularAttribute<GlobFileArchive, GlobClient> clientId;
	public static volatile SingularAttribute<GlobFileArchive, String> trackingNo;
	public static volatile SingularAttribute<GlobFileArchive, BigInteger> noFiles;
	public static volatile SingularAttribute<GlobFileArchive, BigInteger> fileSize;
	public static volatile ListAttribute<GlobFileArchive, GlobFileArchiveEntry> globFileArchiveEntryList;
	public static volatile SingularAttribute<GlobFileArchive, String> zipName;
	public static volatile SingularAttribute<GlobFileArchive, BigInteger> contractId;
	public static volatile SingularAttribute<GlobFileArchive, BigDecimal> id;
	public static volatile SingularAttribute<GlobFileArchive, Date> completed;
	public static volatile SingularAttribute<GlobFileArchive, BigInteger> projectId;
	public static volatile SingularAttribute<GlobFileArchive, String> status;

	public static final String REQUESTED = "requested";
	public static final String CLIENT_ID = "clientId";
	public static final String TRACKING_NO = "trackingNo";
	public static final String NO_FILES = "noFiles";
	public static final String FILE_SIZE = "fileSize";
	public static final String GLOB_FILE_ARCHIVE_ENTRY_LIST = "globFileArchiveEntryList";
	public static final String ZIP_NAME = "zipName";
	public static final String CONTRACT_ID = "contractId";
	public static final String ID = "id";
	public static final String COMPLETED = "completed";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";

}

