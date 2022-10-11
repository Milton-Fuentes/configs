package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFolder.class)
public abstract class GlobFolder_ {

	public static volatile SingularAttribute<GlobFolder, BigInteger> owner;
	public static volatile SingularAttribute<GlobFolder, String> metadata;
	public static volatile SingularAttribute<GlobFolder, String> visible;
	public static volatile SingularAttribute<GlobFolder, Date> created;
	public static volatile SingularAttribute<GlobFolder, Date> fDate;
	public static volatile SingularAttribute<GlobFolder, Character> active;
	public static volatile SingularAttribute<GlobFolder, Character> readOnly;
	public static volatile SingularAttribute<GlobFolder, BigInteger> defaultId;
	public static volatile ListAttribute<GlobFolder, GlobFile> globFileList;
	public static volatile SingularAttribute<GlobFolder, BigInteger> parentId;
	public static volatile SingularAttribute<GlobFolder, BigInteger> defaultGroupNum;
	public static volatile SingularAttribute<GlobFolder, String> field1;
	public static volatile SingularAttribute<GlobFolder, String> fName;
	public static volatile SingularAttribute<GlobFolder, String> fDateTmp;
	public static volatile ListAttribute<GlobFolder, GlobCorrespd> globCorrespdList;
	public static volatile SingularAttribute<GlobFolder, String> fNumber;
	public static volatile SingularAttribute<GlobFolder, BigInteger> contractId;
	public static volatile SingularAttribute<GlobFolder, BigInteger> folderTypeId;
	public static volatile SingularAttribute<GlobFolder, BigDecimal> id;
	public static volatile SingularAttribute<GlobFolder, BigInteger> planProjectId;
	public static volatile SingularAttribute<GlobFolder, BigInteger> projectId;

	public static final String OWNER = "owner";
	public static final String METADATA = "metadata";
	public static final String VISIBLE = "visible";
	public static final String CREATED = "created";
	public static final String F_DATE = "fDate";
	public static final String ACTIVE = "active";
	public static final String READ_ONLY = "readOnly";
	public static final String DEFAULT_ID = "defaultId";
	public static final String GLOB_FILE_LIST = "globFileList";
	public static final String PARENT_ID = "parentId";
	public static final String DEFAULT_GROUP_NUM = "defaultGroupNum";
	public static final String FIELD1 = "field1";
	public static final String F_NAME = "fName";
	public static final String F_DATE_TMP = "fDateTmp";
	public static final String GLOB_CORRESPD_LIST = "globCorrespdList";
	public static final String F_NUMBER = "fNumber";
	public static final String CONTRACT_ID = "contractId";
	public static final String FOLDER_TYPE_ID = "folderTypeId";
	public static final String ID = "id";
	public static final String PLAN_PROJECT_ID = "planProjectId";
	public static final String PROJECT_ID = "projectId";

}

