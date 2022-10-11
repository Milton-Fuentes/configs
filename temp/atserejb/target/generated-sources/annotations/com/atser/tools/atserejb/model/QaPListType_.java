package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaPListType.class)
public abstract class QaPListType_ {

	public static volatile SingularAttribute<QaPListType, String> itemType;
	public static volatile SingularAttribute<QaPListType, BigInteger> clientId;
	public static volatile SingularAttribute<QaPListType, BigDecimal> id;
	public static volatile SingularAttribute<QaPListType, String> descript;
	public static volatile ListAttribute<QaPListType, QaPlist> qaPlist;

	public static final String ITEM_TYPE = "itemType";
	public static final String CLIENT_ID = "clientId";
	public static final String ID = "id";
	public static final String DESCRIPT = "descript";
	public static final String QA_PLIST = "qaPlist";

}

