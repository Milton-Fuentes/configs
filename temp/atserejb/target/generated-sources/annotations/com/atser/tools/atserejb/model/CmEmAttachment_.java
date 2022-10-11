package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmEmAttachment.class)
public abstract class CmEmAttachment_ {

	public static volatile SingularAttribute<CmEmAttachment, String> serverPath;
	public static volatile SingularAttribute<CmEmAttachment, String> fName;
	public static volatile SingularAttribute<CmEmAttachment, BigInteger> fileSize;
	public static volatile SingularAttribute<CmEmAttachment, String> fileExtension;
	public static volatile SingularAttribute<CmEmAttachment, String> fileTitle;
	public static volatile SingularAttribute<CmEmAttachment, BigInteger> referId;
	public static volatile SingularAttribute<CmEmAttachment, BigInteger> emailId;
	public static volatile SingularAttribute<CmEmAttachment, BigDecimal> id;
	public static volatile SingularAttribute<CmEmAttachment, String> sourcePath;
	public static volatile SingularAttribute<CmEmAttachment, String> status;

	public static final String SERVER_PATH = "serverPath";
	public static final String F_NAME = "fName";
	public static final String FILE_SIZE = "fileSize";
	public static final String FILE_EXTENSION = "fileExtension";
	public static final String FILE_TITLE = "fileTitle";
	public static final String REFER_ID = "referId";
	public static final String EMAIL_ID = "emailId";
	public static final String ID = "id";
	public static final String SOURCE_PATH = "sourcePath";
	public static final String STATUS = "status";

}

