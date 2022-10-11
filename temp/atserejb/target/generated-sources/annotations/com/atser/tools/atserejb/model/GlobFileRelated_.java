package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFileRelated.class)
public abstract class GlobFileRelated_ {

	public static volatile SingularAttribute<GlobFileRelated, BigInteger> owner;
	public static volatile SingularAttribute<GlobFileRelated, Date> created;
	public static volatile SingularAttribute<GlobFileRelated, BigDecimal> id;
	public static volatile SingularAttribute<GlobFileRelated, BigInteger> relatedId;
	public static volatile SingularAttribute<GlobFileRelated, BigInteger> fileId;

	public static final String OWNER = "owner";
	public static final String CREATED = "created";
	public static final String ID = "id";
	public static final String RELATED_ID = "relatedId";
	public static final String FILE_ID = "fileId";

}

