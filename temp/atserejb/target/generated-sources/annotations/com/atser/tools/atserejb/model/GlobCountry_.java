package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobCountry.class)
public abstract class GlobCountry_ {

	public static volatile SingularAttribute<GlobCountry, String> name;
	public static volatile SingularAttribute<GlobCountry, BigDecimal> id;
	public static volatile SingularAttribute<GlobCountry, String> shortName;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String SHORT_NAME = "shortName";

}

