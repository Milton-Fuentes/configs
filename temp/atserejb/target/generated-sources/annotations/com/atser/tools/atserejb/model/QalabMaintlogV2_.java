package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QalabMaintlogV2.class)
public abstract class QalabMaintlogV2_ {

	public static volatile SingularAttribute<QalabMaintlogV2, QalabMainttypeV2> equipMaintTypeid;
	public static volatile SingularAttribute<QalabMaintlogV2, Date> maintDate;
	public static volatile SingularAttribute<QalabMaintlogV2, String> performedby;
	public static volatile SingularAttribute<QalabMaintlogV2, String> deleted;
	public static volatile SingularAttribute<QalabMaintlogV2, QalabEquipinfoV2> equipInfoid;
	public static volatile SingularAttribute<QalabMaintlogV2, String> description;
	public static volatile SingularAttribute<QalabMaintlogV2, BigDecimal> id;
	public static volatile SingularAttribute<QalabMaintlogV2, BigInteger> folderId;
	public static volatile SingularAttribute<QalabMaintlogV2, Date> maintDueDate;

	public static final String EQUIP_MAINT_TYPEID = "equipMaintTypeid";
	public static final String MAINT_DATE = "maintDate";
	public static final String PERFORMEDBY = "performedby";
	public static final String DELETED = "deleted";
	public static final String EQUIP_INFOID = "equipInfoid";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String FOLDER_ID = "folderId";
	public static final String MAINT_DUE_DATE = "maintDueDate";

}

