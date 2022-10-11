package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientEquipcatg.class)
public abstract class GlobClientEquipcatg_ {

	public static volatile SingularAttribute<GlobClientEquipcatg, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientEquipcatg, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientEquipcatg, QalabEquipcatgV2> equipCatgId;
	public static volatile SingularAttribute<GlobClientEquipcatg, String> equipCatgTitle;

	public static final String CLIENT_ID = "clientId";
	public static final String ID = "id";
	public static final String EQUIP_CATG_ID = "equipCatgId";
	public static final String EQUIP_CATG_TITLE = "equipCatgTitle";

}

