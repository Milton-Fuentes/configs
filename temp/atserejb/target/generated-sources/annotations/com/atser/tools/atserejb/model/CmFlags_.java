package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmFlags.class)
public abstract class CmFlags_ {

	public static volatile SingularAttribute<CmFlags, Character> defaultValue;
	public static volatile SingularAttribute<CmFlags, String> flagName;
	public static volatile SingularAttribute<CmFlags, String> description;
	public static volatile SingularAttribute<CmFlags, BigDecimal> id;

	public static final String DEFAULT_VALUE = "defaultValue";
	public static final String FLAG_NAME = "flagName";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}

