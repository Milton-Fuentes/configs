package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaPlistStruct.class)
public abstract class QaPlistStruct_ {

	public static volatile SingularAttribute<QaPlistStruct, String> structType;
	public static volatile SingularAttribute<QaPlistStruct, BigDecimal> id;
	public static volatile SingularAttribute<QaPlistStruct, Integer> itemTypeId;
	public static volatile SingularAttribute<QaPlistStruct, String> descript;
	public static volatile ListAttribute<QaPlistStruct, QaPlist> qaPlist;

	public static final String STRUCT_TYPE = "structType";
	public static final String ID = "id";
	public static final String ITEM_TYPE_ID = "itemTypeId";
	public static final String DESCRIPT = "descript";
	public static final String QA_PLIST = "qaPlist";

}

