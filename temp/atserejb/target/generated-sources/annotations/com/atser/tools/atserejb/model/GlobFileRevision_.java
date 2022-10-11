package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFileRevision.class)
public abstract class GlobFileRevision_ {

	public static volatile SingularAttribute<GlobFileRevision, String> fTo;
	public static volatile SingularAttribute<GlobFileRevision, String> distributedTo;
	public static volatile SingularAttribute<GlobFileRevision, String> extension;
	public static volatile SingularAttribute<GlobFileRevision, BigInteger> fSize;
	public static volatile SingularAttribute<GlobFileRevision, String> keywords;
	public static volatile SingularAttribute<GlobFileRevision, String> subject;
	public static volatile SingularAttribute<GlobFileRevision, Date> fDate;
	public static volatile SingularAttribute<GlobFileRevision, String> fTitle;
	public static volatile SingularAttribute<GlobFileRevision, String> dcn;
	public static volatile SingularAttribute<GlobFileRevision, String> fFrom;
	public static volatile SingularAttribute<GlobFileRevision, Date> archived;
	public static volatile SingularAttribute<GlobFileRevision, String> fName;
	public static volatile SingularAttribute<GlobFileRevision, Date> uploaded;
	public static volatile SingularAttribute<GlobFileRevision, String> systemKeywords;
	public static volatile SingularAttribute<GlobFileRevision, BigDecimal> id;
	public static volatile SingularAttribute<GlobFileRevision, Date> checkoutTime;
	public static volatile SingularAttribute<GlobFileRevision, String> sourcePath;
	public static volatile SingularAttribute<GlobFileRevision, BigInteger> owner;
	public static volatile SingularAttribute<GlobFileRevision, String> serverPath;
	public static volatile SingularAttribute<GlobFileRevision, BigInteger> version;
	public static volatile SingularAttribute<GlobFileRevision, BigInteger> folderId;
	public static volatile SingularAttribute<GlobFileRevision, BigInteger> contractId;
	public static volatile SingularAttribute<GlobFileRevision, String> sourceName;
	public static volatile SingularAttribute<GlobFileRevision, BigInteger> checkoutId;
	public static volatile SingularAttribute<GlobFileRevision, BigInteger> projectId;
	public static volatile SingularAttribute<GlobFileRevision, GlobFile> fileId;

	public static final String F_TO = "fTo";
	public static final String DISTRIBUTED_TO = "distributedTo";
	public static final String EXTENSION = "extension";
	public static final String F_SIZE = "fSize";
	public static final String KEYWORDS = "keywords";
	public static final String SUBJECT = "subject";
	public static final String F_DATE = "fDate";
	public static final String F_TITLE = "fTitle";
	public static final String DCN = "dcn";
	public static final String F_FROM = "fFrom";
	public static final String ARCHIVED = "archived";
	public static final String F_NAME = "fName";
	public static final String UPLOADED = "uploaded";
	public static final String SYSTEM_KEYWORDS = "systemKeywords";
	public static final String ID = "id";
	public static final String CHECKOUT_TIME = "checkoutTime";
	public static final String SOURCE_PATH = "sourcePath";
	public static final String OWNER = "owner";
	public static final String SERVER_PATH = "serverPath";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String CONTRACT_ID = "contractId";
	public static final String SOURCE_NAME = "sourceName";
	public static final String CHECKOUT_ID = "checkoutId";
	public static final String PROJECT_ID = "projectId";
	public static final String FILE_ID = "fileId";

}

