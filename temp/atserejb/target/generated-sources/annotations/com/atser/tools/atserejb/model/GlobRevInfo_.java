package com.atser.tools.atserejb.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobRevInfo.class)
public abstract class GlobRevInfo_ extends org.hibernate.envers.DefaultRevisionEntity_ {

	public static volatile SingularAttribute<GlobRevInfo, String> role;
	public static volatile SingularAttribute<GlobRevInfo, String> modip;
	public static volatile SingularAttribute<GlobRevInfo, String> username;

	public static final String ROLE = "role";
	public static final String MODIP = "modip";
	public static final String USERNAME = "username";

}

