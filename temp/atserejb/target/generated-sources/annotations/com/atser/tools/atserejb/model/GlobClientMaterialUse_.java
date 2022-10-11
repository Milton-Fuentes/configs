package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientMaterialUse.class)
public abstract class GlobClientMaterialUse_ {

	public static volatile SingularAttribute<GlobClientMaterialUse, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientMaterialUse, BigInteger> listOrder;
	public static volatile SingularAttribute<GlobClientMaterialUse, String> materialUse;
	public static volatile SingularAttribute<GlobClientMaterialUse, String> section;
	public static volatile SingularAttribute<GlobClientMaterialUse, BigDecimal> id;

	public static final String CLIENT_ID = "clientId";
	public static final String LIST_ORDER = "listOrder";
	public static final String MATERIAL_USE = "materialUse";
	public static final String SECTION = "section";
	public static final String ID = "id";

}

