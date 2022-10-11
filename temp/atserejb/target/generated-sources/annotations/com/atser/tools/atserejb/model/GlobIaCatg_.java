package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobIaCatg.class)
public abstract class GlobIaCatg_ {

	public static volatile SingularAttribute<GlobIaCatg, BigInteger> iaTypeId;
	public static volatile SingularAttribute<GlobIaCatg, BigInteger> clientId;
	public static volatile SingularAttribute<GlobIaCatg, BigInteger> listOrder;
	public static volatile SingularAttribute<GlobIaCatg, String> description;
	public static volatile SingularAttribute<GlobIaCatg, String> iaCatg;
	public static volatile SingularAttribute<GlobIaCatg, BigDecimal> id;

	public static final String IA_TYPE_ID = "iaTypeId";
	public static final String CLIENT_ID = "clientId";
	public static final String LIST_ORDER = "listOrder";
	public static final String DESCRIPTION = "description";
	public static final String IA_CATG = "iaCatg";
	public static final String ID = "id";

}

