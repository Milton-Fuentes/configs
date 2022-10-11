package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobClientNotify.class)
public abstract class GlobClientNotify_ {

	public static volatile SingularAttribute<GlobClientNotify, String> fileName;
	public static volatile SingularAttribute<GlobClientNotify, BigInteger> clientId;
	public static volatile SingularAttribute<GlobClientNotify, BigDecimal> id;
	public static volatile SingularAttribute<GlobClientNotify, String> type;
	public static volatile SingularAttribute<GlobClientNotify, String> email;

	public static final String FILE_NAME = "fileName";
	public static final String CLIENT_ID = "clientId";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String EMAIL = "email";

}

