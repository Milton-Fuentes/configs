package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSievelist.class)
public abstract class GlobSievelist_ {

	public static volatile SingularAttribute<GlobSievelist, String> commonName;
	public static volatile SingularAttribute<GlobSievelist, Double> mmSize;
	public static volatile SingularAttribute<GlobSievelist, BigInteger> ordering;
	public static volatile SingularAttribute<GlobSievelist, String> inchHoles;
	public static volatile SingularAttribute<GlobSievelist, String> trackfld;
	public static volatile SingularAttribute<GlobSievelist, BigDecimal> id;
	public static volatile SingularAttribute<GlobSievelist, Character> nameMeasureType;

	public static final String COMMON_NAME = "commonName";
	public static final String MM_SIZE = "mmSize";
	public static final String ORDERING = "ordering";
	public static final String INCH_HOLES = "inchHoles";
	public static final String TRACKFLD = "trackfld";
	public static final String ID = "id";
	public static final String NAME_MEASURE_TYPE = "nameMeasureType";

}

