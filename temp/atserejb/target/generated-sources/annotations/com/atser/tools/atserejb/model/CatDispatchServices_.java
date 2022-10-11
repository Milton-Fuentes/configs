package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CatDispatchServices.class)
public abstract class CatDispatchServices_ {

	public static volatile SingularAttribute<CatDispatchServices, String> abrv;
	public static volatile SingularAttribute<CatDispatchServices, String> cname;
	public static volatile SingularAttribute<CatDispatchServices, BigInteger> corder;
	public static volatile SingularAttribute<CatDispatchServices, BigDecimal> id;
	public static volatile SingularAttribute<CatDispatchServices, String> descriptionTpl;
	public static volatile SingularAttribute<CatDispatchServices, String> status;

	public static final String ABRV = "abrv";
	public static final String CNAME = "cname";
	public static final String CORDER = "corder";
	public static final String ID = "id";
	public static final String DESCRIPTION_TPL = "descriptionTpl";
	public static final String STATUS = "status";

}

