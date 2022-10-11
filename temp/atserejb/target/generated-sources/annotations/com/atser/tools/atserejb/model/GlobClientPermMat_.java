package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientPermMat.class)
public abstract class GlobClientPermMat_ {

	public static volatile SingularAttribute<GlobClientPermMat, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientPermMat, BigInteger> permMatId;
	public static volatile SingularAttribute<GlobClientPermMat, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientPermMat, String> permMatTitle;

	public static final String CLIENT_ID = "clientId";
	public static final String PERM_MAT_ID = "permMatId";
	public static final String ID = "id";
	public static final String PERM_MAT_TITLE = "permMatTitle";

}

