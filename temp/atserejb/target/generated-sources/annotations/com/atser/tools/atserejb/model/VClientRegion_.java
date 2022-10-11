package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VClientRegion.class)
public abstract class VClientRegion_ {

	public static volatile SingularAttribute<VClientRegion, String> code;
	public static volatile SingularAttribute<VClientRegion, BigInteger> clientId;
	public static volatile SingularAttribute<VClientRegion, String> name;
	public static volatile SingularAttribute<VClientRegion, Character> active;
	public static volatile SingularAttribute<VClientRegion, BigDecimal> id;

	public static final String CODE = "code";
	public static final String CLIENT_ID = "clientId";
	public static final String NAME = "name";
	public static final String ACTIVE = "active";
	public static final String ID = "id";

}

