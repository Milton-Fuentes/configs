package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFunctions.class)
public abstract class GlobFunctions_ {

	public static volatile SingularAttribute<GlobFunctions, BigInteger> projectTypeId;
	public static volatile SingularAttribute<GlobFunctions, String> fName;
	public static volatile ListAttribute<GlobFunctions, GlobLabs> globLabsList;
	public static volatile SingularAttribute<GlobFunctions, String> description;
	public static volatile ListAttribute<GlobFunctions, GlobProfiles> globProfilesList;
	public static volatile SingularAttribute<GlobFunctions, BigDecimal> id;

	public static final String PROJECT_TYPE_ID = "projectTypeId";
	public static final String F_NAME = "fName";
	public static final String GLOB_LABS_LIST = "globLabsList";
	public static final String DESCRIPTION = "description";
	public static final String GLOB_PROFILES_LIST = "globProfilesList";
	public static final String ID = "id";

}

