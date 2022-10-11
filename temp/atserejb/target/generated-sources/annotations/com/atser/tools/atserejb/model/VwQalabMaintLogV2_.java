package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwQalabMaintLogV2.class)
public abstract class VwQalabMaintLogV2_ {

	public static volatile SingularAttribute<VwQalabMaintLogV2, String> infModel;
	public static volatile SingularAttribute<VwQalabMaintLogV2, BigInteger> partIntervalM;
	public static volatile SingularAttribute<VwQalabMaintLogV2, String> typeItem;
	public static volatile SingularAttribute<VwQalabMaintLogV2, Date> infPurchasedDate;
	public static volatile SingularAttribute<VwQalabMaintLogV2, Date> infExpirationDate;
	public static volatile SingularAttribute<VwQalabMaintLogV2, GlobLabsMaster> labId;
	public static volatile SingularAttribute<VwQalabMaintLogV2, BigDecimal> id;
	public static volatile SingularAttribute<VwQalabMaintLogV2, Double> infEquipOrigCost;
	public static volatile SingularAttribute<VwQalabMaintLogV2, Date> logMaintDueDate;
	public static volatile SingularAttribute<VwQalabMaintLogV2, String> infEquipElectronictag;
	public static volatile SingularAttribute<VwQalabMaintLogV2, BigInteger> equipId;
	public static volatile SingularAttribute<VwQalabMaintLogV2, String> infManufact;
	public static volatile SingularAttribute<VwQalabMaintLogV2, String> infActive;
	public static volatile SingularAttribute<VwQalabMaintLogV2, String> infEquipItemDescrip;
	public static volatile SingularAttribute<VwQalabMaintLogV2, String> infEquipRmstag;
	public static volatile SingularAttribute<VwQalabMaintLogV2, Date> infEquipReceivedDate;
	public static volatile SingularAttribute<VwQalabMaintLogV2, Date> infInserviceDate;
	public static volatile SingularAttribute<VwQalabMaintLogV2, BigDecimal> rowId;
	public static volatile SingularAttribute<VwQalabMaintLogV2, String> serialNo;
	public static volatile SingularAttribute<VwQalabMaintLogV2, Date> logMaintDate;
	public static volatile SingularAttribute<VwQalabMaintLogV2, String> typeProcedure;
	public static volatile SingularAttribute<VwQalabMaintLogV2, String> infEquipRoom;
	public static volatile SingularAttribute<VwQalabMaintLogV2, BigInteger> typeCatgId;
	public static volatile SingularAttribute<VwQalabMaintLogV2, String> partEquipPartName;
	public static volatile SingularAttribute<VwQalabMaintLogV2, String> infConditionReceived;

	public static final String INF_MODEL = "infModel";
	public static final String PART_INTERVAL_M = "partIntervalM";
	public static final String TYPE_ITEM = "typeItem";
	public static final String INF_PURCHASED_DATE = "infPurchasedDate";
	public static final String INF_EXPIRATION_DATE = "infExpirationDate";
	public static final String LAB_ID = "labId";
	public static final String ID = "id";
	public static final String INF_EQUIP_ORIG_COST = "infEquipOrigCost";
	public static final String LOG_MAINT_DUE_DATE = "logMaintDueDate";
	public static final String INF_EQUIP_ELECTRONICTAG = "infEquipElectronictag";
	public static final String EQUIP_ID = "equipId";
	public static final String INF_MANUFACT = "infManufact";
	public static final String INF_ACTIVE = "infActive";
	public static final String INF_EQUIP_ITEM_DESCRIP = "infEquipItemDescrip";
	public static final String INF_EQUIP_RMSTAG = "infEquipRmstag";
	public static final String INF_EQUIP_RECEIVED_DATE = "infEquipReceivedDate";
	public static final String INF_INSERVICE_DATE = "infInserviceDate";
	public static final String ROW_ID = "rowId";
	public static final String SERIAL_NO = "serialNo";
	public static final String LOG_MAINT_DATE = "logMaintDate";
	public static final String TYPE_PROCEDURE = "typeProcedure";
	public static final String INF_EQUIP_ROOM = "infEquipRoom";
	public static final String TYPE_CATG_ID = "typeCatgId";
	public static final String PART_EQUIP_PART_NAME = "partEquipPartName";
	public static final String INF_CONDITION_RECEIVED = "infConditionReceived";

}

