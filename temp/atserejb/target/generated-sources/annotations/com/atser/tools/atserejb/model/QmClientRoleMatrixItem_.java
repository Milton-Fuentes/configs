package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QmClientRoleMatrixItem.class)
public abstract class QmClientRoleMatrixItem_ {

	public static volatile SingularAttribute<QmClientRoleMatrixItem, String> itemName;
	public static volatile SingularAttribute<QmClientRoleMatrixItem, String> itemType;
	public static volatile SingularAttribute<QmClientRoleMatrixItem, BigInteger> itemOrder;
	public static volatile SingularAttribute<QmClientRoleMatrixItem, BigDecimal> id;
	public static volatile SingularAttribute<QmClientRoleMatrixItem, String> itemCaption;

	public static final String ITEM_NAME = "itemName";
	public static final String ITEM_TYPE = "itemType";
	public static final String ITEM_ORDER = "itemOrder";
	public static final String ID = "id";
	public static final String ITEM_CAPTION = "itemCaption";

}

