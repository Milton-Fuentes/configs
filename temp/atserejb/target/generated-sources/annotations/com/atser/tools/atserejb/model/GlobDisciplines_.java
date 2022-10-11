package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobDisciplines.class)
public abstract class GlobDisciplines_ {

	public static volatile SingularAttribute<GlobDisciplines, String> name;
	public static volatile SingularAttribute<GlobDisciplines, String> description;
	public static volatile ListAttribute<GlobDisciplines, GlobProfiles> globProfilesList;
	public static volatile SingularAttribute<GlobDisciplines, BigDecimal> id;
	public static volatile SingularAttribute<GlobDisciplines, BigInteger> projectId;

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String GLOB_PROFILES_LIST = "globProfilesList";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";

}

