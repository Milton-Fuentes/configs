package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFolderDefaultLink.class)
public abstract class GlobFolderDefaultLink_ {

	public static volatile SingularAttribute<GlobFolderDefaultLink, String> fLink;
	public static volatile SingularAttribute<GlobFolderDefaultLink, BigInteger> parentTypeId;
	public static volatile SingularAttribute<GlobFolderDefaultLink, Character> autoCreate;
	public static volatile SingularAttribute<GlobFolderDefaultLink, BigDecimal> id;
	public static volatile SingularAttribute<GlobFolderDefaultLink, GlobFolderDefault> childId;
	public static volatile SingularAttribute<GlobFolderDefaultLink, BigInteger> groupNumber;
	public static volatile SingularAttribute<GlobFolderDefaultLink, BigInteger> parentId;

	public static final String F_LINK = "fLink";
	public static final String PARENT_TYPE_ID = "parentTypeId";
	public static final String AUTO_CREATE = "autoCreate";
	public static final String ID = "id";
	public static final String CHILD_ID = "childId";
	public static final String GROUP_NUMBER = "groupNumber";
	public static final String PARENT_ID = "parentId";

}

