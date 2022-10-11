package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QmCvlFieldData.class)
public abstract class QmCvlFieldData_ {

	public static volatile SingularAttribute<QmCvlFieldData, String> lastModBy;
	public static volatile SingularAttribute<QmCvlFieldData, String> code;
	public static volatile ListAttribute<QmCvlFieldData, GlobProjContrPersonnel> globProjContrPersonnelList;
	public static volatile SingularAttribute<QmCvlFieldData, Character> active;
	public static volatile SingularAttribute<QmCvlFieldData, BigInteger> fieldOrder;
	public static volatile SingularAttribute<QmCvlFieldData, String> version;
	public static volatile SingularAttribute<QmCvlFieldData, String> createByIp;
	public static volatile SingularAttribute<QmCvlFieldData, String> createBy;
	public static volatile SingularAttribute<QmCvlFieldData, String> lastModIp;
	public static volatile SingularAttribute<QmCvlFieldData, BigDecimal> id;
	public static volatile SingularAttribute<QmCvlFieldData, String> value;
	public static volatile SingularAttribute<QmCvlFieldData, String> lastMod;
	public static volatile SingularAttribute<QmCvlFieldData, QmCvlField> fieldId;
	public static volatile SingularAttribute<QmCvlFieldData, Date> createDate;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CODE = "code";
	public static final String GLOB_PROJ_CONTR_PERSONNEL_LIST = "globProjContrPersonnelList";
	public static final String ACTIVE = "active";
	public static final String FIELD_ORDER = "fieldOrder";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ID = "id";
	public static final String VALUE = "value";
	public static final String LAST_MOD = "lastMod";
	public static final String FIELD_ID = "fieldId";
	public static final String CREATE_DATE = "createDate";

}

