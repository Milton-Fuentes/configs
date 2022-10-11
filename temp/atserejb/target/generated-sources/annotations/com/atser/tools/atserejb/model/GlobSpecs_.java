package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSpecs.class)
public abstract class GlobSpecs_ {

	public static volatile SingularAttribute<GlobSpecs, BigInteger> datatyping;
	public static volatile SingularAttribute<GlobSpecs, String> name;
	public static volatile SingularAttribute<GlobSpecs, String> description;
	public static volatile SingularAttribute<GlobSpecs, BigDecimal> id;
	public static volatile SingularAttribute<GlobSpecs, String> category;

	public static final String DATATYPING = "datatyping";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String CATEGORY = "category";

}

