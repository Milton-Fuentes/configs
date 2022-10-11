package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QalabEquiptypeV2.class)
public abstract class QalabEquiptypeV2_ {

	public static volatile SingularAttribute<QalabEquiptypeV2, String> item;
	public static volatile SingularAttribute<QalabEquiptypeV2, String> comments;
	public static volatile SingularAttribute<QalabEquiptypeV2, String> calibMethod;
	public static volatile ListAttribute<QalabEquiptypeV2, QalabEquipinfoV2> qalabEquipInfoList;
	public static volatile SingularAttribute<QalabEquiptypeV2, String> active;
	public static volatile SingularAttribute<QalabEquiptypeV2, String> procedure;
	public static volatile SingularAttribute<QalabEquiptypeV2, BigInteger> folderId;
	public static volatile ListAttribute<QalabEquiptypeV2, QalabMainttypeV2> qalabMainttypeList;
	public static volatile SingularAttribute<QalabEquiptypeV2, QalabEquipcatgV2> catgId;
	public static volatile SingularAttribute<QalabEquiptypeV2, String> field1;
	public static volatile SingularAttribute<QalabEquiptypeV2, String> deleted;
	public static volatile SingularAttribute<QalabEquiptypeV2, BigInteger> intervalM;
	public static volatile SingularAttribute<QalabEquiptypeV2, String> field7;
	public static volatile SingularAttribute<QalabEquiptypeV2, BigInteger> field6;
	public static volatile SingularAttribute<QalabEquiptypeV2, BigDecimal> id;
	public static volatile SingularAttribute<QalabEquiptypeV2, String> field8;
	public static volatile SingularAttribute<QalabEquiptypeV2, String> field3;
	public static volatile SingularAttribute<QalabEquiptypeV2, String> field2;
	public static volatile SingularAttribute<QalabEquiptypeV2, BigInteger> field5;
	public static volatile SingularAttribute<QalabEquiptypeV2, String> field4;

	public static final String ITEM = "item";
	public static final String COMMENTS = "comments";
	public static final String CALIB_METHOD = "calibMethod";
	public static final String QALAB_EQUIP_INFO_LIST = "qalabEquipInfoList";
	public static final String ACTIVE = "active";
	public static final String PROCEDURE = "procedure";
	public static final String FOLDER_ID = "folderId";
	public static final String QALAB_MAINTTYPE_LIST = "qalabMainttypeList";
	public static final String CATG_ID = "catgId";
	public static final String FIELD1 = "field1";
	public static final String DELETED = "deleted";
	public static final String INTERVAL_M = "intervalM";
	public static final String FIELD7 = "field7";
	public static final String FIELD6 = "field6";
	public static final String ID = "id";
	public static final String FIELD8 = "field8";
	public static final String FIELD3 = "field3";
	public static final String FIELD2 = "field2";
	public static final String FIELD5 = "field5";
	public static final String FIELD4 = "field4";

}

