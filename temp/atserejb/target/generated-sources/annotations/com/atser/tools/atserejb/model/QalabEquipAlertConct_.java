package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QalabEquipAlertConct.class)
public abstract class QalabEquipAlertConct_ {

	public static volatile SingularAttribute<QalabEquipAlertConct, String> createdByIp;
	public static volatile SingularAttribute<QalabEquipAlertConct, String> lastModIp;
	public static volatile SingularAttribute<QalabEquipAlertConct, String> lastModBy;
	public static volatile SingularAttribute<QalabEquipAlertConct, Character> deleted;
	public static volatile SingularAttribute<QalabEquipAlertConct, GlobContact> contactId;
	public static volatile SingularAttribute<QalabEquipAlertConct, String> createdBy;
	public static volatile SingularAttribute<QalabEquipAlertConct, Date> created;
	public static volatile SingularAttribute<QalabEquipAlertConct, Character> active;
	public static volatile SingularAttribute<QalabEquipAlertConct, BigDecimal> id;
	public static volatile SingularAttribute<QalabEquipAlertConct, BigInteger> alertId;
	public static volatile SingularAttribute<QalabEquipAlertConct, Date> lastMod;
	public static volatile SingularAttribute<QalabEquipAlertConct, Integer> version;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String DELETED = "deleted";
	public static final String CONTACT_ID = "contactId";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String ALERT_ID = "alertId";
	public static final String LAST_MOD = "lastMod";
	public static final String VERSION = "version";

}

