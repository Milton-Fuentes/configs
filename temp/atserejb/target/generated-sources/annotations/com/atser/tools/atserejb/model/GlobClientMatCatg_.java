package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientMatCatg.class)
public abstract class GlobClientMatCatg_ {

	public static volatile SingularAttribute<GlobClientMatCatg, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientMatCatg, String> visible;
	public static volatile SingularAttribute<GlobClientMatCatg, String> matcatgTitle;
	public static volatile SingularAttribute<GlobClientMatCatg, BigInteger> matcatgId;
	public static volatile SingularAttribute<GlobClientMatCatg, BigInteger> corder;
	public static volatile SingularAttribute<GlobClientMatCatg, BigDecimal> id;

	public static final String CLIENT_ID = "clientId";
	public static final String VISIBLE = "visible";
	public static final String MATCATG_TITLE = "matcatgTitle";
	public static final String MATCATG_ID = "matcatgId";
	public static final String CORDER = "corder";
	public static final String ID = "id";

}

