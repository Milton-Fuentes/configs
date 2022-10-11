package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobEquipment.class)
public abstract class GlobEquipment_ {

	public static volatile SingularAttribute<GlobEquipment, BigInteger> tableOrder;
	public static volatile SingularAttribute<GlobEquipment, String> createBy;
	public static volatile SingularAttribute<GlobEquipment, BigInteger> clientId;
	public static volatile SingularAttribute<GlobEquipment, String> lastModBy;
	public static volatile SingularAttribute<GlobEquipment, String> lastModIp;
	public static volatile SingularAttribute<GlobEquipment, String> equipment;
	public static volatile SingularAttribute<GlobEquipment, String> description;
	public static volatile SingularAttribute<GlobEquipment, BigDecimal> id;
	public static volatile SingularAttribute<GlobEquipment, String> lastMod;
	public static volatile SingularAttribute<GlobEquipment, String> version;
	public static volatile SingularAttribute<GlobEquipment, Double> invtQuantity;
	public static volatile SingularAttribute<GlobEquipment, String> createByIp;

	public static final String TABLE_ORDER = "tableOrder";
	public static final String CREATE_BY = "createBy";
	public static final String CLIENT_ID = "clientId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String EQUIPMENT = "equipment";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String VERSION = "version";
	public static final String INVT_QUANTITY = "invtQuantity";
	public static final String CREATE_BY_IP = "createByIp";

}

