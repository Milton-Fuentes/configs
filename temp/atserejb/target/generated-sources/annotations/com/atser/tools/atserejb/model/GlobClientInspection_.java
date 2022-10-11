package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientInspection.class)
public abstract class GlobClientInspection_ {

	public static volatile SingularAttribute<GlobClientInspection, BigInteger> inspectionId;
	public static volatile SingularAttribute<GlobClientInspection, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientInspection, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientInspection, String> inspectionTitle;

	public static final String INSPECTION_ID = "inspectionId";
	public static final String CLIENT_ID = "clientId";
	public static final String ID = "id";
	public static final String INSPECTION_TITLE = "inspectionTitle";

}

