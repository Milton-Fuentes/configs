package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFolderSubscribeAll.class)
public abstract class GlobFolderSubscribeAll_ {

	public static volatile SingularAttribute<GlobFolderSubscribeAll, GlobUsers> subscriberId;
	public static volatile SingularAttribute<GlobFolderSubscribeAll, BigDecimal> id;
	public static volatile SingularAttribute<GlobFolderSubscribeAll, GlobFolder> folderId;

	public static final String SUBSCRIBER_ID = "subscriberId";
	public static final String ID = "id";
	public static final String FOLDER_ID = "folderId";

}

