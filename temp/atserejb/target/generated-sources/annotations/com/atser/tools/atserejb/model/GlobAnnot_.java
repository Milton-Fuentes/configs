package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobAnnot.class)
public abstract class GlobAnnot_ {

	public static volatile SingularAttribute<GlobAnnot, BigInteger> clientId;
	public static volatile SingularAttribute<GlobAnnot, BigInteger> pageNumber;
	public static volatile SingularAttribute<GlobAnnot, Date> modifyDate;
	public static volatile SingularAttribute<GlobAnnot, String> subject;
	public static volatile SingularAttribute<GlobAnnot, String> dataObj;
	public static volatile SingularAttribute<GlobAnnot, String> active;
	public static volatile SingularAttribute<GlobAnnot, String> title;
	public static volatile SingularAttribute<GlobAnnot, String> type;
	public static volatile SingularAttribute<GlobAnnot, BigInteger> userId;
	public static volatile SingularAttribute<GlobAnnot, String> version;
	public static volatile SingularAttribute<GlobAnnot, Date> lastEditedTime;
	public static volatile SingularAttribute<GlobAnnot, BigInteger> contractId;
	public static volatile SingularAttribute<GlobAnnot, String> name;
	public static volatile SingularAttribute<GlobAnnot, String> subType;
	public static volatile SingularAttribute<GlobAnnot, BigDecimal> id;
	public static volatile SingularAttribute<GlobAnnot, BigInteger> projectId;
	public static volatile SingularAttribute<GlobAnnot, String> remarks;
	public static volatile SingularAttribute<GlobAnnot, BigInteger> fileId;
	public static volatile SingularAttribute<GlobAnnot, Date> createDate;

	public static final String CLIENT_ID = "clientId";
	public static final String PAGE_NUMBER = "pageNumber";
	public static final String MODIFY_DATE = "modifyDate";
	public static final String SUBJECT = "subject";
	public static final String DATA_OBJ = "dataObj";
	public static final String ACTIVE = "active";
	public static final String TITLE = "title";
	public static final String TYPE = "type";
	public static final String USER_ID = "userId";
	public static final String VERSION = "version";
	public static final String LAST_EDITED_TIME = "lastEditedTime";
	public static final String CONTRACT_ID = "contractId";
	public static final String NAME = "name";
	public static final String SUB_TYPE = "subType";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String REMARKS = "remarks";
	public static final String FILE_ID = "fileId";
	public static final String CREATE_DATE = "createDate";

}

