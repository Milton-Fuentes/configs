package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFolderSubscribe.class)
public abstract class GlobFolderSubscribe_ {

	public static volatile SingularAttribute<GlobFolderSubscribe, GlobUsers> subscriberId;
	public static volatile SingularAttribute<GlobFolderSubscribe, BigDecimal> id;
	public static volatile SingularAttribute<GlobFolderSubscribe, GlobFolder> folderId;

	public static final String SUBSCRIBER_ID = "subscriberId";
	public static final String ID = "id";
	public static final String FOLDER_ID = "folderId";

}

