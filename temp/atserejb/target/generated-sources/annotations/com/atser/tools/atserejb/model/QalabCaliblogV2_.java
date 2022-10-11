package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QalabCaliblogV2.class)
public abstract class QalabCaliblogV2_ {

	public static volatile SingularAttribute<QalabCaliblogV2, String> comments;
	public static volatile SingularAttribute<QalabCaliblogV2, Date> calibDate;
	public static volatile SingularAttribute<QalabCaliblogV2, BigInteger> folderId;
	public static volatile SingularAttribute<QalabCaliblogV2, String> field1;
	public static volatile SingularAttribute<QalabCaliblogV2, String> deleted;
	public static volatile SingularAttribute<QalabCaliblogV2, String> performedby;
	public static volatile SingularAttribute<QalabCaliblogV2, String> field7;
	public static volatile SingularAttribute<QalabCaliblogV2, String> calibDateTmp;
	public static volatile SingularAttribute<QalabCaliblogV2, BigInteger> field6;
	public static volatile SingularAttribute<QalabCaliblogV2, BigDecimal> id;
	public static volatile SingularAttribute<QalabCaliblogV2, String> field8;
	public static volatile SingularAttribute<QalabCaliblogV2, String> field3;
	public static volatile SingularAttribute<QalabCaliblogV2, String> field2;
	public static volatile SingularAttribute<QalabCaliblogV2, QalabEquipinfoV2> labEquipId;
	public static volatile SingularAttribute<QalabCaliblogV2, BigInteger> field5;
	public static volatile SingularAttribute<QalabCaliblogV2, String> field4;

	public static final String COMMENTS = "comments";
	public static final String CALIB_DATE = "calibDate";
	public static final String FOLDER_ID = "folderId";
	public static final String FIELD1 = "field1";
	public static final String DELETED = "deleted";
	public static final String PERFORMEDBY = "performedby";
	public static final String FIELD7 = "field7";
	public static final String CALIB_DATE_TMP = "calibDateTmp";
	public static final String FIELD6 = "field6";
	public static final String ID = "id";
	public static final String FIELD8 = "field8";
	public static final String FIELD3 = "field3";
	public static final String FIELD2 = "field2";
	public static final String LAB_EQUIP_ID = "labEquipId";
	public static final String FIELD5 = "field5";
	public static final String FIELD4 = "field4";

}

