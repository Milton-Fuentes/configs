package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QalabEquipinfoV1.class)
public abstract class QalabEquipinfoV1_ {

	public static volatile SingularAttribute<QalabEquipinfoV1, Date> logDate;
	public static volatile SingularAttribute<QalabEquipinfoV1, Date> equipReceivedDate;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> purchasedDateTmp;
	public static volatile SingularAttribute<QalabEquipinfoV1, Double> equipOrigCost;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> conditionReceived;
	public static volatile SingularAttribute<QalabEquipinfoV1, GlobLabs> labId;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> inserviceDateTmp;
	public static volatile SingularAttribute<QalabEquipinfoV1, Date> purchasedDate;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> equipItemDescrip;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> model;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> equipNo;
	public static volatile SingularAttribute<QalabEquipinfoV1, BigDecimal> id;
	public static volatile ListAttribute<QalabEquipinfoV1, QalabCaliblogV1> qalabCaliblogList;
	public static volatile SingularAttribute<QalabEquipinfoV1, Date> expirationDate;
	public static volatile SingularAttribute<QalabEquipinfoV1, QalabEquiptypeV1> equipId;
	public static volatile SingularAttribute<QalabEquipinfoV1, Date> inserviceDate;
	public static volatile ListAttribute<QalabEquipinfoV1, QalabEquipclienttestV1> qalabEquipclienttestList;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> logDateTmp;
	public static volatile ListAttribute<QalabEquipinfoV1, QalabMaintlogV1> qalabMaintlogList;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> currentCondition;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> active;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> equipElectronictag;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> serialNo;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> equipRoom;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> field1;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> deleted;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> manufact;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> equipRmstag;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> field7;
	public static volatile SingularAttribute<QalabEquipinfoV1, BigInteger> field6;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> field8;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> field3;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> field2;
	public static volatile SingularAttribute<QalabEquipinfoV1, BigInteger> field5;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> status;
	public static volatile SingularAttribute<QalabEquipinfoV1, String> field4;

	public static final String LOG_DATE = "logDate";
	public static final String EQUIP_RECEIVED_DATE = "equipReceivedDate";
	public static final String PURCHASED_DATE_TMP = "purchasedDateTmp";
	public static final String EQUIP_ORIG_COST = "equipOrigCost";
	public static final String CONDITION_RECEIVED = "conditionReceived";
	public static final String LAB_ID = "labId";
	public static final String INSERVICE_DATE_TMP = "inserviceDateTmp";
	public static final String PURCHASED_DATE = "purchasedDate";
	public static final String EQUIP_ITEM_DESCRIP = "equipItemDescrip";
	public static final String MODEL = "model";
	public static final String EQUIP_NO = "equipNo";
	public static final String ID = "id";
	public static final String QALAB_CALIBLOG_LIST = "qalabCaliblogList";
	public static final String EXPIRATION_DATE = "expirationDate";
	public static final String EQUIP_ID = "equipId";
	public static final String INSERVICE_DATE = "inserviceDate";
	public static final String QALAB_EQUIPCLIENTTEST_LIST = "qalabEquipclienttestList";
	public static final String LOG_DATE_TMP = "logDateTmp";
	public static final String QALAB_MAINTLOG_LIST = "qalabMaintlogList";
	public static final String CURRENT_CONDITION = "currentCondition";
	public static final String ACTIVE = "active";
	public static final String EQUIP_ELECTRONICTAG = "equipElectronictag";
	public static final String SERIAL_NO = "serialNo";
	public static final String EQUIP_ROOM = "equipRoom";
	public static final String FIELD1 = "field1";
	public static final String DELETED = "deleted";
	public static final String MANUFACT = "manufact";
	public static final String EQUIP_RMSTAG = "equipRmstag";
	public static final String FIELD7 = "field7";
	public static final String FIELD6 = "field6";
	public static final String FIELD8 = "field8";
	public static final String FIELD3 = "field3";
	public static final String FIELD2 = "field2";
	public static final String FIELD5 = "field5";
	public static final String STATUS = "status";
	public static final String FIELD4 = "field4";

}

