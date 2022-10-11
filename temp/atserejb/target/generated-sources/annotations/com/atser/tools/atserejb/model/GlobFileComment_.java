package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFileComment.class)
public abstract class GlobFileComment_ {

	public static volatile SingularAttribute<GlobFileComment, String> comments;
	public static volatile SingularAttribute<GlobFileComment, BigInteger> author;
	public static volatile SingularAttribute<GlobFileComment, Date> created;
	public static volatile SingularAttribute<GlobFileComment, String> subject;
	public static volatile SingularAttribute<GlobFileComment, BigDecimal> id;
	public static volatile SingularAttribute<GlobFileComment, BigInteger> parentId;
	public static volatile SingularAttribute<GlobFileComment, BigInteger> fileId;

	public static final String COMMENTS = "comments";
	public static final String AUTHOR = "author";
	public static final String CREATED = "created";
	public static final String SUBJECT = "subject";
	public static final String ID = "id";
	public static final String PARENT_ID = "parentId";
	public static final String FILE_ID = "fileId";

}

