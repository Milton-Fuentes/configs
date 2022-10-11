package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFileTkShare.class)
public abstract class GlobFileTkShare_ {

	public static volatile SingularAttribute<GlobFileTkShare, String> toStkGroupId;
	public static volatile SingularAttribute<GlobFileTkShare, GlobFileTk> fileTkId;
	public static volatile SingularAttribute<GlobFileTkShare, String> toUserGroupId;
	public static volatile SingularAttribute<GlobFileTkShare, BigDecimal> id;
	public static volatile SingularAttribute<GlobFileTkShare, String> toUserId;
	public static volatile SingularAttribute<GlobFileTkShare, String> toStkId;

	public static final String TO_STK_GROUP_ID = "toStkGroupId";
	public static final String FILE_TK_ID = "fileTkId";
	public static final String TO_USER_GROUP_ID = "toUserGroupId";
	public static final String ID = "id";
	public static final String TO_USER_ID = "toUserId";
	public static final String TO_STK_ID = "toStkId";

}

