package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFile.class)
public abstract class GlobFile_ {

	public static volatile SingularAttribute<GlobFile, String> fTo;
	public static volatile SingularAttribute<GlobFile, String> distributedTo;
	public static volatile SingularAttribute<GlobFile, String> extension;
	public static volatile SingularAttribute<GlobFile, BigInteger> fSize;
	public static volatile SingularAttribute<GlobFile, String> keywords;
	public static volatile SingularAttribute<GlobFile, String> subject;
	public static volatile SingularAttribute<GlobFile, GlobCorrespd> correspdId;
	public static volatile SingularAttribute<GlobFile, Date> fDate;
	public static volatile SingularAttribute<GlobFile, String> description;
	public static volatile SingularAttribute<GlobFile, String> fTitle;
	public static volatile SingularAttribute<GlobFile, String> dcn;
	public static volatile SingularAttribute<GlobFile, String> fFrom;
	public static volatile SingularAttribute<GlobFile, String> fName;
	public static volatile SingularAttribute<GlobFile, String> fileStatus;
	public static volatile SingularAttribute<GlobFile, Date> uploaded;
	public static volatile SingularAttribute<GlobFile, String> systemKeywords;
	public static volatile SingularAttribute<GlobFile, BigDecimal> id;
	public static volatile SingularAttribute<GlobFile, Date> checkoutTime;
	public static volatile SingularAttribute<GlobFile, String> sourcePath;
	public static volatile SingularAttribute<GlobFile, BigInteger> owner;
	public static volatile SingularAttribute<GlobFile, String> serverPath;
	public static volatile ListAttribute<GlobFile, GlobFileRevision> globFileRevisionList;
	public static volatile SingularAttribute<GlobFile, Character> active;
	public static volatile SingularAttribute<GlobFile, BigInteger> version;
	public static volatile SingularAttribute<GlobFile, GlobFolder> folderId;
	public static volatile SingularAttribute<GlobFile, String> field1;
	public static volatile SingularAttribute<GlobFile, String> fDateTmp;
	public static volatile SingularAttribute<GlobFile, BigInteger> contractId;
	public static volatile SingularAttribute<GlobFile, String> field6;
	public static volatile SingularAttribute<GlobFile, String> systemPath;
	public static volatile SingularAttribute<GlobFile, String> sourceName;
	public static volatile SingularAttribute<GlobFile, BigInteger> checkoutId;
	public static volatile SingularAttribute<GlobFile, String> field3;
	public static volatile SingularAttribute<GlobFile, BigInteger> planProjectId;
	public static volatile SingularAttribute<GlobFile, String> field2;
	public static volatile SingularAttribute<GlobFile, BigInteger> projectId;
	public static volatile SingularAttribute<GlobFile, String> field5;
	public static volatile SingularAttribute<GlobFile, String> field4;

	public static final String F_TO = "fTo";
	public static final String DISTRIBUTED_TO = "distributedTo";
	public static final String EXTENSION = "extension";
	public static final String F_SIZE = "fSize";
	public static final String KEYWORDS = "keywords";
	public static final String SUBJECT = "subject";
	public static final String CORRESPD_ID = "correspdId";
	public static final String F_DATE = "fDate";
	public static final String DESCRIPTION = "description";
	public static final String F_TITLE = "fTitle";
	public static final String DCN = "dcn";
	public static final String F_FROM = "fFrom";
	public static final String F_NAME = "fName";
	public static final String FILE_STATUS = "fileStatus";
	public static final String UPLOADED = "uploaded";
	public static final String SYSTEM_KEYWORDS = "systemKeywords";
	public static final String ID = "id";
	public static final String CHECKOUT_TIME = "checkoutTime";
	public static final String SOURCE_PATH = "sourcePath";
	public static final String OWNER = "owner";
	public static final String SERVER_PATH = "serverPath";
	public static final String GLOB_FILE_REVISION_LIST = "globFileRevisionList";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String FIELD1 = "field1";
	public static final String F_DATE_TMP = "fDateTmp";
	public static final String CONTRACT_ID = "contractId";
	public static final String FIELD6 = "field6";
	public static final String SYSTEM_PATH = "systemPath";
	public static final String SOURCE_NAME = "sourceName";
	public static final String CHECKOUT_ID = "checkoutId";
	public static final String FIELD3 = "field3";
	public static final String PLAN_PROJECT_ID = "planProjectId";
	public static final String FIELD2 = "field2";
	public static final String PROJECT_ID = "projectId";
	public static final String FIELD5 = "field5";
	public static final String FIELD4 = "field4";

}

