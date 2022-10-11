package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobIaType.class)
public abstract class GlobIaType_ {

	public static volatile SingularAttribute<GlobIaType, String> iaShortname;
	public static volatile SingularAttribute<GlobIaType, BigInteger> clientId;
	public static volatile SingularAttribute<GlobIaType, BigInteger> listOrder;
	public static volatile SingularAttribute<GlobIaType, String> iaType;
	public static volatile SingularAttribute<GlobIaType, String> description;
	public static volatile SingularAttribute<GlobIaType, BigDecimal> id;

	public static final String IA_SHORTNAME = "iaShortname";
	public static final String CLIENT_ID = "clientId";
	public static final String LIST_ORDER = "listOrder";
	public static final String IA_TYPE = "iaType";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}

