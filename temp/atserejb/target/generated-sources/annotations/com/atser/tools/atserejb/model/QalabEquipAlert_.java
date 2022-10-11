package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QalabEquipAlert.class)
public abstract class QalabEquipAlert_ {

	public static volatile SingularAttribute<QalabEquipAlert, String> createdByIp;
	public static volatile SingularAttribute<QalabEquipAlert, BigInteger> clientId;
	public static volatile SingularAttribute<QalabEquipAlert, String> alertType;
	public static volatile SingularAttribute<QalabEquipAlert, String> lastModBy;
	public static volatile SingularAttribute<QalabEquipAlert, Date> created;
	public static volatile SingularAttribute<QalabEquipAlert, Character> active;
	public static volatile SingularAttribute<QalabEquipAlert, Integer> alertAtDays;
	public static volatile SingularAttribute<QalabEquipAlert, Integer> version;
	public static volatile SingularAttribute<QalabEquipAlert, String> lastModIp;
	public static volatile SingularAttribute<QalabEquipAlert, Character> deleted;
	public static volatile SingularAttribute<QalabEquipAlert, String> createdBy;
	public static volatile ListAttribute<QalabEquipAlert, QalabEquipAlertConct> qalabEquipAlertConctList;
	public static volatile SingularAttribute<QalabEquipAlert, BigDecimal> id;
	public static volatile SingularAttribute<QalabEquipAlert, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String ALERT_TYPE = "alertType";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String ALERT_AT_DAYS = "alertAtDays";
	public static final String VERSION = "version";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String QALAB_EQUIP_ALERT_CONCT_LIST = "qalabEquipAlertConctList";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

