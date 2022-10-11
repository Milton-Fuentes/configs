package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFileArchiveEntry.class)
public abstract class GlobFileArchiveEntry_ {

	public static volatile SingularAttribute<GlobFileArchiveEntry, String> vName;
	public static volatile SingularAttribute<GlobFileArchiveEntry, String> pName;
	public static volatile SingularAttribute<GlobFileArchiveEntry, BigInteger> fileSize;
	public static volatile SingularAttribute<GlobFileArchiveEntry, Date> uploaded;
	public static volatile SingularAttribute<GlobFileArchiveEntry, BigDecimal> id;
	public static volatile SingularAttribute<GlobFileArchiveEntry, Date> lastModified;
	public static volatile SingularAttribute<GlobFileArchiveEntry, GlobFileArchive> archiveId;
	public static volatile SingularAttribute<GlobFileArchiveEntry, String> status;

	public static final String V_NAME = "vName";
	public static final String P_NAME = "pName";
	public static final String FILE_SIZE = "fileSize";
	public static final String UPLOADED = "uploaded";
	public static final String ID = "id";
	public static final String LAST_MODIFIED = "lastModified";
	public static final String ARCHIVE_ID = "archiveId";
	public static final String STATUS = "status";

}

