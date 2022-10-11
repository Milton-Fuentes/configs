package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(WsRigths.class)
public abstract class WsRigths_ {

	public static volatile SingularAttribute<WsRigths, String> cidr;
	public static volatile SingularAttribute<WsRigths, BigDecimal> id;
	public static volatile SingularAttribute<WsRigths, String> rmode;
	public static volatile SingularAttribute<WsRigths, WsRepository> serviceid;
	public static volatile SingularAttribute<WsRigths, WsUsers> userid;

	public static final String CIDR = "cidr";
	public static final String ID = "id";
	public static final String RMODE = "rmode";
	public static final String SERVICEID = "serviceid";
	public static final String USERID = "userid";

}

