package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFileSubscribe.class)
public abstract class GlobFileSubscribe_ {

	public static volatile SingularAttribute<GlobFileSubscribe, GlobUsers> subscriberId;
	public static volatile SingularAttribute<GlobFileSubscribe, BigDecimal> id;
	public static volatile SingularAttribute<GlobFileSubscribe, GlobFile> fileId;

	public static final String SUBSCRIBER_ID = "subscriberId";
	public static final String ID = "id";
	public static final String FILE_ID = "fileId";

}

